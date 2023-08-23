package com.example.movietask.network.repository

import com.example.movietask.data.model.ResponseDiscoverMovie
import com.example.movietask.data.model.ResponseMovieById
import com.example.movietask.network.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieByIdRepository {

    val apiConfig = ApiConfig()

    fun getMovieById(idMovie : Int,apiKey : String, onResult: (result : ResponseMovieById)-> Unit){
        apiConfig.server.getMovieDetails(movieId = idMovie, apiKey =apiKey).enqueue(object : Callback<ResponseMovieById>{
            override fun onResponse(call: Call<ResponseMovieById>, response: Response<ResponseMovieById>) {
                movieByIdSuccess(response, onResult)
            }

            override fun onFailure(call: Call<ResponseMovieById>, t: Throwable) {
                val authError = "Please Check Your Connection"
                val default = ResponseMovieById(message = authError)
                onResult(default)
            }

        })
    }

    fun movieByIdSuccess(response : Response<ResponseMovieById>, onResult:
        (result: ResponseMovieById) -> Unit){
        when (response.code()){
            200 -> {
                onResult(response.body()!!)
            }
        }
    }

}