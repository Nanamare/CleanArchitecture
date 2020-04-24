package com.template.nanamare.data.network.response


import com.google.gson.annotations.SerializedName
import com.template.nanamare.data.network.model.CastModel
import com.template.nanamare.data.network.model.CrewModel

data class CreditResponse(
    @SerializedName("cast")
    val cast: List<CastModel>,
    @SerializedName("crew")
    val crew: List<CrewModel>,
    @SerializedName("id")
    val id: Int?
) : BaseResponse