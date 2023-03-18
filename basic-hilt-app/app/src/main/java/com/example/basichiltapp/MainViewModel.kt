package com.example.basichiltapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basichiltapp.database.entities.User
import com.example.basichiltapp.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            val users = listOf(
                User(name = "user-${Random.nextInt(1, 1000)}"),
                User(name = "user-${Random.nextInt(1, 1000)}"),
            )
            userRepository.insertUser(users)
        }
    }

    fun getUsers(): LiveData<List<User>> {
        return userRepository.getUsers()
    }

}
