package com.dev.jieun.firstkotilnapp.ui.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.dev.jieun.firstkotilnapp.data.model.Photo
import com.dev.jieun.firstkotilnapp.ui.base.BaseViewHolder

interface ViewDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup, context: Context): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}