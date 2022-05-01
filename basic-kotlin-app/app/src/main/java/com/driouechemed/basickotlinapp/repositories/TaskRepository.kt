package com.driouechemed.basickotlinapp.repositories

import com.driouechemed.basickotlinapp.database.entities.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun insert(task: Task)

    fun getAll(): Flow<List<Task>>
}