package com.driouechemed.basickotlinapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.driouechemed.basickotlinapp.database.dao.TaskDao
import com.driouechemed.basickotlinapp.database.entities.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}

object DatabaseProvider {
    private const val DATABASE_NAME: String = "lean_kotlin"
    private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (instance == null) {
            instance =  Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, DATABASE_NAME
                ).build()
        }
        return instance!!
    }
}
