package com.template.nanamare.data.source.remote.mapper

import com.template.nanamare.data.model.GenreData
import com.template.nanamare.data.network.model.GenreModel


object GenreRemoteMapper : RemoteMapper<GenreModel, GenreData> {
    override fun mapToRemote(from: GenreData): GenreModel {
        return GenreModel(
            id = from.id,
            name = from.name
        )
    }

    override fun mapToData(from: GenreModel): GenreData {
        return GenreData(
            id = from.id,
            name = from.name
        )
    }

}