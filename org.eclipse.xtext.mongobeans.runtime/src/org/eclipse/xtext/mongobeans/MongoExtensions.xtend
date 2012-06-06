package org.eclipse.xtext.mongobeans

import com.mongodb.DBCollection
import org.eclipse.xtext.mongobeans.IMongoBean

import static extension org.eclipse.xtext.mongobeans.WrappingUtil.*

class MongoExtensions {
	
	def <T extends IMongoBean> findOne(DBCollection collection, T wrapper) {
		collection.findOne(wrapper.getDbObject)?.wrap as T
	}
	
	def save(DBCollection collection, IMongoBean wrapper) {
		collection.save(wrapper.getDbObject)
	}
	
}