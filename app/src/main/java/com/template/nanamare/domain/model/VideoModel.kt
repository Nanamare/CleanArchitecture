package com.template.nanamare.domain.model

data class VideoModel(
    val id: Int,
    val results: List<ResultModel>
): BaseDomainModel