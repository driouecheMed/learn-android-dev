package com.example.basichiltapp.repository

import androidx.lifecycle.LiveData
import com.example.basichiltapp.database.entities.User

interface UserRepository {
    suspend fun insertUser(users: List<User>)

    fun getUsers(): LiveData<List<User>>
}