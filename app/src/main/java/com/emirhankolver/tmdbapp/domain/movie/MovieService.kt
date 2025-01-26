package com.emirhankolver.tmdbapp.domain.movie

import com.emirhankolver.tmdbapp.data.GetPopularMoviesResponse
import com.emirhankolver.tmdbapp.data.GetUpComingResponse
import com.emirhankolver.tmdbapp.data.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): GetUpComingResponse

    @GET("movie/now_playing")
    suspend fun getNowPlaying(): GetUpComingResponse

    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: Int): MovieDetail

    @GET("movie/popular")
    suspend fun getMoviePopular(): GetPopularMoviesResponse
}