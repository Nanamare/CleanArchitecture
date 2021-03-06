package com.template.nanamare.domain.repository

import com.template.nanamare.data.enum.RequestMovieApiType
import com.template.nanamare.data.source.remote.MovieRemoteDataSourceImpl
import com.template.nanamare.data.source.impl.MovieDataSource
import com.template.nanamare.data.network.response.BaseErrorResponse
import com.template.nanamare.data.network.response.MovieResponse

class MovieRepository(private val movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl) :
    MovieDataSource {

    override fun requestMovies(
        requestMovieApiType: RequestMovieApiType,
        query: String,
        page: Int,
        success: (movieResponse: MovieResponse) -> Unit,
        failed: (errorResponse: BaseErrorResponse) -> Unit
    ) {
        return movieRemoteDataSourceImpl.requestMovies(
            requestMovieApiType,
            query,
            page,
            success,
            failed
        )
    }

}