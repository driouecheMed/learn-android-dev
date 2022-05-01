package com.driouechemed.basickotlinapp.repositories

import com.driouechemed.basickotlinapp.database.AppDatabase
import com.driouechemed.basickotlinapp.database.entities.Task
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(private val appDatabase: AppDatabase) : TaskRepository {

    override suspend fun insert(task: Task) {
        return appDatabase.taskDao().insert(task)
    }

    override fun getAll(): Flow<List<Task>> {
        return appDatabase.taskDao().getAll()
    }
}
