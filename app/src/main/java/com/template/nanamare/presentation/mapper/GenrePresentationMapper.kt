package com.template.nanamare.presentation.mapper

import com.template.nanamare.domain.model.GenreModel
import com.template.nanamare.presentation.model.GenrePresentation

object GenrePresentationMapper : PresentationMapper<GenreModel, GenrePresentation> {
    override fun mapToPresentation(from: GenreModel): GenrePresentation {
        return GenrePresentation(
            id = from.id,
            name = from.name
        )
    }

    override fun mapToModel(from: GenrePresentation): GenreModel {
        return GenreModel(
            id = from.id,
            name = from.name
        )
    }
}