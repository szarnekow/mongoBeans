package org.musicdb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.eclipse.xtext.mongobeans.IDBObjectWrapper;
import org.eclipse.xtext.mongobeans.WrappingUtil;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.musicdb.Duration;

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
  public Track() {
    _dbObject = new BasicDBObject();
    _dbObject.put(JAVA_CLASS_KEY, "org.musicdb.Track");
    
  }
  
  /**
   * Creates a new Track wrapping a new {@link BasicDBObject} with an Xtend friendly constructor.
   */
  public Track(final Procedure1<Track> initializer) {
    this();
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
  
  public Duration getDuration() {
    return WrappingUtil.wrapAndCast((DBObject) _dbObject.get("duration"));
  }
  
  public void setDuration(final Duration duration) {
     _dbObject.put("duration", WrappingUtil.unwrap(duration));
  }
}
