package gr.aytn.drawerapp.ui.slideshow

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gr.aytn.drawerapp.MainRepository
import gr.aytn.drawerapp.model.Result
import gr.aytn.drawerapp.network.API
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SlideshowViewModel : ViewModel() {

    private var myResponseList = MutableLiveData<List<Result>>()
    private val repository = MainRepository()
    val errorMessage = MutableLiveData<String>()


    fun getCommits(): LiveData<List<Result>> {
        Log.i("fragment", "in the getcommits")
        val response = repository.getCommits()
        response.enqueue(object : Callback<List<Result>> {
            override fun onResponse(call: Call<List<Result>>, response: Response<List<Result>>) {
                myResponseList.postValue(response.body())
                Log.i("fragment", "onresponse")
            }

            override fun onFailure(call: Call<List<Result>>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.i("fragment", "onfailure")
            }
        })
        return myResponseList
    }

}