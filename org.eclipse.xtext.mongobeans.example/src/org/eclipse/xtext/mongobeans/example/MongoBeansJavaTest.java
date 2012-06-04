package org.eclipse.xtext.mongobeans.example;

import static com.google.common.collect.Iterables.size;
import static org.eclipse.xtext.mongobeans.WrappingUtil.wrapAndCast;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.musicdb.Album;
import org.musicdb.Artist;
import org.musicdb.Duration;
import org.musicdb.Track;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoBeansJavaTest {

	@Test
	public void testMongoBeansJava() throws Exception {
		Mongo mongo = new Mongo();
		try {
			DB db = mongo.getDB("testdb");
			DBCollection dbCollection = db.getCollection("testCollection");

			Artist john = new Artist();
			john.setName("John Coltrane");

			Album album_0 = new Album();
			album_0.setTitle("A Love Supreme");
			john.getAlbums().add(album_0);

			addTrack(album_0, "Part 1: Acknowledgement", "7:43");
			addTrack(album_0, "Part 2: Resolution", "7:20");
			addTrack(album_0, "Part 3: Pursuance", "10:42");
			addTrack(album_0, "Part 4: Psalm", "7:05");

			Album album_1 = new Album();
			album_1.setTitle("Impressions");
			john.getAlbums().add(album_1);
			addTrack(album_1, "India", "13:52");
			addTrack(album_1, "Up 'gainst the Wall", "3:12"); 
			addTrack(album_1, "Impressions", "14:40");
			addTrack(album_1, "After the Rain", "4:07"); 

			assertEquals(8, size(john.getOevre()));
			dbCollection.save(john.getDbObject());

			Artist query = new Artist();
			query.setName("John Coltrane");
			Artist johnFromDb = wrapAndCast(dbCollection.findOne(query
					.getDbObject()));

			assertNotNull(johnFromDb);
			assertEquals(2, johnFromDb.getAlbums().size());
			assertEquals("32:50", johnFromDb.getAlbums().get(0).getDuration().toString());
		} finally {
			mongo.close();
		}
	}

	private void addTrack(Album album, String title, String length) {
		Track track = new Track();
		track.setTitle(title);
		Duration duration = new Duration();
		duration.fromString(length);
		track.setDuration(duration);
		album.getTracks().add(track);
	}

}
