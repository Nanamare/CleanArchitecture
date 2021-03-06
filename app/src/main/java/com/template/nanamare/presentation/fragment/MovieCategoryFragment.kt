package com.template.nanamare.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.util.Consumer
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.template.nanamare.R
import com.template.nanamare.data.enum.RequestMovieApiType
import com.template.nanamare.databinding.MovieCategoryFragmentBinding
import com.template.nanamare.ext.intentFor
import com.template.nanamare.ext.nonNull
import com.template.nanamare.ext.observer
import com.template.nanamare.presentation.activity.MovieInfoActivity
import com.template.nanamare.presentation.adapter.MovieAdapter
import com.template.nanamare.presentation.base.navigator.BaseNavigator
import com.template.nanamare.presentation.base.ui.BaseFragment
import com.template.nanamare.presentation.model.GenrePresentation
import com.template.nanamare.presentation.vm.MovieCategoryViewModel
import com.template.nanamare.utils.decoration.GridSpacingItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MovieCategoryFragment :
    BaseFragment<MovieCategoryFragmentBinding>(R.layout.movie_category_fragment), BaseNavigator {

    private val movieCategoryViewModel by viewModel<MovieCategoryViewModel> {
        parametersOf(this)
    }

    private val genre by lazy { arguments?.getParcelable<GenrePresentation>(KEY_GENRE_PRESENTATION) }

    private val column by lazy { resources.getInteger(R.integer.grid_column) }
    private val space by lazy { resources.getDimension(R.dimen.grid_space).toInt() }

    private val movieAdapter by lazy {
        MovieAdapter(Consumer {
            startActivity(
                intentFor<MovieInfoActivity>(
                    MovieInfoActivity.EXTRA_MOVIE_ITEM to
                            movieCategoryViewModel.liveMovies.value?.value?.get(it)
                )
            )
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            rv.run {
                adapter = movieAdapter
                layoutManager = GridLayoutManager(context, column)
                addItemDecoration(GridSpacingItemDecoration(column, space, false))
                ViewCompat.setNestedScrollingEnabled(this, false)
            }

            genre?.let {
                tvLabel.text = getString(R.string.desc_movie, it.name)
                movieCategoryViewModel.requestDiscoverMovies(it.id, RequestMovieApiType.DISCOVER)
            }
        }

        movieCategoryViewModel.liveMovies.nonNull().observer(viewLifecycleOwner) {
            it.nonNull().observer(viewLifecycleOwner) {
                movieAdapter.submitList(it)
            }
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        searchView.clearFocus()
        query?.let {
            movieCategoryViewModel.searchMovies(query, RequestMovieApiType.SEARCH)
            return true
        } ?: run {
            Toast.makeText(context, R.string.hint_search, Toast.LENGTH_SHORT).show()
            return false
        }
    }

    override fun closeSearchView() {
        super.closeSearchView()
        genre?.let {
            movieCategoryViewModel.requestDiscoverMovies(it.id, RequestMovieApiType.DISCOVER)
        }
    }

    companion object {
        const val KEY_GENRE_PRESENTATION = "KEY_GENRE_PRESENTATION"
        fun getInstance(genre: GenrePresentation) = MovieCategoryFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_GENRE_PRESENTATION, genre)
            }
        }
    }

}