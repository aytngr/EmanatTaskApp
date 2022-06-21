package gr.aytn.drawerapp

import gr.aytn.drawerapp.model.PostData
import gr.aytn.drawerapp.network.API
import gr.aytn.drawerapp.network.ApiUtils

class MainRepository() {


    private var mGetAPIService: API? = ApiUtils().getGetAPIService()
    private var mPostAPIService: API? = ApiUtils().getPostAPIService()

    fun getCommits() = mGetAPIService?.getCommits()
    fun savePost(postData: PostData) = mPostAPIService?.savePost(postData)



}