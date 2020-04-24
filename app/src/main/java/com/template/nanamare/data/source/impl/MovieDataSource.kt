package com.template.nanamare.data.source.impl

import com.template.nanamare.data.enum.RequestMovieApiType
import com.template.nanamare.data.network.response.BaseErrorResponse
import com.template.nanamare.data.network.response.MovieResponse

interface MovieDataSource {
    fun requestMovies(
        requestMovieApiType: RequestMovieApiType,
        query: String = "",
        page: Int,
        success: (movieResponse: MovieResponse) -> Unit,
        failed: (errorResponse: BaseErrorResponse) -> Unit
    )
}