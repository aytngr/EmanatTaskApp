package gr.aytn.drawerapp.ui.history

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gr.aytn.drawerapp.*
import gr.aytn.drawerapp.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var historyViewModel: HistoryViewModel
    private var _binding: FragmentHistoryBinding? = null
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

        val recyclerview = root.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerview.layoutManager = LinearLayoutManager(getContext())


        historyViewModel.getHistoryItemList().observe(viewLifecycleOwner, Observer{
            val adapter = HistoryAdapter(it)
            recyclerview.adapter = adapter


        })
        binding.addButton.setOnClickListener{

            val builder = android.app.AlertDialog.Builder(context, R.style.CustomAlertDialog)
                .create()
            val view = layoutInflater.inflate(R.layout.add_item, null)
            val addButton = view.findViewById<Button>(R.id.btnAdd)
            val cancelButton = view.findViewById<Button>(R.id.btnCancel)
            val etName: EditText = view.findViewById(R.id.new_history_name)
            val etPrice:EditText = view.findViewById(R.id.new_history_price)
            builder.setView(view)
            addButton.setOnClickListener {
                val name = etName.text.toString()
                val price = etPrice.text.toString()
                if(name == "" || price == ""){
                    println("historyfragment if")
                    etName.error = "Please write a name!"
                    etPrice.error = "Please write a price!"
                }else{
                    println("historyfragment else")
                    historyViewModel.addHistoryItem(HistoryItem(R.drawable.history_image, name, price.toFloat(), "It is a long established fact that a reader will be distracted",R.drawable.delete))
                    recyclerview.adapter?.notifyDataSetChanged()
                    builder.dismiss()
                }
            }
            cancelButton.setOnClickListener {
                builder.dismiss()
            }
            builder.setCanceledOnTouchOutside(false)
            builder.show()
//            val view = inflater.inflate(R.layout.add_item,null)
//
//            val etName: EditText = view.findViewById(R.id.new_history_name)
//            val etPrice:EditText = view.findViewById(R.id.new_history_price)
//
//            val builder = AlertDialog.Builder(inflater.context)
//            val alertDialog = builder.create()
//            alertDialog.setCanceledOnTouchOutside(true);
//            alertDialog.setCancelable(true);
//            builder.setView(view)
//
//
//            builder.setPositiveButton("Add"){
//                    dialog,which->
//                val name = etName.text.toString()
//                val price = etPrice.text.toString()
//                if(name == "" || price == ""){
//                    println("historyfragment if")
//                    etName.error = "Please write a name!"
//                    etPrice.error = "Please write a price!"
//                }else{
//                    println("historyfragment else")
//                    historyViewModel.addHistoryItem(HistoryItem(R.drawable.history_image, name, price.toFloat(), "It is a long established fact that a reader will be distracted",R.drawable.delete))
//                    recyclerview.adapter?.notifyDataSetChanged()
//                    dialog.dismiss()
//                }
//
//            }
//            builder.setNegativeButton("Cancel"){
//                    dialog,which->
//                dialog.dismiss()
//                println("historyfragment cancel")
//
//            }
//            builder.show()

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}