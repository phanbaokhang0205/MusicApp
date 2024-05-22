package com.example.muisicapp.Model

import android.content.Context
import com.example.muisicapp.Model.repository.OfflineMusicRepository
import com.example.muisicapp.Model.repository.MusicRepository

interface AppContainer {
    val musicRepository: MusicRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    //Biến lazy chỉ được khởi tạo khi lần đầu được truy cập giúp tiết kiệm tài nguyên.
    override val musicRepository: MusicRepository by lazy {
        OfflineMusicRepository(MusicDatabase.getDatabase(context).musicDao())
    }
}