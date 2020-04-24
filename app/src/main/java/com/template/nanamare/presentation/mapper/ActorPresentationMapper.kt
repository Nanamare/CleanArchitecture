package com.template.nanamare.presentation.mapper

import com.template.nanamare.domain.model.CastModel
import com.template.nanamare.presentation.model.ActorPresentation
import java.security.InvalidParameterException

object ActorPresentationMapper : PresentationMapper<CastModel, ActorPresentation> {
    override fun mapToPresentation(from: CastModel): ActorPresentation {
        return ActorPresentation(name = from.name ?: "", profilePath = from.profilePath)
    }

    // not used
    override fun mapToModel(from: ActorPresentation): CastModel = throw InvalidParameterException()
}