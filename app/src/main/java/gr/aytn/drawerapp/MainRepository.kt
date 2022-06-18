package gr.aytn.drawerapp

import gr.aytn.drawerapp.model.PostData
import gr.aytn.drawerapp.network.API

class MainRepository() {
    private val myApi: API = API.getInstance()
    fun getCommits() = myApi.getCommits()

    private val myPostApi: PostAPI = PostAPI.getInstance()
    fun createPost(postData: PostData) = myPostApi.createPost(postData)


}