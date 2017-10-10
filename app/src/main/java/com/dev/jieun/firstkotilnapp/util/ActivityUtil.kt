package com.dev.jieun.firstkotilnapp.util

import android.support.v7.app.AppCompatActivity
import com.dev.jieun.firstkotilnapp.ui.base.BaseFragment

/**
 * Created by Administrator on 2017-10-09.
 */

fun AppCompatActivity.replaceFragmentToActivity(fragment: BaseFragment, frameId: Int) {
    val transaction = this.supportFragmentManager.beginTransaction()
    transaction.replace(frameId, fragment)
    transaction.commit()
}