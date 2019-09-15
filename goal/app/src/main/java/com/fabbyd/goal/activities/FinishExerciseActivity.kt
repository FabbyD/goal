package com.fabbyd.goal.activities

import SetsAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.fabbyd.goal.R
import kotlinx.android.synthetic.main.activity_finish_exercise.*

class FinishExerciseActivity() : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val sets: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_exercise)

        viewManager = LinearLayoutManager(this)
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
            sets.add(sets.count())
            viewAdapter.notifyDataSetChanged()
        }
    }
}
