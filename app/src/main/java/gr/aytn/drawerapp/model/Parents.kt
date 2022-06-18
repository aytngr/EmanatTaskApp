package gr.aytn.drawerapp.model

import com.google.gson.annotations.SerializedName


data class Parents (

    @SerializedName("sha"      ) var sha     : String? = null,
    @SerializedName("url"      ) var url     : String? = null,
    @SerializedName("html_url" ) var htmlUrl : String? = null

)