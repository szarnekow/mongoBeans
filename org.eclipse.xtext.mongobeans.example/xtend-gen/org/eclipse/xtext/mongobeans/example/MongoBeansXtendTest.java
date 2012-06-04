package org.eclipse.xtext.mongobeans.example;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.util.List;
import org.eclipse.xtext.mongobeans.example.MongoExtensions;
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
import org.musicdb.Duration;
import org.musicdb.Track;

@SuppressWarnings("all")
public class MongoBeansXtendTest {
  private MongoExtensions _mongoExtensions = new Function0<MongoExtensions>() {
    public MongoExtensions apply() {
      MongoExtensions _mongoExtensions = new MongoExtensions();
      return _mongoExtensions;
    }
  }.apply();
  
  private static Mongo mongo;
  
  @BeforeClass
  public static void startMongoDB() {
    try {
      Mongo _mongo = new Mongo();
      MongoBeansXtendTest.mongo = _mongo;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @AfterClass
  public static void stopMongoDB() {
    MongoBeansXtendTest.mongo.close();
  }
  
  @Test
  public void testMongoFacade() {
    final DB db = MongoBeansXtendTest.mongo.getDB("testdb");
    final DBCollection dbCollection = db.getCollection("testCollection");
    final Procedure1<Artist> _function = new Procedure1<Artist>() {
        public void apply(final Artist it) {
          it.setName("John Coltrane");
          List<Album> _albums = it.getAlbums();
          final Procedure1<Album> _function = new Procedure1<Album>() {
              public void apply(final Album it) {
                it.setTitle("A Love Supreme");
                MongoBeansXtendTest.this.track(it, "Part 1: Acknowledgement", "7:43");
                MongoBeansXtendTest.this.track(it, "Part 2: Resolution", "7:20");
                MongoBeansXtendTest.this.track(it, "Part 3: Pursuance", "10:42");
                MongoBeansXtendTest.this.track(it, "Part 4: Psalm", "7:05");
              }
            };
          Album _album = new Album(_function);
          _albums.add(_album);
          List<Album> _albums_1 = it.getAlbums();
          final Procedure1<Album> _function_1 = new Procedure1<Album>() {
              public void apply(final Album it) {
                it.setTitle("Impressions");
                MongoBeansXtendTest.this.track(it, "India", "13:52");
                MongoBeansXtendTest.this.track(it, "Up \'gainst the Wall", "3:12");
                MongoBeansXtendTest.this.track(it, "Impressions", "14:40");
                MongoBeansXtendTest.this.track(it, "After the Rain", "4:07");
              }
            };
          Album _album_1 = new Album(_function_1);
          _albums_1.add(_album_1);
        }
      };
    Artist _artist = new Artist(_function);
    final Artist john = _artist;
    Iterable<Track> _oevre = john.getOevre();
    int _size = IterableExtensions.size(_oevre);
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
    Duration _duration = albumFromDb.getDuration();
    String _string = _duration.toString();
    Assert.assertEquals("35:51", _string);
  }
  
  protected boolean track(final Album it, final String trackTitle, final String trackDuration) {
    List<Track> _tracks = it.getTracks();
    final Procedure1<Track> _function = new Procedure1<Track>() {
        public void apply(final Track it) {
          it.setTitle(trackTitle);
          final Procedure1<Duration> _function = new Procedure1<Duration>() {
              public void apply(final Duration it) {
                it.fromString(trackDuration);
              }
            };
          Duration _duration = new Duration(_function);
          it.setDuration(_duration);
        }
      };
    Track _track = new Track(_function);
    boolean _add = _tracks.add(_track);
    return _add;
  }
}
