import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fabbyd.goal.R
import kotlinx.android.synthetic.main.item_repetition.view.*

class SetsAdapter(private val dataset: ArrayList<Int>) :
    RecyclerView.Adapter<SetsAdapter.RepetitionViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class RepetitionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text : TextView

        init {
            text = view.repetition
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RepetitionViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repetition, parent, false)

        return RepetitionViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: RepetitionViewHolder, position: Int) {
        holder.text.repetition.setText(dataset[position].toString())
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataset.size
}