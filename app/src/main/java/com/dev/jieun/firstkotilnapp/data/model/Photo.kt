package com.dev.jieun.firstkotilnapp.data.model

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
        val isfamily: Int) : ViewType {

    override fun getViewType(): Int = AdapterConstants.ITEM
    fun getImageUrl(): String
            = "https://farm$farm.staticflickr.com/$server/${id}_${secret}_c.jpg"

}