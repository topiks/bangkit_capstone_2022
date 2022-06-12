package com.tahufikprojects.richest.main

import android.os.Parcel
import android.os.Parcelable

data class ThingsToDo(
    var day: String?,
    var value: String?,
    var im_photo: Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(day)
        parcel.writeString(value)
        parcel.writeInt(im_photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ThingsToDo> {
        override fun createFromParcel(parcel: Parcel): ThingsToDo {
            return ThingsToDo(parcel)
        }

        override fun newArray(size: Int): Array<ThingsToDo?> {
            return arrayOfNulls(size)
        }
    }
}
