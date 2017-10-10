package com.dev.jieun.firstkotilnapp.ui

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.dev.jieun.firstkotilnapp.R
import com.dev.jieun.firstkotilnapp.ui.base.BaseActivity
import com.dev.jieun.firstkotilnapp.util.replaceFragmentToActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val toolbar: Toolbar by lazy {
        findViewById<Toolbar>(R.id.toolbar) as Toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = getString(R.string.app_name)
        replaceFragmentToActivity(MainFragment.INSTANCE, R.id.layFrameRoot, MainFragment.TAG)
    }
}
