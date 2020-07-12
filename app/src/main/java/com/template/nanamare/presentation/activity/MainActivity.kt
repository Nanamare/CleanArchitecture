package com.template.nanamare.presentation.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import com.template.nanamare.R
import com.template.nanamare.data.network.NetworkState
import com.template.nanamare.databinding.MainActivityBinding
import com.template.nanamare.domain.model.GenreModel
import com.template.nanamare.ext.replaceFragmentInActivity
import com.template.nanamare.ext.toJsonString
import com.template.nanamare.presentation.base.ui.BaseActivity
import com.template.nanamare.presentation.fragment.MovieFragment
import com.template.nanamare.presentation.mapper.GenrePresentationMapper
import com.template.nanamare.presentation.vm.MainViewModel
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainActivityBinding>(R.layout.main_activity) {

    private val mainViewModel by viewModel<MainViewModel>()

    val tlLayout
        get() = binding.tlMovie

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)

        binding.run {
            initToolbar()
        }

        mainViewModel.run {
            requestMovieGenre()
            liveGenreNetworkState.observe(this@MainActivity, Observer {
                when (it) {
                    is NetworkState.Init -> hideLoadingPopup()
                    is NetworkState.Loading -> showLoadingPopup()
                    is NetworkState.Success<List<GenreModel>> ->
                        replaceFragmentInActivity(MovieFragment::class.java, R.id.flContent, Bundle().apply {
                            putString(KEY_GENE, it.item.map(GenrePresentationMapper::mapToPresentation).toJsonString())
                        })
                    is NetworkState.Error -> showToast(it.throwable.toString())
                    is NetworkState.ServerError -> showToast(it.toString())
                }
            })
        }

    }

    // 헤더 CI 적용
    @SuppressLint("WrongConstant", "InflateParams")
    private fun MainActivityBinding.initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayShowCustomEnabled(true)
            it.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            it.setCustomView(
                layoutInflater.inflate(R.layout.appbar_title, null),
                androidx.appcompat.app.ActionBar.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT,
                    Gravity.CENTER
                )
            )
        }
    }

    companion object {
        const val KEY_GENE = "KEY_GENE"
    }
}
