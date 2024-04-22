package com.example.muisicapp.ViewModel

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.muisicapp.MusicApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                musicApplication().container.songsRepository
            )
        }
    }
}

fun CreationExtras.musicApplication(): MusicApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MusicApplication)