package com.template.nanamare.presentation.activity

import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import com.template.nanamare.BR
import com.template.nanamare.BuildConfig.VIDEO_URL
import com.template.nanamare.R
import com.template.nanamare.presentation.base.ui.BaseActivity
import com.template.nanamare.presentation.base.ui.SimpleRecyclerView
import com.template.nanamare.presentation.model.ActorPresentation
import com.template.nanamare.databinding.ItemActorBinding
import com.template.nanamare.databinding.MovieInfoActivityBinding
import com.template.nanamare.data.network.NetworkState
import com.template.nanamare.domain.model.CreditModel
import com.template.nanamare.domain.model.VideoModel
import com.template.nanamare.presentation.anim.SimpleAnimation
import com.template.nanamare.presentation.dialog.VideoFragment
import com.template.nanamare.presentation.mapper.ActorPresentationMapper
import com.template.nanamare.presentation.mapper.ResultPresentationMapper
import com.template.nanamare.presentation.vm.MovieInfoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MovieInfoActivity : BaseActivity<MovieInfoActivityBinding>(R.layout.movie_info_activity) {

    private val movieInfoViewModel by viewModel<MovieInfoViewModel>()

    private val actorSimpleAdapter by lazy {
        object :
            SimpleRecyclerView.Adapter<ActorPresentation, ItemActorBinding>(R.layout.item_actor, BR.actor) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            vm = movieInfoViewModel
            actorAdapter = actorSimpleAdapter
            movieInfoViewModel.movie = intent.extras?.getParcelable(EXTRA_MOVIE_ITEM)
            initAnim()
            initActor()
        }

        movieInfoViewModel.run {
            liveMovieVideoState.observe(this@MovieInfoActivity, Observer {
                when (it) {
                    is NetworkState.Init -> hideLoadingPopup()
                    is NetworkState.Loading -> showLoadingPopup()
                    is NetworkState.Success<VideoModel> -> getUrl(it)
                    is NetworkState.Error -> showToast(it.throwable.toString())
                    is NetworkState.ServerError -> showToast(it.toString())
                }
            })

            liveMovieCreditState.observe(this@MovieInfoActivity, Observer {
                when (it) {
                    is NetworkState.Init -> hideLoadingPopup()
                    is NetworkState.Loading -> showLoadingPopup()
                    is NetworkState.Success<CreditModel> -> {
                        liveLoading.value = false
                        initActorAdapter(it.item)
                    }
                    is NetworkState.Error -> showToast(it.throwable.toString())
                    is NetworkState.ServerError -> showToast(it.toString())
                }
            })
        }

    }

    private fun initActorAdapter(creditModel: CreditModel) {
        movieInfoViewModel.liveActor.value = creditModel.cast.map(ActorPresentationMapper::mapToPresentation)
    }

    private fun getUrl(it: NetworkState.Success<VideoModel>) {
        it.item.results.map(ResultPresentationMapper::mapToPresentation)
            .asSequence()
            .filter { "YouTube".toLowerCase(Locale.getDefault()) == it.site.toLowerCase(Locale.getDefault()) }
            .reduce { acc, result -> if (acc.size > result.size) acc else result }.let {
                VideoFragment(Uri.parse(VIDEO_URL).buildUpon().appendQueryParameter("v", it.key).build().toString()).show(supportFragmentManager, VideoFragment::class.simpleName)
            }
    }

    private fun initActor() {
        movieInfoViewModel.run {
            movie?.let {
                getMovieCredit(it.id)
            }
        }
    }

    private fun MovieInfoActivityBinding.initAnim() {
        ivPoster.startAnimation(SimpleAnimation.leftToRight)
        movieInfoBody.root.startAnimation(SimpleAnimation.rightToLeft)
        tvNext.startAnimation(SimpleAnimation.bottomToTop)
        movieSummaryBody.root.startAnimation(SimpleAnimation.rightToLeft)
        movieActorInfoBody.root.startAnimation(SimpleAnimation.leftToRight)
    }


    companion object {
        const val EXTRA_MOVIE_ITEM = "EXTRA_MOVIE_ITEM"
    }

}