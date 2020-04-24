package com.template.nanamare.data.mapper

import com.template.nanamare.data.model.BaseData
import com.template.nanamare.domain.model.BaseDomainModel

// Data layer - Domain layer 커뮤니케이
interface DataMapper<Data : BaseData, Domain : BaseDomainModel> {
    fun mapToModel(from: Data): Domain
    fun mapToData(from: Domain): Data
}