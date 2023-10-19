package com.cleanarch.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleanarch.domain.model.User
import com.cleanarch.domain.use_cases.MainUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCases: MainUseCases
): ViewModel() {
//    fun getUser(success: (user: User) -> Unit){
//        viewModelScope.launch(Dispatchers.IO){
//            val user = mainUseCases.getUser()
//            Log.d("TAG", "getUser: $user")
//            success.invoke(user)
//        }
//    }

    fun getAllUser(success: (list: List<User>) -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            val lst = mainUseCases.getAllUser()
            Log.d("TAG", "getAllUser: $lst")
            success.invoke(lst)
        }
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            val x = mainUseCases.addUser(user)
            Log.d("TAG", "addUser: $x")
        }
    }
}