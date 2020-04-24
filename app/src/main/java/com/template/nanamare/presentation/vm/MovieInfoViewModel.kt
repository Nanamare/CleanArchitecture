package com.template.nanamare.presentation.vm

import androidx.lifecycle.MutableLiveData
import com.template.nanamare.data.mapper.CreditDataMapper
import com.template.nanamare.data.mapper.VideoDataMapper
import com.template.nanamare.data.network.NetworkState
import com.template.nanamare.data.network.response.DetailResponse
import com.template.nanamare.data.network.response.MovieResponse
import com.template.nanamare.data.source.impl.CreditDataSource
import com.template.nanamare.data.source.impl.DetailDataSource
import com.template.nanamare.data.source.impl.VideoDataSource
import com.template.nanamare.domain.model.CreditModel
import com.template.nanamare.domain.model.VideoModel
import com.template.nanamare.ext.upCasting
import com.template.nanamare.presentation.base.ui.BaseViewModel
import com.template.nanamare.presentation.model.ActorPresentation

class MovieInfoViewModel(
    private val videoDataSource: VideoDataSource,
    private val creditDataSource: CreditDataSource,
    private val movieDetailDataSource: DetailDataSource
) : BaseViewModel() {

    val liveMovieVideoState = MutableLiveData<NetworkState<VideoModel>>().apply {
        value = NetworkState.init()
    }

    val liveMovieCreditState = MutableLiveData<NetworkState<CreditModel>>().apply {
        value = NetworkState.init()
    }

    val liveMovieDetailResponse = MutableLiveData<NetworkState<DetailResponse>>().apply {
        value = NetworkState.init()
    }

    var movie: MovieResponse.Result? = null

    val liveHasSample = MutableLiveData<Boolean>().apply {
        value = false
    }

    val liveLoading = MutableLiveData<Boolean>().apply {
        value = true
    }

    val liveActor = MutableLiveData<List<ActorPresentation>>()

    fun onSeeSampleClick() {
        movie?.let {
            compositeDisposable.add(
                videoDataSource.getMovieVideos(it.id)
                    .doOnSubscribe { liveMovieVideoState.value = NetworkState.loading() }
                    .doOnTerminate { liveMovieVideoState.value = NetworkState.init() }
                    .subscribe({
                        liveMovieVideoState.value =
                            NetworkState.success(VideoDataMapper.mapToModel(it))
                    }, {
                        liveMovieVideoState.value = NetworkState.error(it)
                    })
            )
        }
    }

    fun getMovieCredit(movieId: Int) {
        compositeDisposable.add(
            creditDataSource.getMovieCredit(movieId)
                .doOnSubscribe { liveMovieCreditState.value = NetworkState.loading() }
                .doOnTerminate { liveMovieCreditState.value = NetworkState.init() }
                .subscribe({
                    liveMovieCreditState.value =
                        NetworkState.success(CreditDataMapper.mapToModel(it))
                }, {
                    liveMovieCreditState.value = NetworkState.error(it)
                })
        )
    }

    fun getMovieDetail(creditId: Int) {
        compositeDisposable.add(
            getDisposable(
                movieDetailDataSource.getMovieDetail(creditId).upCasting(),
                liveMovieCreditState.upCasting()
            )
        )
    }

}