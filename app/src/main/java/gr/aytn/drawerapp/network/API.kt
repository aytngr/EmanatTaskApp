package gr.aytn.drawerapp.network
import gr.aytn.drawerapp.model.PostData
import gr.aytn.drawerapp.model.PostResponse
import gr.aytn.drawerapp.model.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface API {
    @GET("commits")
    fun getCommits(): Call<List<Result>>


    @POST("json")
    fun savePost(@Body postData: PostData) : Call<PostResponse>

}