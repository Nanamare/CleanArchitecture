package com.template.nanamare.di

import com.template.nanamare.presentation.dialog.VideoFragment
import com.template.nanamare.presentation.fragment.MovieCategoryFragment
import com.template.nanamare.presentation.fragment.MovieFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * usage
 * setupKoinFragmentFactory() in activity before super.onCreate(savedInstanceState)
 */
val fragmentModule: Module = module {
    fragment { MovieFragment() }
    fragment { MovieCategoryFragment() }
    fragment { VideoFragment() }
}