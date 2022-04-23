package com.driouechemed.basickotlinapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.driouechemed.basickotlinapp.database.entities.Task
import com.driouechemed.basickotlinapp.databinding.FragmentEnterTaskBinding

class EnterTaskFragment : Fragment() {

    private lateinit var binding: FragmentEnterTaskBinding
    private val taskAdapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentEnterTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.taskList.adapter = taskAdapter
        binding.validateButton.setOnClickListener {
            taskAdapter.addTask(getFieldsData())
            clearInputFields()
        }
    }

    private fun getFieldsData(): Task {
        return Task(
            name=binding.taskName.editText?.text.toString(),
            details=binding.taskDetails.editText?.text.toString()
        )
    }

    private fun clearInputFields() {
        binding.taskName.clearFocus()
        binding.taskDetails.clearFocus()

        binding.taskName.editText?.text?.clear()
        binding.taskDetails.editText?.text?.clear()
    }
}