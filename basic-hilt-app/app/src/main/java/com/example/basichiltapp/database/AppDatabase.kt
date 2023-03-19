package com.example.basichiltapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basichiltapp.database.daos.UserDao
import com.example.basichiltapp.database.entities.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
}
