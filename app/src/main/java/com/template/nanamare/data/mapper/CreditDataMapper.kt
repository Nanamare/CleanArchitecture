package com.template.nanamare.data.mapper

import com.template.nanamare.data.model.CreditData
import com.template.nanamare.domain.model.CreditModel

object CreditDataMapper: DataMapper<CreditData, CreditModel> {
    override fun mapToModel(from: CreditData): CreditModel {
        return CreditModel(
            cast = from.cast.map(CastDataMapper::mapToModel),
            crew = from.crew.map(CrewDataMapper::mapToModel),
            id = from.id
        )
    }

    override fun mapToData(from: CreditModel): CreditData {
        return CreditData(
            cast = from.cast.map(CastDataMapper::mapToData),
            crew = from.crew.map(CrewDataMapper::mapToData),
            id = from.id
        )
    }
}