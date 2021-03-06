package com.template.nanamare.presentation.vm

import androidx.lifecycle.MutableLiveData
import com.template.nanamare.presentation.base.ui.BaseViewModel

class VideoViewModel(private val videoUrl: String) : BaseViewModel() {
    var liveVideoPath = MutableLiveData<String>().apply {
        value = videoUrl
    }
}