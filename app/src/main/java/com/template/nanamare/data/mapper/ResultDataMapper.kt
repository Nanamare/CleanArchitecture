package com.template.nanamare.data.mapper

import com.template.nanamare.data.model.ResultData
import com.template.nanamare.domain.model.ResultModel

object ResultDataMapper: DataMapper<ResultData, ResultModel> {
    override fun mapToModel(from: ResultData): ResultModel {
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

    override fun mapToData(from: ResultModel): ResultData {
        return ResultData(
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