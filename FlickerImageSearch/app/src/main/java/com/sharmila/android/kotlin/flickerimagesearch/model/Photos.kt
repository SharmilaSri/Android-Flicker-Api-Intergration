package com.sharmila.android.kotlin.flickerimagesearch.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Photos(
        @SerializedName("page")
        @Expose
        var page:Int?=0,
        @SerializedName("pages")
        @Expose
        var pages:Int?=0,

        @SerializedName("perpage")
        @Expose
        var perpage:Int?=0,

        @SerializedName("total")
        @Expose
        var total:String?="",

        @SerializedName("photo")
        @Expose
        var photo: List<Photo>){

        fun setPage(page:Int): Photos {
                this.page=page
                return this;
        }

        fun setPages(pages:Int): Photos {
                this.pages=pages
                return this;
        }

        fun setTotal(total:String): Photos {
                this.total=total
                return this;
        }

        fun setPerpage(perpage:Int): Photos {
                this.perpage=perpage
                return this;
        }

        fun setPhoto(photo:List<Photo>): Photos {
                this.photo=photo
                return this;
        }

        override fun toString(): String {
                return photo.toString()
        }
}