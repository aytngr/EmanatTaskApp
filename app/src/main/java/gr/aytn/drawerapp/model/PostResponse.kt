package gr.aytn.drawerapp.model

import com.google.gson.annotations.SerializedName

data class PostResponse (
    @SerializedName("success" ) var success : String? = null
        )