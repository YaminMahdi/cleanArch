package com.cleanarch.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cleanarch.domain.model.User
import com.cleanarch.domain.use_cases.MainUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCases: MainUseCases
): ViewModel() {
    fun getUser(): User{
        val user = mainUseCases.getUser()
        Log.d("TAG", "getUser: $user")
        return user
    }

    fun getAllUser(): List<User>{
        val lst = mainUseCases.getAllUser()
        Log.d("TAG", "getUser: $lst")
        return lst
    }
}