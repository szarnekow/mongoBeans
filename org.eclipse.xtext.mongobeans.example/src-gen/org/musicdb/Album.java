package org.musicdb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.util.List;
import org.eclipse.xtext.mongobeans.DBObjectListWrapper;
import org.eclipse.xtext.mongobeans.IDBObjectWrapper;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.musicdb.Duration;
import org.musicdb.Track;

/**
 * A record, CD, DVD or another collection of tracks
 */
public class Album implements IDBObjectWrapper {
  /**
   * Creates a new Album wrapping the given {@link DBObject}.
   */
  public Album(final DBObject dbObject) {
    this._dbObject = dbObject;
  }
  
  /**
   * Creates a new Album wrapping a new {@link BasicDBObject}.
   */
  public Album() {
    _dbObject = new BasicDBObject();
    _dbObject.put(JAVA_CLASS_KEY, "org.musicdb.Album");
    
  }
  
  /**
   * Creates a new Album wrapping a new {@link BasicDBObject} with an Xtend friendly constructor.
   */
  public Album(final Procedure1<Album> initializer) {
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
  
  public int getYear() {
    return (Integer) _dbObject.get("year");
  }
  
  public void setYear(final int year) {
     _dbObject.put("year", year);
  }
  
  private DBObjectListWrapper<Track> _tracks;
  
  public List<Track> getTracks() {
    if(_tracks==null)
    	_tracks = new DBObjectListWrapper<Track>(_dbObject, "tracks");
    return _tracks;
  }
  
  public Duration getDuration() {
    List<Track> _tracks = this.getTracks();
    final Function1<Track,Duration> _function = new Function1<Track,Duration>() {
        public Duration apply(final Track it) {
          Duration _duration = it.getDuration();
          return _duration;
        }
      };
    List<Duration> _map = ListExtensions.<Track, Duration>map(_tracks, _function);
    final Function2<Duration,Duration,Duration> _function_1 = new Function2<Duration,Duration,Duration>() {
        public Duration apply(final Duration a, final Duration b) {
          Duration _plus = a.operator_plus(b);
          return _plus;
        }
      };
    Duration _reduce = IterableExtensions.<Duration>reduce(_map, _function_1);
    return _reduce;
  }
}
