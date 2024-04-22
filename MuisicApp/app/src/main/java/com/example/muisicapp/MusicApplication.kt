package com.example.muisicapp

import android.app.Application
import com.example.muisicapp.Model.AppContainer
import com.example.muisicapp.Model.AppDataContainer

class MusicApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}