package com.example.tasks.service.listener

import com.example.tasks.service.models.HeaderModel

interface APIListener<T> {

    fun onSucess(model: T)

    fun onFailure(string: String)
}