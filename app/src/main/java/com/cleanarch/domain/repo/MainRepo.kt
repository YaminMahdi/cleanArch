package com.cleanarch.domain.repo

import com.cleanarch.domain.model.User

interface MainRepo {
    fun getUser() : User

    fun getAllUser(): List<User>
}