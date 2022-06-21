package gr.aytn.drawerapp.network

class ApiUtils {
    val GET_BASE_URL:String = "https://api.github.com/repositories/19438/"
    val POST_BASE_URL:String = "https://reqbin.com/echo/post/"

    fun getGetAPIService(): API?{
        return RetrofitClient().getClient(GET_BASE_URL)?.create(API::class.java)
    }

    fun getPostAPIService(): API?{
        return RetrofitClient().getClient(POST_BASE_URL)?.create(API::class.java)
    }
}