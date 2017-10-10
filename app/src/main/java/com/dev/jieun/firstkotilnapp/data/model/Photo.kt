package com.dev.jieun.firstkotilnapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.dev.jieun.firstkotilnapp.ui.adapter.LoadMoreAdapter
import com.dev.jieun.firstkotilnapp.ui.adapter.ViewType
import com.dev.jieun.firstkotilnapp.util.AdapterConstants

data class Photo (
        val id: String,
        val owner: String,
        val secret: String,
        val server: String,
        val farm: Int,
        val title: String,
        val ispublic: Int,
        val isfriend: Int,
        val isfamily: Int) : ViewType, Parcelable {

    constructor(parcel: Parcel) : this (
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()
    )

    override fun getViewType(): Int = AdapterConstants.ITEM
    fun getImageUrl(): String
            = "https://farm$farm.staticflickr.com/$server/${id}_${secret}_c.jpg"

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(id)
        dest?.writeString(owner)
        dest?.writeString(secret)
        dest?.writeString(server)
        dest?.writeInt(farm)
        dest?.writeString(title)
        dest?.writeInt(ispublic)
        dest?.writeInt(isfriend)
        dest?.writeInt(isfamily)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Photo> {
        override fun createFromParcel(parcel: Parcel): Photo {
            return Photo(parcel)
        }

        override fun newArray(size: Int): Array<Photo?> {
            return arrayOfNulls(size)
        }
    }
}
