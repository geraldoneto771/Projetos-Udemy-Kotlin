package com.example.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tasks.service.listener.ValidationListener
import com.example.tasks.service.models.PriorityModel
import com.example.tasks.service.models.TaskModel
import com.example.tasks.service.repository.PriorityRepository

class TaskFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mPriorityRepository = PriorityRepository(application)

    private val mPriorityList = MutableLiveData<List<PriorityModel>>()
    var priorities: LiveData<List<PriorityModel>> = mPriorityList

    fun listPriorities(){
        mPriorityList.value = mPriorityRepository.list()
    }

    fun save(task: TaskModel){

    }

}