package com.template.nanamare.data.mapper

import com.template.nanamare.data.model.CastData
import com.template.nanamare.domain.model.CastModel

object CastDataMapper: DataMapper<CastData, CastModel> {
    override fun mapToModel(from: CastData): CastModel {
        return CastModel(
            castId = from.castId,
            character = from.character,
            creditId = from.creditId,
            gender = from.gender,
            id = from.id,
            name = from.name,
            order = from.order,
            profilePath = from.profilePath
        )
    }

    override fun mapToData(from: CastModel): CastData {
        return CastData(
            castId = from.castId,
            character = from.character,
            creditId = from.creditId,
            gender = from.gender,
            id = from.id,
            name = from.name,
            order = from.order,
            profilePath = from.profilePath
        )
    }
}