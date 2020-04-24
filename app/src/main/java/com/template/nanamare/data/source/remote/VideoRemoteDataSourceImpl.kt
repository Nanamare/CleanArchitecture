package com.template.nanamare.data.source.remote

import com.template.nanamare.data.mapper.ResultDataMapper
import com.template.nanamare.data.model.ResultData
import com.template.nanamare.data.model.VideoData
import com.template.nanamare.data.network.api.movie.MovieAPI
import com.template.nanamare.data.source.impl.VideoDataSource
import com.template.nanamare.ext.converterErrorBody
import com.template.nanamare.ext.networkDispatchToMain
import com.template.nanamare.utils.Logger
import io.reactivex.Single

class VideoRemoteDataSourceImpl(private val movieAPI: MovieAPI) : VideoDataSource {
    override fun getMovieVideos(movieId: Int): Single<VideoData> {
        return movieAPI.requestMovieVideos(movieId).networkDispatchToMain().map {
            when (it.isSuccessful) {
                true -> {
                    it.body()?.let {
                        VideoData(
                            id = it.id,
                            results = it.results.map(ResultDataMapper::mapToData)
                        )
                    } ?: run {
                        Logger.d(TAG, "empty body")
                        VideoData(-1, emptyList<ResultData>())
                    }
                }
                false -> {
                    it.errorBody()?.let {
                        Logger.d(TAG, converterErrorBody(it.string()).toString())
                    } ?: run {
                        Logger.d(TAG, "empty error body")
                    }
                    VideoData(-1, emptyList<ResultData>())
                }
            }
        }
    }

    companion object {
        @JvmStatic
        val TAG: String = VideoRemoteDataSourceImpl::class.java.simpleName
    }
}