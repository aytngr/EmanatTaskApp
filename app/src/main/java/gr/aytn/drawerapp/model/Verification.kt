package gr.aytn.drawerapp.model

import com.google.gson.annotations.SerializedName


data class Verification (

    @SerializedName("verified"  ) var verified  : Boolean? = null,
    @SerializedName("reason"    ) var reason    : String?  = null,
    @SerializedName("signature" ) var signature : String?  = null,
    @SerializedName("payload"   ) var payload   : String?  = null

)