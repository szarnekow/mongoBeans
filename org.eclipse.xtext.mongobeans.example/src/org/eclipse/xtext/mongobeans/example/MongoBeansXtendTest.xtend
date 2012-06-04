package org.eclipse.xtext.mongobeans.example

import com.mongodb.Mongo
import org.junit.Test
import org.musicdb.Album
import org.musicdb.Artist
import org.musicdb.Track

import static org.junit.Assert.*

import static extension java.lang.Integer.*
import org.junit.BeforeClass
import org.junit.AfterClass
import org.musicdb.Duration

class MongoBeansXtendTest {

	extension MongoExtensions = new MongoExtensions
	
	static Mongo mongo
	
	@BeforeClass
	def static void startMongoDB() {
		mongo = new Mongo()
	}

	@AfterClass
	def static void stopMongoDB() {
		mongo.close
	}
	
	@Test
	def testMongoFacade() {
		val db = mongo.getDB('testdb')
		val dbCollection = db.getCollection('testCollection')
		
		val john = new Artist [
			name = 'John Coltrane'
			albums += new Album [
				title = 'A Love Supreme'
				track('Part 1: Acknowledgement', '7:43')
				track('Part 2: Resolution', '7:20')
				track('Part 3: Pursuance', '10:42')
				track('Part 4: Psalm', '7:05')
			]
			albums += new Album [
				title = 'Impressions'
				track('India', '13:52') 
				track("Up 'gainst the Wall", '3:12') 
				track('Impressions', '14:40') 
				track('After the Rain', '4:07') 
			]
		]
		assertEquals(8, john.oevre.size)
		dbCollection.save(john)

		val johnFromDb = dbCollection.findOne(new Artist [
			name = 'John Coltrane'
		])
		assertNotNull(johnFromDb)
		assertEquals(2, johnFromDb.albums.size)
		val albumFromDb = johnFromDb.albums.get(1)
		assertEquals("35:51", albumFromDb.duration.toString)
	}
	
	def protected track(Album it, String trackTitle, String trackDuration) {
		tracks += new Track [
			title = trackTitle
			duration = new Duration() [
				fromString(trackDuration)
			]
		]
	}
}