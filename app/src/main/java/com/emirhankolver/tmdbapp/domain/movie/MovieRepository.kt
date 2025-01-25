package com.emirhankolver.tmdbapp.domain.movie

import com.emirhankolver.tmdbapp.data.GetPopularMoviesResponse
import com.emirhankolver.tmdbapp.data.GetUpComingResponse
import com.emirhankolver.tmdbapp.data.MovieDetail
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val dataSource: MovieDataSource
): MovieService {

    override suspend fun getUpcomingMovies(): GetUpComingResponse {
        return dataSource.getUpcomingMovies();
    }

    override suspend fun getNowPlaying(): GetUpComingResponse {
        return dataSource.getNowPlaying();
    }

    override suspend fun getMovieDetail(id: Int): MovieDetail {
        return dataSource.getMovieDetail(id);
    }

    override suspend fun getMoviePopular(): GetPopularMoviesResponse {
        return dataSource.getMoviePopular();
    }
}