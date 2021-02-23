package com.sharmila.android.kotlin.flickerimagesearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharmila.android.kotlin.flickerimagesearch.utils.Utils
import com.sharmila.android.kotlin.flickerimagesearch.model.PhotoList
import com.sharmila.android.kotlin.flickerimagesearch.network.ApiInterface
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityViewModel() : ViewModel() {

    //this is the data that we will fetch asynchronously
    private  lateinit var photoList:MutableLiveData<PhotoList>

    //we will call this method to get the data
     fun getPhotos(searchQuery:String): LiveData<PhotoList>{
        //if the list is null
            photoList=MutableLiveData<PhotoList>()
            //we will load it asynchronously from server in this method
        viewModelScope.launch {
            loadPhotolist(searchQuery)
        }

        //finally we will return the list
        return photoList
    }

    private suspend  fun loadPhotolist(searchQuery:String) {

        //This method is using Retrofit to get the JSON data from URL
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: ApiInterface = retrofit.create(ApiInterface::class.java)
        val call: Call<PhotoList> = api.getPhotoList(
            Utils.METHOD_VALUE,
            Utils.API_KEY_VALUE,
            Utils.FORMAT_VALUE,
            Utils.NOJSONCALLBACK_VALUE,
            searchQuery)
        call.enqueue(object : Callback<PhotoList> {
            override fun onResponse(
                call: Call<PhotoList>,
                response: Response<PhotoList>) {
                photoList.value=response.body()
            }

            override fun onFailure(call: Call<PhotoList>, t: Throwable) {
            }
        })
    }
}