package com.template.nanamare.domain.repository

import com.template.nanamare.data.source.remote.DetailRemoteDataSourceImpl
import com.template.nanamare.data.source.impl.DetailDataSource
import com.template.nanamare.data.network.response.DetailResponse
import io.reactivex.Single
import retrofit2.Response

class DetailRepository(private val detailRemoteDataSourceImpl: DetailRemoteDataSourceImpl) :
    DetailDataSource {
    override fun getMovieDetail(creditId: Int): Single<Response<DetailResponse>> {
        return detailRemoteDataSourceImpl.getMovieDetail(creditId)
    }
}