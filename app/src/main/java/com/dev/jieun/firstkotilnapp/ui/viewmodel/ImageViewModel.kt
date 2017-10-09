package com.dev.jieun.firstkotilnapp.ui.viewmodel

import com.dev.jieun.firstkotilnapp.data.FlickrRepository
import com.dev.jieun.firstkotilnapp.data.model.Photo
import com.dev.jieun.firstkotilnapp.ui.base.BaseActivity
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2017-10-09.
 */
class ImageViewModel(private val activity: BaseActivity, private val repository: FlickrRepository) {
    lateinit var showProgress: () -> Unit
    lateinit var hideProgress: () -> Unit
    lateinit var addItem: (List<Photo>) -> Unit
    private val PER_PAGE = 50

    fun fetchPhotoList(page: Int, searchText : String) {
        print("api service search : "+searchText)
        repository.getPhotos(page, PER_PAGE, searchText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(activity, ActivityEvent.DESTROY)
                .doOnSubscribe {
                    if (page == 1) {
                        showProgress()
                    }
                }
                .doFinally {
                    hideProgress()
                }
                .subscribe({
                    addItem(it)
                }, {})
    }
}