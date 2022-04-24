package com.driouechemed.basickotlinapp.repositories

import com.driouechemed.basickotlinapp.database.AppDatabase
import com.driouechemed.basickotlinapp.database.entities.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(appDatabase: AppDatabase) {
    private val appDatabase: AppDatabase = appDatabase

    suspend fun insert(task: Task) {
        return appDatabase.taskDao().insert(task)
    }

    fun getAll(): Flow<List<Task>> {
        return appDatabase.taskDao().getAll()
    }
}