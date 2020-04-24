package com.template.nanamare.data.source.remote.mapper

import com.template.nanamare.data.model.CrewData
import com.template.nanamare.data.network.model.CrewModel

object CrewRemoteMapper : RemoteMapper<CrewModel, CrewData> {

    override fun mapToData(from: CrewModel): CrewData {
        return CrewData(
            creditId = from.creditId,
            department = from.department,
            gender = from.gender,
            id = from.id,
            job = from.job,
            name = from.name,
            profilePath = from.profilePath
        )
    }

    override fun mapToRemote(from: CrewData): CrewModel {
        return CrewModel(
            creditId = from.creditId,
            department = from.department,
            gender = from.gender,
            id = from.id,
            job = from.job,
            name = from.name,
            profilePath = from.profilePath
        )
    }

}