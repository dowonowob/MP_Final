package com.example.fitnessapp.data.repository

import com.example.fitnessapp.data.dao.UserDao
import com.example.fitnessapp.data.model.UserProfile

class ProfileRepository(private val dao: UserDao) {
    suspend fun saveProfile(user: UserProfile) = dao.insert(user)
    suspend fun getProfile(): UserProfile? = dao.getUser()
}
