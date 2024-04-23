package com.example.muisicapp.Model

import android.content.Context
import com.example.muisicapp.Model.repository.OfflineSongsRepository
import com.example.muisicapp.Model.repository.SongsRepository

interface AppContainer {
    val songsRepository: SongsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val songsRepository: SongsRepository by lazy {
        OfflineSongsRepository(MusicDatabase.getDatabase(context).musicDao())
    }
}