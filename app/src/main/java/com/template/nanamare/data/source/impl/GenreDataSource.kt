package com.template.nanamare.data.source.impl

import com.template.nanamare.data.model.GenreData
import com.template.nanamare.data.network.response.GenreResponse
import io.reactivex.Single
import retrofit2.Response

interface GenreDataSource {
    fun requestGenre() : Single<List<GenreData>>
}