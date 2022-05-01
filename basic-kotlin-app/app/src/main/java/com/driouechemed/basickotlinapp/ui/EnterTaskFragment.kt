package com.driouechemed.basickotlinapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.driouechemed.basickotlinapp.R
import com.driouechemed.basickotlinapp.database.DatabaseProvider
import com.driouechemed.basickotlinapp.database.entities.Task
import com.driouechemed.basickotlinapp.databinding.FragmentEnterTaskBinding
import com.driouechemed.basickotlinapp.repositories.TaskRepositoryImpl
import com.driouechemed.basickotlinapp.viewmodels.TaskViewModel

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
        val taskRepository = TaskRepositoryImpl(DatabaseProvider.getInstance(requireContext()))
        val viewModelFactory = TaskViewModel.Factory(taskRepository)
        val taskViewModel = ViewModelProvider(this, viewModelFactory).get(TaskViewModel::class.java)

        taskViewModel.getTasksLiveData().observe(viewLifecycleOwner, taskAdapter::addTasks)

        binding.taskList.adapter = taskAdapter

        binding.validateButton.setOnClickListener {
            if (binding.taskName.editText?.text.toString().isEmpty()) {
                binding.taskName.editText?.error = getString(R.string.mandatory_field)
            } else {
                taskViewModel.insert(getFieldsData())
                clearInputFields()
            }
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