package com.dev.jieun.firstkotilnapp.util

import android.support.v7.app.AppCompatActivity
import com.dev.jieun.firstkotilnapp.ui.MainFragment

/**
 * Created by Administrator on 2017-10-09.
 */

fun AppCompatActivity.replaceFragmentToActivity(fragment: MainFragment, frameId: Int, tag: String) {
    val transaction = this.supportFragmentManager.beginTransaction()
    transaction.replace(frameId, fragment)
    transaction.commit()
}