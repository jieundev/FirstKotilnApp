package com.dev.jieun.firstkotilnapp.ui.gallery

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.dev.jieun.firstkotilnapp.R
import com.dev.jieun.firstkotilnapp.ui.base.BaseActivity
import com.dev.jieun.firstkotilnapp.util.replaceFragmentToActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragmentToActivity(MainFragment.INSTANCE, R.id.layFrameRoot)
    }
}
