package com.dev.jieun.firstkotilnapp.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Administrator on 2017-10-01.
 */
abstract class BaseActivity : RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    fun setArrowToolbar(title : String =""){
        toolbar?.let {
            toolbar.title = title
            setSupportActionBar(it)
            it.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }
}