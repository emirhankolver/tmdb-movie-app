package com.emirhankolver.tmdbapp.data


import com.google.gson.annotations.SerializedName

data class GetPopularMoviesResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<MovieDetail?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)