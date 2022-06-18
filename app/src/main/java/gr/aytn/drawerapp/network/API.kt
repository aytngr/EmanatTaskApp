package gr.aytn.drawerapp.network
import gr.aytn.drawerapp.model.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
interface API {
    @GET("commits")
    fun getCommits(): Call<List<Result>>

    companion object {
        private var myApi: API? = null

        fun getInstance() : API {
            if (myApi == null) {
                val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/repositories/19438/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                myApi = retrofit.create(API::class.java)
            }
            return myApi!!
        }
    }

}