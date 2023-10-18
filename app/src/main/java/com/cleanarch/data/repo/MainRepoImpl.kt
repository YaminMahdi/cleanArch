package com.cleanarch.data.repo

import com.cleanarch.domain.model.User
import com.cleanarch.domain.repo.MainRepo
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepoImpl @Inject constructor(
    private val email: String
): MainRepo {
    override fun getUser(): User {
        return User(id = 6024, name = "Polly Collier", email = email)
    }

    override fun getAllUser(): List<User> {
        return listOf(
            User(id = 1554, name = "Shanna Robinson", email = "arnulfo.santos@example.com"),
            User(id = 3094, name = "Hattie Stout", email = "beatriz.phelps@example.com")
        )
    }
}