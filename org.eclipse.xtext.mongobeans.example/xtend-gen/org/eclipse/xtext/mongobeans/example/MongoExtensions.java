package org.eclipse.xtext.mongobeans.example;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.eclipse.xtext.mongobeans.IDBObjectWrapper;
import org.eclipse.xtext.mongobeans.WrappingUtil;

@SuppressWarnings("all")
public class MongoExtensions {
  public <T extends Object> T findOne(final DBCollection collection, final T wrapper) {
    DBObject _dbObject = ((IDBObjectWrapper) wrapper).getDbObject();
    DBObject _findOne = collection.findOne(_dbObject);
    IDBObjectWrapper _wrap = _findOne==null?(IDBObjectWrapper)null:WrappingUtil.wrap(_findOne);
    return ((T) _wrap);
  }
  
  public WriteResult save(final DBCollection collection, final IDBObjectWrapper wrapper) {
    DBObject _dbObject = wrapper.getDbObject();
    WriteResult _save = collection.save(_dbObject);
    return _save;
  }
}
