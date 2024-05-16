import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.muisicapp.Model.MusicDatabase
import com.example.muisicapp.Model.data.MusicDao
import com.example.muisicapp.Model.data.Song
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class musicDaoTest {
    private lateinit var musicDao: MusicDao
    private lateinit var musicDatabase: MusicDatabase

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        musicDatabase = Room.inMemoryDatabaseBuilder(context, MusicDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        musicDao = musicDatabase.musicDao()
    }
    @After
    @Throws(IOException::class)
    fun closeDb() {
        musicDatabase.close()
    }

//    private var song1 = Song(1, "Chung ta cua hien tai", "mtp.png", "MTP" ,2)
//    private var song2 = Song(2, "Em cua ngay hom qua", "mtp2.png", "MTP" ,3)

//    private suspend fun addOneSongToDb() {
//        musicDao.insertSong(song1)
//    }
//
//    private suspend fun addTwoSongsToDb() {
//        musicDao.insertSong(song1)
//        musicDao.insertSong(song2)
//    }



//    @Test
//    @Throws(Exception::class)
//    fun daoInsert_insertsItemIntoDB() = runBlocking {
//        addOneSongToDb()
//        val allItems = musicDao.getAllSongs().first()
//        assertEquals(allItems[0], song1)
//    }
//
//
//    @Test
//    @Throws(Exception::class)
//    fun daoGetAllItems_returnsAllItemsFromDB() = runBlocking {
//        addTwoSongsToDb()
//        val allItems = musicDao.getAllSongs().first()
//        assertEquals(allItems[0], song1)
//        assertEquals(allItems[1], song2)
//    }


}