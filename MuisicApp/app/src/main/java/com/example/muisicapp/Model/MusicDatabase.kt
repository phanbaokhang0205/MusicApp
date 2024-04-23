package com.example.muisicapp.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.data.MusicDao
import com.example.muisicapp.Model.data.Playlist
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.data.Type
import com.example.muisicapp.Model.relations.SongPlaylistCrossRef
import com.example.muisicapp.Model.relations.SongSingerCrossRef
import com.example.muisicapp.Model.relations.SongTypeCrossRef

@Database(
    entities = [
        Song::class,
        Singer::class,
        Playlist::class,
        Type::class,
        Album::class,
        SongPlaylistCrossRef::class,
        SongSingerCrossRef::class,
        SongTypeCrossRef::class],
    version = 1
)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao

    companion object {
        @Volatile
        private var Instance: MusicDatabase? = null

        fun getDatabase(context: Context): MusicDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    MusicDatabase::class.java,
                    "test4_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }

}