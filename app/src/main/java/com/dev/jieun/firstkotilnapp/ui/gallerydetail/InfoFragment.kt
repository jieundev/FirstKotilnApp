package com.dev.jieun.firstkotilnapp.ui.gallerydetail

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dev.jieun.firstkotilnapp.R
import com.dev.jieun.firstkotilnapp.data.model.Photo
import com.dev.jieun.firstkotilnapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment : BaseFragment(){
    override fun getLayoutResource(): Int = R.layout.fragment_info
    private lateinit var activity : InfoActivity
    private val fab by lazy {
        activity.findViewById<FloatingActionButton>(R.id.fab) as FloatingActionButton
    }

    companion object {
        fun INSTANCE(bundle: Bundle) : InfoFragment { return InfoFragment().apply { arguments = bundle } }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val photo = arguments.getParcelable<Photo>("data")
        val imageUrl = photo.getImageUrl()

        imageUrl.let {
            Glide.with(context).load(imageUrl).apply(RequestOptions().optionalCenterInside()).into(imgContent)
        }

        txtTitle.text = photo.title
        txtFarm.text = photo.farm.toString()
        fab.let{
            fab.visibility = View.GONE
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as InfoActivity
    }
}
