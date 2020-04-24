package com.template.nanamare.presentation.fragment

import android.os.Bundle
import android.view.View
import com.template.nanamare.R
import com.template.nanamare.databinding.MovieFragmentBinding
import com.template.nanamare.presentation.activity.MainActivity
import com.template.nanamare.presentation.base.ui.BaseFragment
import com.template.nanamare.presentation.base.ui.BaseViewPager
import com.template.nanamare.presentation.model.GenrePresentation

class MovieFragment(private val genres: List<GenrePresentation>? = null) :
    BaseFragment<MovieFragmentBinding>(R.layout.movie_fragment) {

    private val baseViewPager by lazy { BaseViewPager(childFragmentManager) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            genres?.let {
                for (genre in it) {
                    baseViewPager.addFragment(MovieCategoryFragment(genre), genre.name)
                }
            }
            viewPager.adapter = baseViewPager
            (requireActivity() as MainActivity).tlLayout.setupWithViewPager(viewPager)
        }
    }


}