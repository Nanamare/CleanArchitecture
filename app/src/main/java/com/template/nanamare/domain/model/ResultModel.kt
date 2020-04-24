package com.template.nanamare.domain.model

data class ResultModel(
    val id: String?,
    val iso31661: String?,
    val iso6391: String?,
    val key: String?,
    val name: String?,
    val site: String,
    val size: Int,
    val type: String?
): BaseDomainModel