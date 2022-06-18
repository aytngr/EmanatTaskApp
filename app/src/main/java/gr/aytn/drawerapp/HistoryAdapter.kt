package gr.aytn.drawerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import gr.aytn.drawerapp.ui.history.HistoryFragment
import java.security.AccessController.getContext

class HistoryAdapter(private val mList: ArrayList<HistoryItem>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private lateinit var view : View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item


        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_reycyleview_row, parent, false)



        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val historyItem = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.iconImage.setImageResource(historyItem.icon)
        holder.btnDelete.setImageResource(historyItem.deleteIcon)

        // sets the text to the textview from our itemHolder class
        holder.tvName.text = historyItem.name
        holder.tvPrice.text = "${historyItem.price.toString()} USD"
        holder.tvDescription.text = historyItem.description

        holder.btnDelete.setOnClickListener{
            removeItem(historyItem)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val iconImage : ImageView = itemView.findViewById(R.id.history_icon)
        val tvName : TextView = itemView.findViewById(R.id.history_name)
        val tvPrice : TextView = itemView.findViewById(R.id.history_price)
        val tvDescription : TextView = itemView.findViewById(R.id.history_description)
        val btnDelete : ImageButton = itemView.findViewById(R.id.delete_button)
    }

    fun removeItem(item: HistoryItem) {
        val builder = AlertDialog.Builder(view.rootView.context)
        builder.setTitle("Delete")
        builder.setMessage("Are you sure to delete this item?")
        //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton("Delete") { dialog, which ->
            val position = mList.indexOf(item)
            mList.remove(item)
            notifyItemRemoved(position)
        }

        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
        }

        builder.show()




    }

}