package com.template.nanamare.data.source.impl

import com.template.nanamare.data.model.VideoData
import io.reactivex.Single

interface VideoDataSource {
    fun getMovieVideos(movieId: Int) : Single<VideoData>
}