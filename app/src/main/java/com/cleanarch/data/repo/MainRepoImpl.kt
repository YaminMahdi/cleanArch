package com.cleanarch.data.repo

import com.cleanarch.data.data_source.local.room.UserDao
import com.cleanarch.data.data_source.remote.TestApi
import com.cleanarch.domain.model.User
import com.cleanarch.domain.repo.MainRepo
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepoImpl @Inject constructor(
    private val email: String,
    private val userDao: UserDao,
    private val testApi: TestApi
): MainRepo {
    override fun getUser(): User {
        val x= userDao.getAllUser()
        return if(x.isNotEmpty())
            userDao.getAllUser()[0].toUser()
        else
            User(id = 4829, name = "Doreen Barnes", email = "harriett.rivas@example.com")
    }

//    override fun getAllUser(): List<User> = userDao.getAllUser().map { it.toUser() }

    override suspend fun getAllUser(): List<User> {
        return try {
            testApi.getData().map { it.toUser() }
        } catch (ex: Exception){
            ex.printStackTrace()
            emptyList()
        }
    }


    override suspend fun addUser(user: User) {
        userDao.addUser(user.toUserEntity())
    }
}