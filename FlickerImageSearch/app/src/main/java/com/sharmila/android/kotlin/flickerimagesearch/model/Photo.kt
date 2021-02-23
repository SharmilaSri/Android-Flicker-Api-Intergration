package com.sharmila.android.kotlin.flickerimagesearch.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Photo(
        @SerializedName("id")
        @Expose
        var id: String?="",

        @SerializedName("owner")
        @Expose
        var owner:String?="",

        @SerializedName("secret")
        @Expose
        var secret:String?="",
        @SerializedName("server")
        @Expose
        var server:String?="",
        @SerializedName("farm")
        @Expose
        var farm:Int?=0,
        @SerializedName("title")
        @Expose
        var title:String?="",
        @SerializedName("ispublic")
        @Expose
        var ispublic:Int=0,
        @SerializedName("isfriend")
        @Expose
        var isfriend:Int=0,
        @SerializedName("isfamily")
        @Expose
        var isfamily:Int=0
){
        fun setId(id: String): Photo {
                this.id=id
                return this;
        }

        fun setOwner(owner: String): Photo {
                this.owner=owner
                return this;
        }

        fun setSecret(secret: String): Photo {
                this.secret=secret
                return this;
        }

        fun setServer(server: String): Photo {
                this.server=server
                return this;
        }

        fun setFarm(farm: Int): Photo {
                this.farm=farm
                return this;
        }

        fun setTitle(title: String): Photo {
                this.title=title
                return this;
        }

        fun setIspublic(isPublic: Int): Photo {
                this.ispublic=ispublic
                return this;
        }

        fun setIsfriend(isfriend: Int): Photo {
                this.isfriend=isfriend
                return this;
        }

        fun setIsfamily(isfamily:Int): Photo {
                this.isfamily=isfamily
                return this;
        }
}

