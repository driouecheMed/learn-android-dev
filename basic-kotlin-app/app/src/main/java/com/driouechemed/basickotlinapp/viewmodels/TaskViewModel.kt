package com.driouechemed.basickotlinapp.viewmodels

import androidx.lifecycle.*
import com.driouechemed.basickotlinapp.database.entities.Task
import com.driouechemed.basickotlinapp.repositories.TaskRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private val tasksLiveData = MutableLiveData<ArrayList<Task>>()

    init {
        viewModelScope.launch{
            taskRepository.getAll().collect {
                        tasks -> tasksLiveData.value = ArrayList(tasks)
                }
        }
    }

    fun insert(task: Task) {
        viewModelScope.launch { taskRepository.insert(task) }
    }

    fun getTasksLiveData(): LiveData<ArrayList<Task>> {
        return tasksLiveData;
    }

    class Factory(private val taskRepository: TaskRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TaskViewModel(taskRepository) as T
        }
    }
}