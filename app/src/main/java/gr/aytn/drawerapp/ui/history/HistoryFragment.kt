package gr.aytn.drawerapp.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gr.aytn.drawerapp.*
import gr.aytn.drawerapp.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var historyViewModel: HistoryViewModel
    private var _binding: FragmentHistoryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        historyViewModel =
            ViewModelProvider(this).get(HistoryViewModel::class.java)

        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val root: View = binding.root
//////////////////////
        var names: ArrayList<String> = arrayListOf(
            "Luxury Home",
            "Gateway Motors",
            "Net Connect",
            "PowerDirect",
            "Hamilton Smith"
        )
        var prices: ArrayList<Int> =
            arrayListOf(34, 23, 54, 21, 87)

        var descriptions: ArrayList<String> = arrayListOf("It is a long established fact that a reader will be distracted by the readable content.", "It is a long established fact that a reader will be distracted by the readable content.", "It is a long established fact that a reader will be distracted by the readable content.", "It is a long established fact that a reader will be distracted by the readable content.", "It is a long established fact that a reader will be distracted by the readable content.")

        val recyclerview = root.findViewById<RecyclerView>(R.id.recycler_view)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(getContext())

        // ArrayList of class ItemsViewModel
        val data = ArrayList<HistoryItem>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 0..4) {
            data.add(HistoryItem(R.drawable.history_image, names[i], prices[i], descriptions[i],R.drawable.delete))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = HistoryAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        return root
        ////////////////////////////////////
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}