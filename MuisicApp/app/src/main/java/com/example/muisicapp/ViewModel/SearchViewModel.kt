package com.example.muisicapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.Model.repository.MusicRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
@OptIn(ExperimentalCoroutinesApi::class)

class SearchViewModel(
    private val musicRepo: MusicRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    var searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    val searchResults: StateFlow<SearchUiState> = _searchQuery
            .flatMapLatest { query ->
                musicRepo.getSearchResult(query)
                    .map {
                        SearchUiState(it)
                    }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = SearchUiState()
            )

    fun updateSearchQuery(searchField: String) {
        _searchQuery.value = searchField
    }
}


data class SearchUiState(
    val searchResult: List<SongWithSingers> = listOf()
)

//data class SearchDetails(
//    val song: Song = Song(0, "", "", "", 0, 0L),
//    val singers: List<Singer> = listOf()
//)
//
//fun SearchDetails.toSearch(): SongWithSingers = SongWithSingers(
//    song = song,
//    singers = singers
//)
//
//fun SongWithSingers.toSearchUiState(): SearchUiState = SearchUiState(
//    searchResult = this.toSearchDetails()
//)
//
//fun SongWithSingers.toSearchDetails(): SearchDetails = SearchDetails(
//    song = song,
//    singers = singers
//)