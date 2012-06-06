package org.eclipse.xtext.mongobeans.example

import com.mongodb.Mongo
import org.eclipse.xtext.mongobeans.MongoExtensions
import org.junit.Test
import org.musicdb.Album
import org.musicdb.Artist
import org.musicdb.Track

import static org.junit.Assert.*

class MongoBeansXtendTest {

	extension MongoExtensions = new MongoExtensions
	
	@Test def testMongoFacade() {
		val mongo = new Mongo()
		try {
			val db = mongo.getDB('testdb')
			val dbCollection = db.getCollection('testCollection')
			
			val john = new Artist => [
				name = 'John Coltrane'
				addAlbum [
					title = 'A Love Supreme'
					year = 1965
					addTrack('Part 1: Acknowledgement', '7:43')
					addTrack('Part 2: Resolution', '7:20')
					addTrack('Part 3: Pursuance', '10:42')
					addTrack('Part 4: Psalm', '7:05')
				]
				addAlbum [
					title = 'Impressions'
					year = 1961
					addTrack('India', '13:52') 
					addTrack("Up 'gainst the Wall", '3:12') 
					addTrack('Impressions', '14:40') 
					addTrack('After the Rain', '4:07') 
				]
			]
			assertEquals(8, john.oevre.size)
			dbCollection.save(john)
	
			val johnFromDb = dbCollection.findOne(new Artist => [
				name = 'John Coltrane'
			])
			assertNotNull(johnFromDb)
			assertEquals(2, johnFromDb.albums.size)
			val albumFromDb = johnFromDb.albums.get(1)
			assertEquals("35:51", albumFromDb.duration.toString)
		} finally {
			mongo.close 
		}
	}
	
	def protected addAlbum(Artist it, (Album)=>void initializer) {
		albums += new Album => initializer
	}
	
	def protected addTrack(Album it, String trackTitle, String trackDuration) {
		tracks += new Track => [
			title = trackTitle
			seconds = Duration::fromString(trackDuration).seconds
		]
	}
}