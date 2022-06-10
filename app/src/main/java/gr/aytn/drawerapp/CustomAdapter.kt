package gr.aytn.drawerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gr.aytn.drawerapp.R
import gr.aytn.drawerapp.Item

class CustomAdapter(private val mList: ArrayList<Item>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.reycyleview_row, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Item = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.iconImage.setImageResource(Item.icon)

        // sets the text to the textview from our itemHolder class
        holder.tvName.text = Item.name
        holder.tvDate.text = Item.date
        holder.tvAmount.text = "-$${Item.amount.toString()}"

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val iconImage : ImageView = itemView.findViewById(R.id.icon)
        val tvName : TextView = itemView.findViewById(R.id.name)
        val tvDate : TextView = itemView.findViewById(R.id.date)
        val tvAmount : TextView = itemView.findViewById(R.id.amount)
    }
}
