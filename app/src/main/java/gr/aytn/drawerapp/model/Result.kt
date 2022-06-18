package gr.aytn.drawerapp.model

import com.google.gson.annotations.SerializedName


data class Result (

    @SerializedName("sha"          ) var sha         : String?            = null,
    @SerializedName("node_id"      ) var nodeId      : String?            = null,
    @SerializedName("commit"       ) var commit      : Commit?            = Commit(),
    @SerializedName("url"          ) var url         : String?            = null,
    @SerializedName("html_url"     ) var htmlUrl     : String?            = null,
    @SerializedName("comments_url" ) var commentsUrl : String?            = null,
    @SerializedName("author"       ) var author2      : Author2?            = Author2(),
    @SerializedName("committer"    ) var committer2   : Committer2?         = Committer2(),
    @SerializedName("parents"      ) var parents     : ArrayList<Parents> = arrayListOf()

)