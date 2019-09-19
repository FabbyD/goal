package com.fabbyd.goal.activities

import SetsAdapter
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import com.fabbyd.goal.R
import kotlinx.android.synthetic.main.activity_finish_exercise.*

class FinishExerciseActivity() : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: LinearLayoutManager
    private val sets: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_exercise)

        sets.add(0)

        viewManager = SetsLayoutManager(this)
        viewAdapter = SetsAdapter(sets)

        recyclerView = findViewById<RecyclerView>(R.id.sets_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            //setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        add_set_button.setOnClickListener {
            sets.add(0)
            viewAdapter.notifyDataSetChanged()
            scrollToLast()
        }

        remove_set_button.setOnClickListener {
            if (sets.count() > 0) {
                sets.removeAt(sets.count()-1)
                viewAdapter.notifyDataSetChanged()
            }
            if (sets.count() > 0)
                scrollToLast()
        }
    }

    private fun scrollToLast() {
        recyclerView.smoothScrollToPosition(viewAdapter.itemCount-1)
    }

    private class SetsLayoutManager(context: Context) : LinearLayoutManager(context) {
        override fun addView(child: View?) {
            super.addView(child)
            child?.findViewById<EditText>(R.id.repetition)?.requestFocus()
        }
    }
}
