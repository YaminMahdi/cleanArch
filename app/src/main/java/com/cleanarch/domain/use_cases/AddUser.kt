package com.cleanarch.domain.use_cases

import com.cleanarch.domain.model.User
import com.cleanarch.domain.repo.MainRepo
import javax.inject.Inject

class AddUser @Inject constructor(
    val repo: MainRepo
) {
    suspend operator fun invoke(user: User): Boolean =
        if(user.name.isEmpty())
            false
        else if(user.email.isEmpty())
            false
        else{
            repo.addUser(user)
            true
        }
}