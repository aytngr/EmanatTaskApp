package gr.aytn.drawerapp.model

import com.google.gson.annotations.SerializedName


data class Commit (

    @SerializedName("author"        ) var author       : Author?       = Author(),
    @SerializedName("committer"     ) var committer    : Committer?    = Committer(),
    @SerializedName("message"       ) var message      : String?       = null,
    @SerializedName("tree"          ) var tree         : Tree?         = Tree(),
    @SerializedName("url"           ) var url          : String?       = null,
    @SerializedName("comment_count" ) var commentCount : Int?          = null,
    @SerializedName("verification"  ) var verification : Verification? = Verification()

)