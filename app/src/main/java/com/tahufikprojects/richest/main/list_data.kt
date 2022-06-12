package com.tahufikprojects.richest.main

import android.os.Parcel
import android.os.Parcelable

data class list_data(
    var day: String?,
    var value: String?,
    var im_photo: Int,
) : Parcelable {
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

    companion object CREATOR : Parcelable.Creator<list_data> {
        override fun createFromParcel(parcel: Parcel): list_data {
            return list_data(parcel)
        }

        override fun newArray(size: Int): Array<list_data?> {
            return arrayOfNulls(size)
        }
    }
}