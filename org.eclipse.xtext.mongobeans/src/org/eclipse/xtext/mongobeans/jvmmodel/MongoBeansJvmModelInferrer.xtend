package org.eclipse.xtext.mongobeans.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.mongobeans.mongoBeans.MongoBean
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty
import org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation
import org.eclipse.xtext.common.types.util.Primitives
import static org.eclipse.emf.ecore.util.EcoreUtil.*

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

   	def dispatch void infer(MongoBean bean, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
   		acceptor.accept(bean.toClass(bean.fullyQualifiedName))
   			.initializeLater([
   				documentation = bean.documentation
   				superTypes += newTypeRef(bean, 'org.eclipse.xtext.mongobeans.IDBObjectWrapper')
   				addConstructors(bean)
   				addDbObjectProperty(bean)
   				resolveAll(bean)
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
			parameters += bean.toParameter('initializer', newTypeRef(bean, 'org.eclipse.xtext.xbase.lib.Procedures$Procedure1', 
				newTypeRef(inferredType)
			)) 
			body = [
				append('_dbObject = new ')
				serialize(newTypeRef(bean, 'com.mongodb.BasicDBObject'), bean, it)
				append('();\n')
				append('''
					_dbObject.put(JAVA_CLASS_KEY, "«inferredType.identifier»");
					initializer.apply(this);
				''')
			]					
		]   	
	}
	
	def protected addDbObjectProperty(JvmDeclaredType inferredType, MongoBean bean) {
		inferredType.members += bean.toField('_dbObject', newTypeRef(bean, 'com.mongodb.DBObject'))
		inferredType.members += bean.toGetter('dBObject', '_dbObject', newTypeRef(bean, 'com.mongodb.DBObject'))
	}

	def protected addListAccessor(JvmDeclaredType inferredType, MongoProperty property) {
		if(isMongoPrimitiveType(property.type)) {
			inferredType.members += property.toMethod('get' + property.name.toFirstUpper, 
				newTypeRef(property, 'java.util.List', property.type.asWrapperTypeIfPrimitive)
			) [
				documentation = property.documentation
				body = [
					append('return (')
					serialize(newTypeRef(property, 'java.util.List', property.type.asWrapperTypeIfPrimitive), 
						property, it
					)
					append(''') _dbObject.get("«property.name»");''')
				]
			]		
		} else {
			inferredType.members += property.toField('_' + property.name, newTypeRef(property,
				 'org.eclipse.xtext.mongobeans.DBObjectListWrapper', property.getType))
			inferredType.members += property.toMethod('get' + property.name.toFirstUpper,
				newTypeRef(property, 'java.util.List', property.type)
			) [
				documentation = property.documentation
				body = [
					append('''
						if(_«property.name»==null)
							_«property.name» = new ''')
					serialize(newTypeRef(property, 'org.eclipse.xtext.mongobeans.DBObjectListWrapper', 
						property.getType), property, it) 
					append('(_dbObject, "' + property.name + '");\n')
					append('return _' + property.name + ';')
				]
			]
		}
	}	
	
	def protected addDelegateAccessors(JvmDeclaredType inferredType, MongoProperty property) {
		inferredType.members += property.toMethod('get' + property.name.toFirstUpper, property.type) [
			documentation = property.documentation
			body = [
				append('return (')
				serialize(property.type.asWrapperTypeIfPrimitive, property, it)
				append(''') _dbObject.get("«property.name»");''')
			]
		]
		inferredType.members += property.toMethod('set' + property.name.toFirstUpper, null) [
			documentation = property.documentation
			parameters += toParameter(property.name, property.type)
			body = [
				append(''' _dbObject.put("«property.name»", «property.name»);''')
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
}

