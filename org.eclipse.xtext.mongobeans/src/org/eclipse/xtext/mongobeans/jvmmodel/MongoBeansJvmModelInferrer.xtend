package org.eclipse.xtext.mongobeans.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.util.Primitives
import org.eclipse.xtext.mongobeans.mongoBeans.MongoBean
import org.eclipse.xtext.mongobeans.mongoBeans.MongoFile
import org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation
import org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

import static org.eclipse.emf.ecore.util.EcoreUtil.*

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * @author Jan Koehnlein 
 */
class MongoBeansJvmModelInferrer extends AbstractModelInferrer {

	@Inject extension JvmTypesBuilder

	@Inject extension IQualifiedNameProvider
	
	@Inject extension TypeReferenceSerializer
	
	@Inject extension MongoTypes
	
	@Inject extension Primitives
	
	@Inject extension IJvmModelAssociations associations

   	def dispatch void infer(MongoFile file, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
   		for(bean : file.eAllOfType(typeof(MongoBean))) {
	   		acceptor.accept(bean.toClass(bean.fullyQualifiedName))
	   			.initializeLater([
	   				documentation = bean.documentation
	   				superTypes += newTypeRef(bean, 'org.eclipse.xtext.mongobeans.IMongoBean')
	   				addConstructors(bean)
	   				addDbObjectProperty(bean)
	   				for(feature: bean.features) {
	   					switch feature {
	   						MongoProperty:
		   						if(feature.many)
		   							addListAccessor(feature)
		   						else
		   							addDelegateAccessors(feature)
	   						MongoOperation:
	   							addMethod(feature)
	   					}
	   				}
	   			])
   		}
   	}
   	
   	def protected addConstructors(JvmDeclaredType inferredType, MongoBean bean) {
		inferredType.members += bean.toConstructor [
			documentation = '''Creates a new «bean.name» wrapping the given {@link DBObject}.'''
			parameters += toParameter("dbObject", newTypeRef(bean, 'com.mongodb.DBObject'))
			body = [
				append('this._dbObject = dbObject;')
			]
		]
		inferredType.members += bean.toConstructor [
			documentation = '''Creates a new «bean.name» wrapping a new {@link BasicDBObject}.'''
			body = [
				append('_dbObject = new ')
				serialize(newTypeRef(bean, 'com.mongodb.BasicDBObject'), bean, it)
				append('();\n')
				append('''
					_dbObject.put(JAVA_CLASS_KEY, "«inferredType.identifier»");
				''')
			]					
		]   	
	}
	
	def protected addDbObjectProperty(JvmDeclaredType inferredType, MongoBean bean) {
		inferredType.members += bean.toField('_dbObject', newTypeRef(bean, 'com.mongodb.DBObject'))
		inferredType.members += bean.toGetter('dbObject', '_dbObject', newTypeRef(bean, 'com.mongodb.DBObject'))
	}

	def protected addListAccessor(JvmDeclaredType inferredType, MongoProperty property) {
		if(isMongoPrimitiveType(property.jvmType)) {
			inferredType.members += property.toMethod('get' + property.name.toFirstUpper, 
				newTypeRef(property, 'java.util.List', property.jvmType.asWrapperTypeIfPrimitive)
			) [
				documentation = property.documentation
				body = [
					append('return (')
					serialize(newTypeRef(property, 'java.util.List', property.jvmType.asWrapperTypeIfPrimitive), 
						property, it
					)
					append(''') _dbObject.get("«property.name»");''')
				]
			]		
		} else {
			inferredType.members += property.toField('_' + property.name, newTypeRef(property,
				 'org.eclipse.xtext.mongobeans.MongoBeanList', property.jvmType))
			inferredType.members += property.toMethod('get' + property.name.toFirstUpper,
				newTypeRef(property, 'java.util.List', property.jvmType)
			) [
				documentation = property.documentation
				body = [
					append('''
						if(_«property.name»==null)
							_«property.name» = new ''')
					serialize(newTypeRef(property, 'org.eclipse.xtext.mongobeans.MongoBeanList', 
						property.jvmType), property, it) 
					append('(_dbObject, "' + property.name + '");\n')
					append('return _' + property.name + ';')
				]
			]
		}
	}	
	
	def protected addDelegateAccessors(JvmDeclaredType inferredType, MongoProperty property) {
		inferredType.members += property.toMethod('get' + property.name.toFirstUpper, property.jvmType) [
			documentation = property.documentation
			body = [
				append('return ')
				if(property.jvmType.mongoBean) {
					serialize(newTypeRef(property, 'org.eclipse.xtext.mongobeans.WrappingUtil'), property, it)
					append('.wrapAndCast((')
					serialize(newTypeRef(property, 'com.mongodb.DBObject'), property, it)
					append(''') _dbObject.get("«property.name»"));''')
				} else {
					append('(')
					serialize(property.jvmType.asWrapperTypeIfPrimitive, property, it)
					append(''') _dbObject.get("«property.name»");''')
				} 
			]
		]
		inferredType.members += property.toMethod('set' + property.name.toFirstUpper, null) [
			documentation = property.documentation
			parameters += toParameter(property.name, property.jvmType)
			body = [
				append(''' _dbObject.put("«property.name»", ''')
				if(property.jvmType.mongoBean) {
					serialize(newTypeRef(property, 'org.eclipse.xtext.mongobeans.WrappingUtil'), property, it)
					append(".unwrap(")
				} 
				append(property.name)
				if(property.jvmType.mongoBean)
					append(')')
				append(');')
			]
		]
	}
	
	def protected addMethod(JvmDeclaredType inferredType, MongoOperation operation) {
		inferredType.members += operation.toMethod(operation.name, operation.returnType) [
			documentation = operation.documentation
			for(parameter: operation.parameters)
				parameters += parameter.toParameter(parameter.name, parameter.parameterType)
			body = operation.body
		]
	}
	
	def protected getJvmType(MongoProperty property) {
		if(property.inlineType != null)
			(property.inlineType.jvmElements.head as JvmDeclaredType).newTypeRef
		else		
			property.type
	}
}

