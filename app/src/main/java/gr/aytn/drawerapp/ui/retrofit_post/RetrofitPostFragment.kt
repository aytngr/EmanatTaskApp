package gr.aytn.drawerapp.ui.retrofit_post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import gr.aytn.drawerapp.databinding.FragmentRetrofitPostBinding
import gr.aytn.drawerapp.model.PostData

class RetrofitPostFragment : Fragment() {
    private lateinit var retrofitPostviewModel : RetrofitPostViewModel
    private var _binding: FragmentRetrofitPostBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState:Bundle?
    ):View{
        retrofitPostviewModel = ViewModelProvider(this).get(RetrofitPostViewModel::class.java)

        _binding = FragmentRetrofitPostBinding.inflate(inflater,container,false)
        val root: View = binding.root

        var etCustomer: EditText = binding.customer
        var etQuantity: EditText = binding.quantity
        var etPrice: EditText = binding.price
        var btnPost: Button = binding.btnPost
        var tvResult: TextView = binding.tvResult

        btnPost.setOnClickListener {
            var customer = etCustomer.text.toString()
            var quantity = etQuantity.text.toString().toInt()
            var price = etPrice.text.toString().toDouble()
            retrofitPostviewModel.sendPost(PostData(1111,customer,quantity,price)).observe(viewLifecycleOwner, Observer{
                tvResult.text = it.toString()
            })
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}