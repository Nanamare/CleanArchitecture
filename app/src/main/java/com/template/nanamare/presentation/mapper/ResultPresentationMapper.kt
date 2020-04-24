package com.template.nanamare.presentation.mapper

import com.template.nanamare.domain.model.ResultModel
import com.template.nanamare.presentation.model.ResultPresentation

object ResultPresentationMapper : PresentationMapper<ResultModel, ResultPresentation> {
    override fun mapToPresentation(from: ResultModel): ResultPresentation {
        return ResultPresentation(
            id = from.id,
            iso31661 = from.iso31661,
            iso6391 = from.iso6391,
            key = from.key,
            name = from.name,
            site = from.site,
            size = from.size,
            type = from.type
        )
    }

    override fun mapToModel(from: ResultPresentation): ResultModel {
        return ResultModel(
            id = from.id,
            iso31661 = from.iso31661,
            iso6391 = from.iso6391,
            key = from.key,
            name = from.name,
            site = from.site,
            size = from.size,
            type = from.type
        )
    }
}