package com.example.fitnessapp.data.dao

import androidx.room.*
import com.example.fitnessapp.data.model.UserProfile

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserProfile)

    @Query("SELECT * FROM user_profile LIMIT 1")
    suspend fun getUser(): UserProfile?

    @Update
    suspend fun update(user: UserProfile)
}
