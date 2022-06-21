package gr.aytn.drawerapp.ui.retrofit_post

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gr.aytn.drawerapp.MainRepository
import gr.aytn.drawerapp.model.PostData
import gr.aytn.drawerapp.model.PostResponse
import gr.aytn.drawerapp.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitPostViewModel : ViewModel() {

    private var myResponse = MutableLiveData<PostResponse>()
    private var repository: MainRepository = MainRepository()
    val errorMessage = MutableLiveData<String>()

    fun sendPost(postData: PostData): LiveData<PostResponse> {
        val response = repository.savePost(postData)
        response?.enqueue(object : Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if (response.isSuccessful()){
                    myResponse.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
        return myResponse
    }

}