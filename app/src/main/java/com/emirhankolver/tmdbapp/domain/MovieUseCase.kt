package com.emirhankolver.tmdbapp.domain

import androidx.paging.PagingData
import com.emirhankolver.tmdbapp.data.GetPopularMoviesResponse
import com.emirhankolver.tmdbapp.data.GetUpComingResponse
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.domain.movie.MovieRepository
import com.emirhankolver.tmdbapp.domain.movie.MovieService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val repository: MovieRepository
) : MovieService {

    override suspend fun getUpcomingMovies(): GetUpComingResponse {
        delay(1000)
        return repository.getUpcomingMovies();
    }

    override suspend fun getNowPlaying(page: Int): GetUpComingResponse {
        delay(1000)
        return repository.getNowPlaying(page);
    }

    override suspend fun getMovieDetail(id: Int): MovieDetail {
        delay(1000)
        return repository.getMovieDetail(id);
    }

    override suspend fun getMoviePopular(): GetPopularMoviesResponse {
        delay(1000)
        return repository.getMoviePopular()
    }

    override fun getNowPlayingPagingFlow(): Flow<PagingData<MovieDetail>> {
        return repository.getNowPlayingPagingFlow()
    }
}