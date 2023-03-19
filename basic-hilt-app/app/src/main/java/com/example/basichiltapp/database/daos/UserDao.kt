package com.example.basichiltapp.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.basichiltapp.database.entities.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertUsers(users: List<User>)

    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

}