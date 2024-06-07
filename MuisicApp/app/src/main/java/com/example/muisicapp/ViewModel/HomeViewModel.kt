package com.example.muisicapp.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.User
import com.example.muisicapp.Model.relations.SongOfUsers
import com.example.muisicapp.Model.relations.SongUserCrossRef
import com.example.muisicapp.Model.repository.MusicRepository
import com.example.muisicapp.View.Home.HomeDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val musicRepository: MusicRepository,
) : ViewModel() {

    private val userID: Int = checkNotNull(savedStateHandle[HomeDestination.userID])

    /**
     * Lấy thông tin user
     */
    val userUiState: StateFlow<UserUiState> =
        musicRepository.getUserById(userID)
            .filterNotNull()
            .map {
                UserUiState(
                    user = it
                )
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = UserUiState()
            )

    /**
     * Danh sach bai hat yeu thich cua user
     */
    val loveUiState: StateFlow<FavoriteUiState> =
        musicRepository.getUserWithSongsById(userID)
            .filterNotNull()
            .map {
                FavoriteUiState(
                    songList = it
                )
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = FavoriteUiState()
            )

    /**
     * Thêm bài hát vào mục yêu thích
     */
    suspend fun addSongToFavorite(songId: Int) {
        musicRepository.insertSongUserCrossRef(
            SongUserCrossRef(
                songId,
                userID
            )
        )
    }


}


data class UserUiState(
    val user: User = User(0, "", "", "")
)

data class FavoriteUiState(
    val songList: List<SongOfUsers> = listOf()
)

