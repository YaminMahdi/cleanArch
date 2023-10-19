package com.cleanarch.data.data_source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cleanarch.domain.model.User

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    val name: String="",
    val email: String =""
){
    fun toUser() : User = User(id = this.id.toInt(), name = this.name, email = this.email)
}
