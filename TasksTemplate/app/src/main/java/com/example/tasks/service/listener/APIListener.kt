package com.example.tasks.service.listener

import com.example.tasks.service.HeaderModel

interface APIListener {

    fun onSucess(model: HeaderModel)

    fun onFailure(string: String)
}