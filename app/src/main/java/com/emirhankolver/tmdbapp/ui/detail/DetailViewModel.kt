package com.emirhankolver.tmdbapp.ui.detail

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
class DetailViewModel @Inject constructor(
    private val useCase: MovieUseCase
) : ViewModel() {

    private val _movieDetail = MutableStateFlow<UiState<MovieDetail?>>(UiState.Loading)
    val movieDetail: StateFlow<UiState<MovieDetail?>> = _movieDetail


    fun loadMovieDetails(id: Int?) = viewModelScope.launch(Dispatchers.IO) {
        if (id == null) {
            _movieDetail.emit(UiState.Error("Something's went wrong :/"))
            return@launch
        }
        try {
            val response = useCase.getMovieDetail(id)
            _movieDetail.emit(UiState.Success(response))
        } catch (t: Throwable) {
            _movieDetail.emit(UiState.Error(t.message ?: "Error happened."))
            t.printStackTrace()
        }
    }
}