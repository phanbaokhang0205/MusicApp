import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.muisicapp.Model.MusicDatabase
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.data.SongDao
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class SongDaoTest {
    private lateinit var songDao: SongDao
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
        songDao = musicDatabase.songDao()
    }
    @After
    @Throws(IOException::class)
    fun closeDb() {
        musicDatabase.close()
    }

    private var song1 = Song(1, "Chung ta cua hien tai", "mtp.png", "http://...")
    private var song2 = Song(2, "Em cua ngay hom qua", "mtp2.png", "https://...")

    private suspend fun addOneSongToDb() {
        songDao.insert(song1)
    }

    private suspend fun addTwoSongsToDb() {
        songDao.insert(song1)
        songDao.insert(song2)
    }


    @Test
    @Throws(Exception::class)
    fun daoInsert_insertsItemIntoDB() = runBlocking {
        addOneSongToDb()
        val allItems = songDao.getAllSongs().first()
        assertEquals(allItems[0], song1)
    }


    @Test
    @Throws(Exception::class)
    fun daoGetAllItems_returnsAllItemsFromDB() = runBlocking {
        addTwoSongsToDb()
        val allItems = songDao.getAllSongs().first()
        assertEquals(allItems[0], song1)
        assertEquals(allItems[1], song2)
    }


}