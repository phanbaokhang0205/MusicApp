package com.example.muisicapp.Model

import android.content.Context
import com.example.muisicapp.Model.data.OfflineSongsRepository
import com.example.muisicapp.Model.data.SongsRepository

interface AppContainer {
    val songsRepository: SongsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val songsRepository: SongsRepository by lazy {
        OfflineSongsRepository(MusicDatabase.getDatabase(context).songDao())
    }
}