package com.dev.jieun.firstkotilnapp.data

import com.dev.jieun.firstkotilnapp.api.FlickrApi
import com.dev.jieun.firstkotilnapp.data.model.Photo
import io.reactivex.Single

/**
 * Created by Administrator on 2017-10-09.
 */
object FlickrRepository {
    fun getPhotos(page: Int, perPage: Int, searchText: String) : Single<List<Photo>> =  FlickrApi.service.getSearchPhotos(searchText,page,perPage)
            .flatMap {
                if(it.photos.photo.isNotEmpty()){
                    Single.just(it.photos.photo)
                }else{
                    Single.just(ArrayList())
                }
            }
}