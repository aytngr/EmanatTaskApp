package gr.aytn.drawerapp.model

import com.google.gson.annotations.SerializedName


data class Committer (

    @SerializedName("name"  ) var name  : String? = null,
    @SerializedName("email" ) var email : String? = null,
    @SerializedName("date"  ) var date  : String? = null

)