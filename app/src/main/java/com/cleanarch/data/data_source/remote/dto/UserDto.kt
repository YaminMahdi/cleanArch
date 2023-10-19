package com.cleanarch.data.data_source.remote.dto

import com.cleanarch.domain.model.User

data class UserDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
){
    fun toUser(): User = User(id = this.id, name = this.title, email = this.body)
}