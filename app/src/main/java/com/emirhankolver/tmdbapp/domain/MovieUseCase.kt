package com.emirhankolver.tmdbapp.domain

import com.emirhankolver.tmdbapp.data.GetPopularMoviesResponse
import com.emirhankolver.tmdbapp.data.GetUpComingResponse
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.domain.movie.MovieRepository
import com.emirhankolver.tmdbapp.domain.movie.MovieService
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val repository: MovieRepository
) : MovieService {

    override suspend fun getUpcomingMovies(): GetUpComingResponse {
        return repository.getUpcomingMovies();
    }

    override suspend fun getNowPlaying(): GetUpComingResponse {
        return repository.getNowPlaying();
    }

    override suspend fun getMovieDetail(id: Int): MovieDetail {
        return repository.getMovieDetail(id);
    }

    override suspend fun getMoviePopular(): GetPopularMoviesResponse {
        return repository.getMoviePopular()
    }
}