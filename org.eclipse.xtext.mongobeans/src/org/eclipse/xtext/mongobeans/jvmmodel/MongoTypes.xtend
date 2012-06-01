package org.eclipse.xtext.mongobeans.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.SuperTypeCollector

class MongoTypes {

	@Inject extension SuperTypeCollector
	
	val mongoPrimitiveTypes = newArrayList(
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
	)
	
	def isMongoPrimitiveType(JvmTypeReference typeRef) {
		mongoPrimitiveTypes.contains(typeRef.qualifiedName)
	}
	
	def isMongoType(JvmTypeReference typeRef) {
		isMongoPrimitiveType(typeRef) || typeRef.collectSuperTypeNames.contains('org.eclipse.xtext.mongobeans.IDBObjectWrapper')
	}
	
}