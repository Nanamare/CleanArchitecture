package com.template.nanamare.data.mapper

import com.template.nanamare.data.model.CrewData
import com.template.nanamare.domain.model.CrewModel

object CrewDataMapper : DataMapper<CrewData, CrewModel> {
    override fun mapToModel(from: CrewData): CrewModel {
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
}