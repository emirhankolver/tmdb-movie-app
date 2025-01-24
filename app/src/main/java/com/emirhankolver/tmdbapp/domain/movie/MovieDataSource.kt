package com.emirhankolver.tmdbapp.domain.movie

import com.emirhankolver.tmdbapp.data.GetPopularMoviesResponse
import com.emirhankolver.tmdbapp.data.GetUpComingResponse
import com.emirhankolver.tmdbapp.data.MovieDetail
import javax.inject.Inject

class MovieDataSource @Inject constructor(
    private val service: MovieService
) : MovieService {

    override suspend fun getUpcomingMovies(): GetUpComingResponse {
        return service.getUpcomingMovies()
    }

    override suspend fun getNowPlaying(): GetUpComingResponse {
        return service.getNowPlaying()
    }

    override suspend fun getMovieDetail(id: Int): MovieDetail {
        return service.getMovieDetail(id)
    }

    override suspend fun getMoviePopular(): GetPopularMoviesResponse {
        return service.getMoviePopular()
    }
}