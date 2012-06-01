package org.eclipse.xtext.mongobeans.example;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.util.List;
import org.eclipse.xtext.mongobeans.example.MongoExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.musicdb.Album;
import org.musicdb.Artist;
import org.musicdb.Track;

@SuppressWarnings("all")
public class MongoFacadeTest {
  private MongoExtensions _mongoExtensions = new Function0<MongoExtensions>() {
    public MongoExtensions apply() {
      MongoExtensions _mongoExtensions = new MongoExtensions();
      return _mongoExtensions;
    }
  }.apply();
  
  private static Mongo mongo;
  
  @BeforeClass
  public static Mongo startMongoDB() {
    try {
      Mongo _mongo = new Mongo();
      Mongo _mongo_1 = MongoFacadeTest.mongo = _mongo;
      return _mongo_1;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @AfterClass
  public static void stopMongoDB() {
    MongoFacadeTest.mongo.close();
  }
  
  @Test
  public void testMongoFacade() {
    final DB db = MongoFacadeTest.mongo.getDB("testdb");
    final DBCollection dbCollection = db.getCollection("testCollection");
    final Procedure1<Artist> _function = new Procedure1<Artist>() {
        public void apply(final Artist it) {
          it.setName("John Coltrane");
          List<Album> _albums = it.getAlbums();
          final Procedure1<Album> _function = new Procedure1<Album>() {
              public void apply(final Album it) {
                it.setTitle("A Love Supreme");
                List<Track> _tracks = it.getTracks();
                final Procedure1<Track> _function = new Procedure1<Track>() {
                    public void apply(final Track it) {
                      it.setTitle("Part 1: Acknowledgement");
                    }
                  };
                Track _track = new Track(_function);
                _tracks.add(_track);
                List<Track> _tracks_1 = it.getTracks();
                final Procedure1<Track> _function_1 = new Procedure1<Track>() {
                    public void apply(final Track it) {
                      it.setTitle("Part 2: Resolution");
                    }
                  };
                Track _track_1 = new Track(_function_1);
                _tracks_1.add(_track_1);
                List<Track> _tracks_2 = it.getTracks();
                final Procedure1<Track> _function_2 = new Procedure1<Track>() {
                    public void apply(final Track it) {
                      it.setTitle("Part 3: Pursuance");
                    }
                  };
                Track _track_2 = new Track(_function_2);
                _tracks_2.add(_track_2);
                List<Track> _tracks_3 = it.getTracks();
                final Procedure1<Track> _function_3 = new Procedure1<Track>() {
                    public void apply(final Track it) {
                      it.setTitle("Part 4: Psalm");
                    }
                  };
                Track _track_3 = new Track(_function_3);
                _tracks_3.add(_track_3);
              }
            };
          Album _album = new Album(_function);
          _albums.add(_album);
          List<Album> _albums_1 = it.getAlbums();
          final Procedure1<Album> _function_1 = new Procedure1<Album>() {
              public void apply(final Album it) {
                it.setTitle("Impressions");
                MongoFacadeTest.this.track(it, "India", "13:52");
                MongoFacadeTest.this.track(it, "Up \'gainst the Wall", "3:12");
                MongoFacadeTest.this.track(it, "Impressions", "14:40");
                MongoFacadeTest.this.track(it, "After the Rain", "4:07");
              }
            };
          Album _album_1 = new Album(_function_1);
          _albums_1.add(_album_1);
        }
      };
    Artist _artist = new Artist(_function);
    final Artist john = _artist;
    Iterable<Track> _allTracks = john.getAllTracks();
    int _size = IterableExtensions.size(_allTracks);
    Assert.assertEquals(8, _size);
    this._mongoExtensions.save(dbCollection, john);
    final Procedure1<Artist> _function_1 = new Procedure1<Artist>() {
        public void apply(final Artist it) {
          it.setName("John Coltrane");
        }
      };
    Artist _artist_1 = new Artist(_function_1);
    final Artist johnFromDb = this._mongoExtensions.<Artist>findOne(dbCollection, _artist_1);
    Assert.assertNotNull(johnFromDb);
    List<Album> _albums = johnFromDb.getAlbums();
    int _size_1 = _albums.size();
    Assert.assertEquals(2, _size_1);
    List<Album> _albums_1 = johnFromDb.getAlbums();
    final Album albumFromDb = _albums_1.get(1);
    int _duration = albumFromDb.getDuration();
    Assert.assertEquals(2151, _duration);
  }
  
  protected boolean track(final Album it, final String trackTitle, final String trackDuration) {
    List<Track> _tracks = it.getTracks();
    final Procedure1<Track> _function = new Procedure1<Track>() {
        public void apply(final Track it) {
          it.setTitle(trackTitle);
          final String[] time = trackDuration.split(":");
          String _get = ((List<String>)Conversions.doWrapArray(time)).get(0);
          int _parseInt = Integer.parseInt(_get);
          int _multiply = (_parseInt * 60);
          String _get_1 = ((List<String>)Conversions.doWrapArray(time)).get(1);
          int _parseInt_1 = Integer.parseInt(_get_1);
          int _plus = (_multiply + _parseInt_1);
          it.setDuration(_plus);
        }
      };
    Track _track = new Track(_function);
    boolean _add = _tracks.add(_track);
    return _add;
  }
}
