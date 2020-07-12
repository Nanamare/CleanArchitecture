package com.template.nanamare.presentation.model

import android.os.Parcel
import android.os.Parcelable

data class GenrePresentation(
    val id: Int,
    val name: String
) : BasePresentation, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GenrePresentation> {
        override fun createFromParcel(parcel: Parcel): GenrePresentation {
            return GenrePresentation(parcel)
        }

        override fun newArray(size: Int): Array<GenrePresentation?> {
            return arrayOfNulls(size)
        }
    }
}