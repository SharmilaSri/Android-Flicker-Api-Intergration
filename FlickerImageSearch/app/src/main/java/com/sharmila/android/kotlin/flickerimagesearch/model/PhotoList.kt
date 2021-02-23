package com.sharmila.android.kotlin.flickerimagesearch.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoList(
        @SerializedName("photos")
        @Expose
        public var photos: Photos? = null

){
        fun setPhotos(photo:Photos): PhotoList{
                this.photos=photo
                return this;
        }



        override fun toString(): String {
                return photos.toString()
        }
}


