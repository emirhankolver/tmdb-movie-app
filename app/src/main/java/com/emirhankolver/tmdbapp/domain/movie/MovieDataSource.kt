package com.emirhankolver.tmdbapp.domain.movie

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.emirhankolver.tmdbapp.data.GetPopularMoviesResponse
import com.emirhankolver.tmdbapp.data.GetUpComingResponse
import com.emirhankolver.tmdbapp.data.MovieDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


private const val TAG = "MovieDataSource"

class MovieDataSource @Inject constructor(
    private val service: MovieService
) : MovieService {

    override suspend fun getUpcomingMovies(): GetUpComingResponse {
        Log.d(TAG, "getUpcomingMovies() called")
        return service.getUpcomingMovies()
    }

    override suspend fun getNowPlaying(page: Int): GetUpComingResponse {
        Log.d(TAG, "getNowPlaying() called with: page = $page")
        return service.getNowPlaying(page)
    }

    override suspend fun getMovieDetail(id: Int): MovieDetail {
        Log.d(TAG, "getMovieDetail() called with: id = $id")
        return service.getMovieDetail(id)
    }

    override suspend fun getMoviePopular(): GetPopularMoviesResponse {
        Log.d(TAG, "getMoviePopular() called")
        return service.getMoviePopular()
    }

    override fun getNowPlayingPagingFlow(): Flow<PagingData<MovieDetail>> {
        Log.d(TAG, "getNowPlayingPagingFlow() called")
        return Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 5, initialLoadSize = 1),
            pagingSourceFactory = { NowPlayingPagingSource(this) }
        ).flow
    }
}