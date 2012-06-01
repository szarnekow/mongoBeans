package org.eclipse.xtext.mongobeans.example

import com.mongodb.DBCollection
import org.eclipse.xtext.mongobeans.IDBObjectWrapper

import static extension org.eclipse.xtext.mongobeans.WrappingUtil.*

class MongoExtensions {
	
	def <T> findOne(DBCollection collection, T wrapper) {
		collection.findOne((wrapper as IDBObjectWrapper).dbObject)?.wrap as T
	}
	
	def save(DBCollection collection, IDBObjectWrapper wrapper) {
		collection.save(wrapper.dbObject)
	}
	
}