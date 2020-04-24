package com.template.nanamare.data.source.remote

import com.template.nanamare.data.model.CastData
import com.template.nanamare.data.model.CreditData
import com.template.nanamare.data.model.CrewData
import com.template.nanamare.data.network.api.movie.MovieAPI
import com.template.nanamare.data.source.impl.CreditDataSource
import com.template.nanamare.data.source.remote.mapper.CastRemoteMapper
import com.template.nanamare.data.source.remote.mapper.CrewRemoteMapper
import com.template.nanamare.ext.converterErrorBody
import com.template.nanamare.ext.networkDispatchToMain
import com.template.nanamare.utils.Logger
import io.reactivex.Single

class CreditRemoteDataSourceImpl(private val movieAPI: MovieAPI) :
    CreditDataSource {
    override fun getMovieCredit(movieId: Int): Single<CreditData> {
        return movieAPI.requestMovieCredit(movieId).networkDispatchToMain().map {
            when (it.isSuccessful) {
                true -> {
                    it.body()?.let {
                        CreditData(
                            cast = it.cast.map(CastRemoteMapper::mapToData),
                            crew = it.crew.map(CrewRemoteMapper::mapToData),
                            id = it.id
                        )
                    } ?: run {
                        Logger.d(TAG, "empty body")
                        CreditData(emptyList<CastData>(), emptyList<CrewData>(), -1)
                    }
                }
                false -> {
                    it.errorBody()?.let {
                        Logger.d(TAG, converterErrorBody(it.string()).toString())
                    } ?: run {
                        Logger.d(TAG, "empty error body")
                    }
                    CreditData(emptyList<CastData>(), emptyList<CrewData>(), -1)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        val TAG: String = CreditRemoteDataSourceImpl::class.java.simpleName
    }
}