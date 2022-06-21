package gr.aytn.drawerapp.model

import com.google.gson.annotations.SerializedName

data class PostData(
    @SerializedName("Id"       ) var Id: Int?,
    @SerializedName("Customer" ) var Customer: String?,
    @SerializedName("Quantity" ) var Quantity: Int?,
    @SerializedName("Price"    ) var Price: Double?

        )
