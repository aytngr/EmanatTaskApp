package gr.aytn.drawerapp.ui.history

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gr.aytn.drawerapp.HistoryAdapter
import gr.aytn.drawerapp.HistoryItem
import gr.aytn.drawerapp.R

class HistoryViewModel : ViewModel() {

    private var mutableLiveData = MutableLiveData<ArrayList<HistoryItem>>()
    var data = ArrayList<HistoryItem>()
    fun addHistoryItem(item:HistoryItem){
        data.add(0,item)
    }

    fun getHistoryItemList(): LiveData<ArrayList<HistoryItem>> {
        if (mutableLiveData.value == null){
            initHistoryItemList()
        }
        return mutableLiveData
    }

    private fun initHistoryItemList(){

        data.add(HistoryItem(R.drawable.history_image, "Luxury Home", 34F, "It is a long established fact that a reader will be distracted",R.drawable.delete))
        data.add(HistoryItem(R.drawable.history_image, "Gateway Motors", 23F, "It is a long established fact that a reader will be distracted",R.drawable.delete))
        data.add(HistoryItem(R.drawable.history_image, "Net Connect", 54F, "It is a long established fact that a reader will be distracted",R.drawable.delete))
        data.add(HistoryItem(R.drawable.history_image, "PowerDirect", 21F, "It is a long established fact that a reader will be distracted",R.drawable.delete))
        data.add(HistoryItem(R.drawable.history_image, "Hamilton Smith", 87F, "It is a long established fact that a reader will be distracted",R.drawable.delete))

        mutableLiveData.value = data
    }


}