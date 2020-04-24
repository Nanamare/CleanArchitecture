package com.template.nanamare.data.source.remote.mapper

import com.template.nanamare.data.model.BaseData
import com.template.nanamare.data.network.model.BaseRemoteModel
import com.template.nanamare.data.network.response.BaseResponse

interface RemoteMapper<Remote : BaseRemoteModel, Data : BaseData> {
    fun mapToRemote(from: Data): Remote
    fun mapToData(from: Remote): Data
}