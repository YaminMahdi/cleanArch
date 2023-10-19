package com.cleanarch.domain.repo

import com.cleanarch.domain.model.User

interface MainRepo {
    fun getUser() : User

    suspend fun getAllUser(): List<User>

    suspend fun addUser(user: User)
}