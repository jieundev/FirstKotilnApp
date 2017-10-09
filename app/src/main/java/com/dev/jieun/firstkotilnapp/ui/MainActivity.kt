package com.dev.jieun.firstkotilnapp.ui

import android.os.Bundle
import com.dev.jieun.firstkotilnapp.R
import com.dev.jieun.firstkotilnapp.ui.base.BaseActivity
import com.dev.jieun.firstkotilnapp.util.replaceFragmentToActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setArrowToolbar(getString(R.string.app_name))

        replaceFragmentToActivity(MainFragment.INSTANCE, R.id.layFrameRoot, MainFragment.TAG)
    }
}
