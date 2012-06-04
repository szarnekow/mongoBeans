package org.eclipse.xtext.mongobeans.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.SuperTypeCollector

class MongoTypes {

	@Inject extension SuperTypeCollector
	
	public val mongoPrimitiveTypes = newArrayList(
		'double',
		'java.lang.Double',
		'java.lang.String',
		'byte[]',
		'boolean',
		'java.lang.Boolean',
		'java.util.Date',
		'void',
		'java.lang.Void',
		'java.util.regex.Pattern',
		'int',
		'java.lang.Integer',
		'long',
		'java.lang.Long'
	).unmodifiableView
	
	def isMongoPrimitiveType(JvmTypeReference typeRef) {
		mongoPrimitiveTypes.contains(typeRef.qualifiedName)
	}
	
	def isMongoType(JvmTypeReference typeRef) {
		isMongoPrimitiveType(typeRef) || isMongoBean(typeRef)
	}
	
	def isMongoBean(JvmTypeReference typeRef) {
		typeRef.collectSuperTypeNames.contains('org.eclipse.xtext.mongobeans.IDBObjectWrapper')
	}
	
}