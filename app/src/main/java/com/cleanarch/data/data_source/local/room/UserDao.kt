package com.cleanarch.data.data_source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.cleanarch.data.data_source.local.entity.UserEntity
import javax.inject.Inject

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAllUser(): List<UserEntity>

    @Upsert
    suspend fun addUser(user: UserEntity): Long
}