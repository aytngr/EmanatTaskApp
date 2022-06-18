package gr.aytn.drawerapp.model

import com.google.gson.annotations.SerializedName


data class Tree (

    @SerializedName("sha" ) var sha : String? = null,
    @SerializedName("url" ) var url : String? = null

)