package com.driouechemed.basickotlinapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.driouechemed.basickotlinapp.database.entities.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll(): Flow<List<Task>>

    @Insert
    suspend fun insert(task: Task)
}