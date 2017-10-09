package com.dev.jieun.firstkotilnapp.api

import com.dev.jieun.firstkotilnapp.BuildConfig
import com.dev.jieun.firstkotilnapp.data.model.PhotoContainer
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ContentService {
    @GET("?method=flickr.photos.search&format=json&privacy_filter=1&nojsoncallback=1&safe_search=1&api_key=${BuildConfig.FLICKR_API_KEY}")
    fun getSearchPhotos (@Query(value = "text", encoded = true) searchKeyword: String,
                         @Query("page") page : Int,
                         @Query("per_page") perPage: Int) : Single<PhotoContainer>
}