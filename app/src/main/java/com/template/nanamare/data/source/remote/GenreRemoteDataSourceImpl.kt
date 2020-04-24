package com.template.nanamare.data.source.remote

import com.template.nanamare.data.model.GenreData
import com.template.nanamare.data.network.api.movie.GenreAPI
import com.template.nanamare.data.source.impl.GenreDataSource
import com.template.nanamare.data.source.remote.mapper.GenreRemoteMapper
import com.template.nanamare.ext.converterErrorBody
import com.template.nanamare.ext.networkDispatchToMain
import com.template.nanamare.utils.Logger
import io.reactivex.Single

class GenreRemoteDataSourceImpl(private val genreAPI: GenreAPI) : GenreDataSource {
    override fun requestGenre(): Single<List<GenreData>> {
        return genreAPI.requestGenre().networkDispatchToMain().map {
            when (it.isSuccessful) {
                true -> {
                    it.body()?.genres?.map(GenreRemoteMapper::mapToData) ?: run {
                        Logger.d(TAG, "empty body")
                        emptyList<GenreData>()
                    }
                }
                false -> {
                    it.errorBody()?.let {
                        Logger.d(TAG, converterErrorBody(it.string()).toString())
                    } ?: run {
                        Logger.d(TAG, "empty error body")
                    }
                    emptyList<GenreData>()
                }
            }
        }
    }

    companion object {
        @JvmStatic
        val TAG: String = GenreRemoteDataSourceImpl::class.java.simpleName
    }
}