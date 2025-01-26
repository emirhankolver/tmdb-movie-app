package com.emirhankolver.tmdbapp.domain.movie

import androidx.paging.PagingData
import com.emirhankolver.tmdbapp.data.GetPopularMoviesResponse
import com.emirhankolver.tmdbapp.data.GetUpComingResponse
import com.emirhankolver.tmdbapp.data.MovieDetail
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): GetUpComingResponse

    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("page") page: Int): GetUpComingResponse

    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: Int): MovieDetail

    @GET("movie/popular")
    suspend fun getMoviePopular(): GetPopularMoviesResponse

    fun getNowPlayingPagingFlow(): Flow<PagingData<MovieDetail>>
}