import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gr.aytn.drawerapp.Item
import gr.aytn.drawerapp.R
import gr.aytn.drawerapp.model.Result

class ApiAdapter(private val mList: List<Result>) : RecyclerView.Adapter<ApiAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.commit_row, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val commit = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.tvSha.text = commit.author2?.login
        holder.tvNodeId.text = commit.commit?.message

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvSha : TextView = itemView.findViewById(R.id.sha)
        val tvNodeId : TextView = itemView.findViewById(R.id.node_id)
    }
}