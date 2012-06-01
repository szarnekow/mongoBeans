package org.eclipse.xtext.mongobeans;

import com.mongodb.DBObject;

public interface IDBObjectWrapper {

	public String JAVA_CLASS_KEY = "JavaClass";

	DBObject getDbObject();
}
