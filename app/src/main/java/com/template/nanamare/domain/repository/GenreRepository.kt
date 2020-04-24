package com.template.nanamare.domain.repository

import com.template.nanamare.data.model.GenreData
import com.template.nanamare.data.source.impl.GenreDataSource
import com.template.nanamare.data.source.remote.GenreRemoteDataSourceImpl
import io.reactivex.Single

class GenreRepository(private val genreRemoteDataSourceImpl: GenreRemoteDataSourceImpl) :
    GenreDataSource {
    override fun requestGenre(): Single<List<GenreData>> {
        return genreRemoteDataSourceImpl.requestGenre()
    }
}