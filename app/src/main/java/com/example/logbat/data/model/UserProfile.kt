package com.example.fitnessapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val gender: String,
    val age: Int,
    val height: Int,
    val weight: Int,
    val targetWeight: Int,
    val bmi: Float
)
