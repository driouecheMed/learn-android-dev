package com.example.basichiltapp.repository

import androidx.lifecycle.LiveData
import com.example.basichiltapp.database.daos.UserDao
import com.example.basichiltapp.database.entities.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {

    override suspend fun insertUser(users: List<User>) {
        return userDao.insertUsers(users)
    }

    override fun getUsers(): LiveData<List<User>> {
        return userDao.getAllUsers()
    }
}