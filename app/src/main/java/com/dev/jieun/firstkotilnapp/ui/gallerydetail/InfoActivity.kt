package com.dev.jieun.firstkotilnapp.ui.gallerydetail

import android.os.Bundle
import com.dev.jieun.firstkotilnapp.R
import com.dev.jieun.firstkotilnapp.ui.base.BaseActivity
import com.dev.jieun.firstkotilnapp.util.replaceFragmentToActivity

class InfoActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setArrowToolbar("Info")
        replaceFragmentToActivity(InfoFragment.INSTANCE(intent.extras), R.id.layFrameRoot)
    }
}
