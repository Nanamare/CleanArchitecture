package com.template.nanamare.domain.repository

import com.template.nanamare.data.model.VideoData
import com.template.nanamare.data.source.remote.VideoRemoteDataSourceImpl
import com.template.nanamare.data.source.impl.VideoDataSource
import com.template.nanamare.data.network.response.VideoResponse
import io.reactivex.Single
import retrofit2.Response

class VideoRepository(private val videoRemoteDataSourceImpl: VideoRemoteDataSourceImpl) :
    VideoDataSource {

    override fun getMovieVideos(movieId: Int): Single<VideoData> {
        return videoRemoteDataSourceImpl.getMovieVideos(movieId)
    }

}