package org.musicdb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.eclipse.xtext.mongobeans.IDBObjectWrapper;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class Track implements IDBObjectWrapper {
  /**
   * Creates a new Track wrapping the given {@link DBObject}.
   */
  public Track(final DBObject dbObject) {
    this._dbObject = dbObject;
  }
  
  /**
   * Creates a new Track wrapping a new {@link BasicDBObject}.
   */
  public Track(final Procedure1<Track> initializer) {
    _dbObject = new BasicDBObject();
    _dbObject.put(JAVA_CLASS_KEY, "org.musicdb.Track");
    initializer.apply(this);
    
  }
  
  private DBObject _dbObject;
  
  public DBObject getDbObject() {
    return this._dbObject;
  }
  
  public String getTitle() {
    return (String) _dbObject.get("title");
  }
  
  public void setTitle(final String title) {
     _dbObject.put("title", title);
  }
  
  /**
   * the duration in seconds
   */
  public int getDuration() {
    return (Integer) _dbObject.get("duration");
  }
  
  /**
   * the duration in seconds
   */
  public void setDuration(final int duration) {
     _dbObject.put("duration", duration);
  }
}
