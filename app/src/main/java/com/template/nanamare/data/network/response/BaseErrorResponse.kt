package com.template.nanamare.data.network.response

data class BaseErrorResponse(
    val statusCode: Int,
    val statusMessage: String,
    val success: Boolean
)