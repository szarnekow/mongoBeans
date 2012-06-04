package org.musicdb;

import com.google.common.collect.Iterables;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.util.List;
import org.eclipse.xtext.mongobeans.DBObjectListWrapper;
import org.eclipse.xtext.mongobeans.IDBObjectWrapper;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.musicdb.Album;
import org.musicdb.Track;

/**
 * A musical performer
 */
public class Artist implements IDBObjectWrapper {
  /**
   * Creates a new Artist wrapping the given {@link DBObject}.
   */
  public Artist(final DBObject dbObject) {
    this._dbObject = dbObject;
  }
  
  /**
   * Creates a new Artist wrapping a new {@link BasicDBObject}.
   */
  public Artist() {
    _dbObject = new BasicDBObject();
    _dbObject.put(JAVA_CLASS_KEY, "org.musicdb.Artist");
    
  }
  
  /**
   * Creates a new Artist wrapping a new {@link BasicDBObject} with an Xtend friendly constructor.
   */
  public Artist(final Procedure1<Artist> initializer) {
    this();
    initializer.apply(this);
    
  }
  
  private DBObject _dbObject;
  
  public DBObject getDbObject() {
    return this._dbObject;
  }
  
  public String getName() {
    return (String) _dbObject.get("name");
  }
  
  public void setName(final String name) {
     _dbObject.put("name", name);
  }
  
  private DBObjectListWrapper<Album> _albums;
  
  public List<Album> getAlbums() {
    if(_albums==null)
    	_albums = new DBObjectListWrapper<Album>(_dbObject, "albums");
    return _albums;
  }
  
  public Iterable<Track> getOevre() {
    List<Album> _albums = this.getAlbums();
    final Function1<Album,List<Track>> _function = new Function1<Album,List<Track>>() {
        public List<Track> apply(final Album it) {
          List<Track> _tracks = it.getTracks();
          return _tracks;
        }
      };
    List<List<Track>> _map = ListExtensions.<Album, List<Track>>map(_albums, _function);
    Iterable<Track> _flatten = Iterables.<Track>concat(_map);
    return _flatten;
  }
}
