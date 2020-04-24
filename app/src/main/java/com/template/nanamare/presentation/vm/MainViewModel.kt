package com.template.nanamare.presentation.vm

import androidx.lifecycle.MutableLiveData
import com.template.nanamare.data.mapper.GenreDataMapper
import com.template.nanamare.data.network.NetworkState
import com.template.nanamare.data.source.impl.GenreDataSource
import com.template.nanamare.domain.model.GenreModel
import com.template.nanamare.presentation.base.ui.BaseViewModel

class MainViewModel(private val genreDataSource: GenreDataSource) : BaseViewModel() {

    val liveGenreNetworkState = MutableLiveData<NetworkState<List<GenreModel>>>().apply {
        value = NetworkState.init()
    }

    fun requestMovieGenre() {
        compositeDisposable.add(
            genreDataSource.requestGenre()
                .doOnSubscribe { liveGenreNetworkState.value = NetworkState.loading() }
                .doOnTerminate { liveGenreNetworkState.value = NetworkState.init() }
                .subscribe({
                    liveGenreNetworkState.value = NetworkState.success(it.map(GenreDataMapper::mapToModel))
                }, {
                    liveGenreNetworkState.value = NetworkState.error(it)
                })
        )
    }

}