package com.dev.jieun.firstkotilnapp.ui.adapter

import android.content.Context
import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView

import android.view.ViewGroup
import android.widget.AdapterView
import com.dev.jieun.firstkotilnapp.data.model.Photo
import com.dev.jieun.firstkotilnapp.ui.base.BaseViewHolder
import com.dev.jieun.firstkotilnapp.util.AdapterConstants
import java.util.ArrayList

class LoadMoreAdapter(val context: Context) :  RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var itemList = ArrayList<ViewType>()
    var delegateAdapters = SparseArrayCompat<ViewDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder
            = delegateAdapters.get(viewType).onCreateViewHolder(parent, context)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        holder?.let { delegateAdapters.get(getItemViewType(position)).onBindViewHolder(it, itemList[position]) }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int) = itemList[position].getViewType()

    fun getItem(position: Int) = itemList[position]

    fun addItems(items: List<ViewType>) {
        if (this.itemList.size != 0) {
            this.itemList.removeAt(itemList.size - 1)
        }
        this.itemList.addAll(items)
        this.itemList.add(loadingItem)
        notifyItemRangeInserted(this.itemList.size, items.size)
    }

    fun clear(){
        itemList.clear()
    }
}