package com.sharmila.android.kotlin.flickerimagesearch.network

import com.sharmila.android.kotlin.flickerimagesearch.utils.Utils
import com.sharmila.android.kotlin.flickerimagesearch.model.PhotoList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

public interface ApiInterface {
    @Headers("Accept: Application/JSON")
    @GET("https://api.flickr.com/services/rest/")
    fun getPhotoList(
        @Query(Utils.METHOD) method: String,
        @Query(Utils.API_KEY) api_key: String,
        @Query(Utils.FORMAT) format: String,
        @Query(Utils.NOJSONCALLBACK) noJsonCallback: String,
        @Query(Utils.TEXT) text: String
    ): Call<PhotoList>
}