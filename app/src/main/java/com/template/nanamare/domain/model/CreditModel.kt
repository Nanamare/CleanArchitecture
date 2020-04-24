package com.template.nanamare.domain.model

data class CreditModel(
    val cast: List<CastModel>,
    val crew: List<CrewModel>,
    val id: Int?
) : BaseDomainModel