package com.emirhankolver.tmdbapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.data.UiState
import com.emirhankolver.tmdbapp.domain.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: MovieUseCase,
) : ViewModel() {

    private val _upcomingList = MutableStateFlow<UiState<List<MovieDetail?>>>(UiState.Loading)
    val upcomingList: StateFlow<UiState<List<MovieDetail?>>> = _upcomingList

    private val _nowPlayingList = MutableStateFlow<UiState<List<MovieDetail?>>>(UiState.Loading)
    val nowPlayingList: StateFlow<UiState<List<MovieDetail?>>> = _nowPlayingList

    init {
        loadUpcomingList()
        loadNowPlayingList()
    }

    fun loadUpcomingList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            _upcomingList.emit(UiState.Loading)
            val movies = useCase.getUpcomingMovies()
            _upcomingList.emit(UiState.Success(movies.results ?: emptyList()))
        } catch (t:Throwable) {
            _upcomingList.emit(UiState.Error(t.message ?: "Unknown Error"))
        }
    }

    fun loadNowPlayingList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            _nowPlayingList.emit(UiState.Loading)
            val movies = useCase.getNowPlaying()
            _nowPlayingList.emit(UiState.Success(movies.results ?: emptyList()))
        } catch (t:Throwable) {
            _nowPlayingList.emit(UiState.Error(t.message ?: "Unknown Error"))
        }
    }
}