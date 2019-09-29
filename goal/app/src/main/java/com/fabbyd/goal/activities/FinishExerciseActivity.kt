package com.fabbyd.goal.activities

import SetsAdapter
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.fabbyd.goal.R
import com.fabbyd.goal.definition.Exercise
import com.fabbyd.goal.definition.StrengthExercise
import kotlinx.android.synthetic.main.activity_finish_exercise.*

class FinishExerciseActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: SetsLayoutManager
    private val sets: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_exercise)

        val exercise = intent.getSerializableExtra("exercise") as? StrengthExercise
        if (exercise != null) {
            val numSets = exercise.sets
            for (i in 0 until numSets)
                sets.add(0)
            tempo.text = exercise.tempo.toString()

            weight.setText(exercise.load.toString())
        }

        viewManager = SetsLayoutManager(this, sets_recycler_view)
        viewAdapter = SetsAdapter(sets)

        recyclerView = sets_recycler_view.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        add_set_button.setOnClickListener {
            viewManager.shouldFocusLastChild = true
            sets.add(0)
            viewAdapter.notifyDataSetChanged()
        }

        remove_set_button.setOnClickListener {
            if (sets.count() > 0) {
                sets.removeAt(sets.count()-1)
                viewAdapter.notifyDataSetChanged()
            }
            if (sets.count() > 0)
                scrollToLastSet()
        }
    }

    private fun scrollToLastSet() {
//        recyclerView.smoothScrollToPosition(viewAdapter.itemCount-1)
    }

    private class SetsLayoutManager(context: Context, val recyclerView: RecyclerView) : LinearLayoutManager(context) {
        var shouldFocusLastChild = false

        override fun addView(child: View?) {
            super.addView(child)
            println("Adding child $shouldFocusLastChild")
            if (shouldFocusLastChild) {
                println("Focusing last child")
                smoothScrollToPosition(recyclerView, null, childCount-1)
                child?.requestFocus()
                shouldFocusLastChild = false
            }

        }
    }

}
