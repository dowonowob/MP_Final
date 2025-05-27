package com.example.fitnessapp.ui.profile

import android.app.Application
import androidx.lifecycle.*
import com.example.fitnessapp.data.database.AppDatabase
import com.example.fitnessapp.data.model.UserProfile
import com.example.fitnessapp.data.repository.ProfileRepository
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ProfileRepository
    private val _profile = MutableLiveData<UserProfile?>()
    val profile: LiveData<UserProfile?> = _profile

    init {
        val db = AppDatabase.getDatabase(application)
        repository = ProfileRepository(db.userDao())
        viewModelScope.launch {
            _profile.value = repository.getProfile()
        }
    }

    fun saveProfile(user: UserProfile) {
        viewModelScope.launch {
            repository.saveProfile(user)
            _profile.value = user
        }
    }
}
