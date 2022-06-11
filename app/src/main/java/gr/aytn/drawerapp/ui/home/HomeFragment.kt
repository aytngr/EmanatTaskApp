package gr.aytn.drawerapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gr.aytn.drawerapp.*
import gr.aytn.drawerapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        var names: ArrayList<String> = arrayListOf(
            "UltraBoost19",
            "Clear Shampoo",
            "FairPrice Clementi",
            "Supersonic",
            "iPad Pro Cover"
        )
        var dates: ArrayList<String> =
            arrayListOf("Sun, 5 Jan", "Sat, 4 Jan", "Fri, 3 Jan", "Thu, 2 Jan", "Wed, 1 Jan")
        var amounts: ArrayList<Int> = arrayListOf(25345, 25452, 5788, 987, 3242)


        val recyclerview = root.findViewById<RecyclerView>(R.id.recycler_view)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(getContext())

        // ArrayList of class ItemsViewModel
        val data = ArrayList<Item>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 0..4) {
            data.add(Item(R.drawable.icon, names[i], dates[i], amounts[i]))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}