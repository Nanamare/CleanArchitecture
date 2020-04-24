package com.template.nanamare.data.mapper

import com.template.nanamare.data.model.VideoData
import com.template.nanamare.domain.model.VideoModel

object VideoDataMapper : DataMapper<VideoData, VideoModel> {
    override fun mapToModel(from: VideoData): VideoModel {
        return VideoModel(
            id = from.id,
            results = from.results.map(ResultDataMapper::mapToModel)
        )
    }

    override fun mapToData(from: VideoModel): VideoData {
        return VideoData(
            id = from.id,
            results = from.results.map(ResultDataMapper::mapToData)
        )
    }
}