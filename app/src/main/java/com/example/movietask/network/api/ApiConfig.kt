package com.example.movietask.network.api

import com.example.movietask.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.APP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var server : ApiService = retrofit.create(ApiService::class.java)

}