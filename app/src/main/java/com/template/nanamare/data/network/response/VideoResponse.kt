package com.template.nanamare.data.network.response


import com.google.gson.annotations.SerializedName
import com.template.nanamare.domain.model.ResultModel

data class VideoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<ResultModel>
) : BaseResponse