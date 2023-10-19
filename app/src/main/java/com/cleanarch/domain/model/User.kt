package com.cleanarch.domain.model

import com.cleanarch.data.data_source.local.entity.UserEntity

data class User(val id: Int=0, val name: String="", val email: String =""){
    fun toUserEntity() : UserEntity = UserEntity(id = this.id.toLong(), name = this.name, email = this.email)
}
