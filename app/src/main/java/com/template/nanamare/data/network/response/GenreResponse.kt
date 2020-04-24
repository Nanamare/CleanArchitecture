package com.template.nanamare.data.network.response


import com.google.gson.annotations.SerializedName
import com.template.nanamare.data.network.model.GenreModel

data class GenreResponse(
    @SerializedName("genres")
    val genres: List<GenreModel>
) : BaseResponse