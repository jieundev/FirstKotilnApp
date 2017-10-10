package com.dev.jieun.firstkotilnapp.ui.widget.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

interface ViewDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup, context: Context): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}