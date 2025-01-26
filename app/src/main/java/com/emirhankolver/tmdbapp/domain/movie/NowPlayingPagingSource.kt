package com.emirhankolver.tmdbapp.domain.movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.emirhankolver.tmdbapp.data.MovieDetail
import kotlinx.coroutines.delay

class NowPlayingPagingSource(
    private val service: MovieDataSource
) : PagingSource<Int, MovieDetail>() {
    override fun getRefreshKey(state: PagingState<Int, MovieDetail>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDetail> {
        return try {
            val currentPage = params.key ?: 1
            val response = service.getNowPlaying(currentPage)
            delay(2000)
            LoadResult.Page(
                data = response.results!!,
                prevKey = if (currentPage == 1) null else currentPage - 1, // No previous page for the first page
                nextKey = if (response.results.isEmpty()) null else currentPage + 1 // If no data, no next page
            )
        } catch (t: Throwable) {
            // If there's an error, return an error result
            LoadResult.Error(t)
        }
    }

}