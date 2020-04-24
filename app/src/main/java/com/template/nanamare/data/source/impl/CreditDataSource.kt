package com.template.nanamare.data.source.impl

import com.template.nanamare.data.model.CreditData
import com.template.nanamare.data.network.response.CreditResponse
import io.reactivex.Single
import retrofit2.Response

interface CreditDataSource {
    fun getMovieCredit(movieId: Int) : Single<CreditData>
}