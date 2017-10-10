package com.dev.jieun.firstkotilnapp.ui.widget.adapter

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.jieun.firstkotilnapp.R

/**
 * Created by Administrator on 2017-10-09.
 */
class LoadDelegateAdapter(private val context : Context) : ViewDelegateAdapter{
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        when(holder.itemView.layoutParams){
            is StaggeredGridLayoutManager.LayoutParams->{
                val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                layoutParams.isFullSpan = true
            }
            is GridLayoutManager.LayoutParams ->{
                val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                layoutParams.isFullSpan = true
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, context: Context) = LoadingViewHolder(parent, this.context)

    class LoadingViewHolder(parent: ViewGroup, context: Context) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.footer, parent, false))
}