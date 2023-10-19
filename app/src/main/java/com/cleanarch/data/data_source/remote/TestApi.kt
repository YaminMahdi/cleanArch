package com.cleanarch.data.data_source.remote

import com.cleanarch.data.data_source.remote.dto.UserDto
import com.cleanarch.domain.model.User
import retrofit2.http.GET
import retrofit2.http.POST

interface TestApi {

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

    @GET("/posts")
    suspend fun getData(): List<UserDto>
}