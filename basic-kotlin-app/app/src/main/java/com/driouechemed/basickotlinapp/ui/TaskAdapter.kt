package com.driouechemed.basickotlinapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.driouechemed.basickotlinapp.R
import com.driouechemed.basickotlinapp.database.entities.Task
import com.driouechemed.basickotlinapp.databinding.AdapterTaskBinding

class TaskAdapter(private val tasks: ArrayList<Task> = ArrayList()) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.adapter_task, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(tasks[position])
    }

    override fun getItemCount() = tasks.size

    fun addTask(task: Task) {
        tasks.add(task)
        notifyItemChanged(tasks.size - 1)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding: AdapterTaskBinding = AdapterTaskBinding.bind(view)

        fun bind(task: Task) {
            binding.taskName.text = task.name
            if (task.details.isNullOrEmpty()) {
                binding.taskDetails.visibility = GONE
            } else {
                binding.taskDetails.text = task.details
            }
        }
    }
}
