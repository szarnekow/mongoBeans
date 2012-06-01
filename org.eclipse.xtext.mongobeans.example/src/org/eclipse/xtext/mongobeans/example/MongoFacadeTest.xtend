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

class MongoFacadeTest {

	extension MongoExtensions = new MongoExtensions
	
	static Mongo mongo
	
	@BeforeClass
	def static startMongoDB() {
		mongo = new Mongo()
	}

	@AfterClass
	def static stopMongoDB() {
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
				tracks += new Track [ title = 'Part 1: Acknowledgement' ]
				tracks += new Track [ title = 'Part 2: Resolution' ]
				tracks += new Track [ title = 'Part 3: Pursuance' ]
				tracks += new Track [ title = 'Part 4: Psalm' ]
			]
			albums += new Album [
				title = 'Impressions'
				track('India', '13:52') 
				track("Up 'gainst the Wall", '3:12') 
				track('Impressions', '14:40') 
				track('After the Rain', '4:07') 
			]
		]
		assertEquals(8, john.allTracks.size)
		dbCollection.save(john)

		val johnFromDb = dbCollection.findOne(new Artist() [
			name = 'John Coltrane'
		])
		assertNotNull(johnFromDb)
		assertEquals(2, johnFromDb.albums.size)
		val albumFromDb = johnFromDb.albums.get(1)
		assertEquals(2151, albumFromDb.duration)
	}
	
	def protected track(Album it, String trackTitle, String trackDuration) {
		tracks += new Track [
			title = trackTitle
			val time = trackDuration.split(':')
			duration = time.get(0).parseInt * 60 + time.get(1).parseInt 
		]
	}
}