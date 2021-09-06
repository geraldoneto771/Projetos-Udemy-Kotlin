package com.example.tasks.service.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.tasks.R
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.APIListener
import com.example.tasks.service.models.PriorityModel
import com.example.tasks.service.repository.local.TaskDatabase
import com.example.tasks.service.repository.remote.PriorityService
import com.example.tasks.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PriorityRepository(val context: Context) : BaseRepository(context){

    private val mRemote = RetrofitClient.createService((PriorityService::class.java))
    private val mPriorityDatabase = TaskDatabase.getDatabase(context).priorityDAO()

    fun all(listener: APIListener<List<PriorityModel>>){

        // Verificação de internet
        if (!isConnectionAvailable(context)) {
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }

        val call: Call<List<PriorityModel>> = mRemote.list()
        call.enqueue(object : Callback<List<PriorityModel>>{
            override fun onFailure(call: Call<List<PriorityModel>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<PriorityModel>>,
                response: Response<List<PriorityModel>>
            ) {
                if (response.code() == TaskConstants.HTTP.SUCCESS){
                    mPriorityDatabase.clear()
                    response.body()?.let {mPriorityDatabase.save(it)}
                }
            }

        })
    }

    fun list() = mPriorityDatabase.list()

    fun getDescription(id: Int) = mPriorityDatabase.getDescription(id)

}