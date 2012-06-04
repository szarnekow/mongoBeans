package org.eclipse.xtext.mongobeans

import com.mongodb.DBObject

class WrappingUtil {
	
	def static IDBObjectWrapper wrap(DBObject dbObject) {
		val javaClassName = dbObject.get(IDBObjectWrapper::JAVA_CLASS_KEY)?.toString
		val javaClass = typeof(WrappingUtil).classLoader.loadClass(javaClassName)
		if(typeof(IDBObjectWrapper).isAssignableFrom(javaClass)) {
			val constructor = javaClass.getConstructor(typeof(DBObject))
			constructor.newInstance(dbObject) as IDBObjectWrapper
		} else {
			throw new IllegalStateException('''Stored javaClass '«javaClassName»' does not extend '«typeof(IDBObjectWrapper).simpleName»'«»''')
		}
	}
	
	def static <T> T wrapAndCast(DBObject dbObject) {
		wrap(dbObject) as T
	} 
	
	def static DBObject unwrap(Object wrapper) {
		if(!(wrapper instanceof IDBObjectWrapper))
			throw new IllegalArgumentException("Invalid type")
		else 
			(wrapper as IDBObjectWrapper).getDbObject
	}

}