package com.template.nanamare.data.source.remote.mapper

import com.template.nanamare.data.model.CastData
import com.template.nanamare.data.network.model.CastModel

object CastRemoteMapper : RemoteMapper<CastModel, CastData> {

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

    override fun mapToRemote(from: CastData): CastModel {
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
}