package com.template.nanamare.data.model

data class CreditData(
    val cast: List<CastData>,
    val crew: List<CrewData>,
    val id: Int?
) : BaseData