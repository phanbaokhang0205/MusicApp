package com.example.muisicapp.ViewModel

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.muisicapp.MusicApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                this.createSavedStateHandle(),
                musicApplication().container.musicRepository
            )
        }

        initializer {
            SongDetailsViewModel(
                this.createSavedStateHandle(),
                musicApplication().container.musicRepository,
            )
        }

        initializer {
            SingerDetailsViewModel(
                this.createSavedStateHandle(),
                musicApplication().container.musicRepository
            )
        }

        initializer {
            PlayListDetailsViewModel(
                this.createSavedStateHandle(),
                musicApplication().container.musicRepository
            )
        }

        initializer {
            AlbumDetailsViewModel(
                this.createSavedStateHandle(),
                musicApplication().container.musicRepository
            )
        }

        initializer {
            SearchViewModel(
                musicApplication().container.musicRepository
            )
        }

        initializer {
            UserViewModel(
                musicApplication().container.musicRepository
            )
        }

    }
}

fun CreationExtras.musicApplication(): MusicApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MusicApplication)