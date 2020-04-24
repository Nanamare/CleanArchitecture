package com.template.nanamare.data.mapper

import com.template.nanamare.data.model.GenreData
import com.template.nanamare.domain.model.GenreModel

object GenreDataMapper :
    DataMapper<GenreData, GenreModel> {

    // Data layer 의 장르 데이터를 Domain layer 에 매핑
    override fun mapToModel(from: GenreData): GenreModel {
        return GenreModel(
            id = from.id,
            name = from.name
        )
    }

    // Domain layer 의 장르 데이터를 Data layer 에 매핑
    override fun mapToData(from: GenreModel): GenreData {
        return GenreData(
            id = from.id,
            name = from.name
        )
    }

}