package com.example.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.repository.local.SecurityPreferences

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mSharedPreferences = SecurityPreferences(application)

    private val mLogout = MutableLiveData<Boolean>()
    val logout: LiveData<Boolean> = mLogout

    private val mUserName = MutableLiveData<String>()
    val userName: LiveData<String> = mUserName

    fun logout() {
        mSharedPreferences.remove(TaskConstants.SHARED.PERSON_KEY)
        mSharedPreferences.remove(TaskConstants.SHARED.TOKEN_KEY)
        mSharedPreferences.remove(TaskConstants.SHARED.PERSON_NAME)
        mLogout.value = true
    }

    fun loadUserName() {
        mUserName.value = mSharedPreferences.get(TaskConstants.SHARED.PERSON_NAME)
    }
}