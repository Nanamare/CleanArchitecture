package com.template.nanamare.data.network.api.movie

import com.template.nanamare.data.network.response.MovieResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverAPI {
    @GET("3/discover/movie")
    fun requestMovies(
        @Query("with_genres") withGenres: String
    ): Single<Response<MovieResponse>>
}