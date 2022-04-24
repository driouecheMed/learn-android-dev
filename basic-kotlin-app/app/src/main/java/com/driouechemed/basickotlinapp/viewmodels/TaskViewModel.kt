package com.driouechemed.basickotlinapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.driouechemed.basickotlinapp.database.DatabaseProvider
import com.driouechemed.basickotlinapp.database.entities.Task
import com.driouechemed.basickotlinapp.repositories.TaskRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val tasksLiveData = MutableLiveData<ArrayList<Task>>()

    /*
    todo: init repo in constructor
    private val taskRepository: TaskRepository
    init {
        taskRepository = TaskRepository(DatabaseProvider.getInstance(getApplication()))

    }*/

    init {
        viewModelScope.launch{
            TaskRepository(DatabaseProvider.getInstance(getApplication()))
                .getAll().collect {
                        tasks -> tasksLiveData.value = ArrayList(tasks)
                }
        }
    }

    fun insert(task: Task) {
        viewModelScope.launch { TaskRepository(DatabaseProvider.getInstance(getApplication())).insert(task) }
    }

    fun getTasksLiveData(): LiveData<ArrayList<Task>> {
        return tasksLiveData;
    }
}