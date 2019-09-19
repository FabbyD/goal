import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fabbyd.goal.R
import kotlinx.android.synthetic.main.item_repetition.view.*

class SetsAdapter(private val dataset: ArrayList<Int>) :
    RecyclerView.Adapter<SetsAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ViewHolder(view: View, val watcher: RepetitionTextWatcher) : RecyclerView.ViewHolder(view) {
        val text : TextView

        init {
            text = view.repetition
            text.addTextChangedListener(watcher)
        }
    }

    inner class RepetitionTextWatcher : TextWatcher {
        var position: Int = 0

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // no op
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val str = s.toString()
            try {
                val i = str.toInt()
                dataset[position] = i
            }
            catch (ex: NumberFormatException) {
                // not a number
            }
        }

        override fun afterTextChanged(s: Editable?) {
            // no op
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repetition, parent, false)

        return ViewHolder(view, RepetitionTextWatcher())
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.watcher.position = holder.adapterPosition
        holder.text.repetition.setText(dataset[position].toString())
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataset.size
}