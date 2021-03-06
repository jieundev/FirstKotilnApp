package com.dev.jieun.firstkotilnapp.ui.gallery

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dev.jieun.firstkotilnapp.R
import com.dev.jieun.firstkotilnapp.data.model.Photo
import com.dev.jieun.firstkotilnapp.ui.widget.adapter.ViewDelegateAdapter
import com.dev.jieun.firstkotilnapp.ui.widget.adapter.ViewType
import kotlinx.android.synthetic.main.item_photo_view.view.*

/**
 * Created by Administrator on 2017-10-09.
 */
class ImageDelegateAdapter(val context: Context, val itemClick: (Photo)->Unit) : ViewDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, context: Context): RecyclerView.ViewHolder {
        // println("image delegate create")
        return ViewHolder(parent, this.context)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ViewHolder
        // println("call onBind (glide)")
        holder.onBind(item as Photo)
    }

    inner class ViewHolder(parent: ViewGroup, context: Context) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout
            .item_photo_view, parent, false)) {
        fun onBind(photo: Photo){
            // println("call glide1 url : " +photo.getImageUrl())
            itemView.run {
                setOnClickListener {
                    itemClick(photo)
                }
                Glide.with(context).load(photo.getImageUrl()).apply(RequestOptions().fitCenter()).into(img_photo)
                // println("call glide2 url : " +photo.getImageUrl())
            }
        }
    }
}
