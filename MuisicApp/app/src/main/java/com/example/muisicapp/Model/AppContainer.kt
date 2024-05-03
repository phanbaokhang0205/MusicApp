package com.example.muisicapp.Model

import android.content.Context
import com.example.muisicapp.Model.repository.OfflineMusicRepository
import com.example.muisicapp.Model.repository.MusicRepository

interface AppContainer {
    val musicRepository: MusicRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val musicRepository: MusicRepository by lazy {
        OfflineMusicRepository(MusicDatabase.getDatabase(context).musicDao())
    }
}