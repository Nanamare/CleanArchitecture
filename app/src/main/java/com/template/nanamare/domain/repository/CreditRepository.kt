package com.template.nanamare.domain.repository

import com.template.nanamare.data.model.CreditData
import com.template.nanamare.data.source.remote.CreditRemoteDataSourceImpl
import com.template.nanamare.data.source.impl.CreditDataSource
import com.template.nanamare.data.network.response.CreditResponse
import io.reactivex.Single
import retrofit2.Response

class CreditRepository(private val creditRemoteDataSourceImpl: CreditRemoteDataSourceImpl) :
    CreditDataSource {
    override fun getMovieCredit(movieId: Int): Single<CreditData> {
        return creditRemoteDataSourceImpl.getMovieCredit(movieId)
    }
}