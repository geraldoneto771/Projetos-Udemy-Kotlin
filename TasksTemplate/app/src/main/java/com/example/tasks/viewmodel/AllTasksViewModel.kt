package com.example.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tasks.service.listener.APIListener
import com.example.tasks.service.models.PriorityModel
import com.example.tasks.service.models.TaskModel
import com.example.tasks.service.repository.TaskRepository

class AllTasksViewModel(application: Application) : AndroidViewModel(application) {

    private val mTaskRepository = TaskRepository(application)

    private val mList = MutableLiveData<List<TaskModel>>()
    var task: LiveData<List<TaskModel>> = mList

    fun list() {
        mTaskRepository.all(object: APIListener<List<TaskModel>>{
            override fun onSucess(model: List<TaskModel>) {
                mList.value = model
            }

            override fun onFailure(string: String) {
                mList.value = arrayListOf()
            }

        })
    }
}