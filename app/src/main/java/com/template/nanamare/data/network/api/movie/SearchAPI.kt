package com.template.nanamare.data.network.api.movie

import com.template.nanamare.data.network.response.MovieResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPI {
    @GET("3/search/movie")
    fun searchMovies(
        @Query("query") query: String
    ): Single<Response<MovieResponse>>

}