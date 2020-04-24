package com.template.nanamare.di

import com.template.nanamare.presentation.dialog.VideoFragment
import com.template.nanamare.presentation.fragment.MovieCategoryFragment
import com.template.nanamare.presentation.fragment.MovieFragment
import com.template.nanamare.presentation.model.GenrePresentation
import org.koin.androidx.fragment.dsl.fragment
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * usage
 * setupKoinFragmentFactory() in activity before super.onCreate(savedInstanceState)
 */
val fragmentModule: Module = module {
    fragment(override = true) {
        MovieFragment()
    }
    fragment(override = true) { (movies: List<GenrePresentation>) ->
        MovieFragment(movies)
    }
    fragment(override = true) {
        MovieCategoryFragment()
    }
    fragment(override = true) { (movie: GenrePresentation) ->
        MovieCategoryFragment(movie)
    }
    fragment(override = true) { VideoFragment() }
    fragment(override = true) { (liveVideoUrl: String) -> VideoFragment(liveVideoUrl) }
}