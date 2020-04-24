package com.template.nanamare.presentation.mapper

import com.template.nanamare.domain.model.BaseDomainModel
import com.template.nanamare.presentation.model.BasePresentation

// viewModel 에서 전달된 값을 Mapper 를 통해 UseCase(도메인 레이어에 전달될 수 있는 추상화 된 형식) 로 변환
interface PresentationMapper<Domain : BaseDomainModel, Presentation : BasePresentation> {
    fun mapToPresentation(from: Domain): Presentation
    fun mapToModel(from: Presentation): Domain
}