package com.example.movietask.network.repository

import android.util.Log
import com.example.movietask.data.model.ResponseDiscoverMovie
import com.example.movietask.data.model.ResponseGenreMovies
import com.example.movietask.network.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiscoverMovieRepository {
    val apiConfig = ApiConfig()

    fun getDiscoverMovie(apiKey: String,genreId : Int? = null, onResult : (result : ResponseDiscoverMovie)-> Unit){
        apiConfig.server.getDiscoverMovie(apiKey = apiKey, genreId = genreId).enqueue(object : Callback<ResponseDiscoverMovie>{
            override fun onResponse(call: Call<ResponseDiscoverMovie>, response: Response<ResponseDiscoverMovie>) {
                if (response.isSuccessful){
                    getDiscoverSuccess(response, onResult)
                }
            }

            override fun onFailure(call: Call<ResponseDiscoverMovie>, t: Throwable) {
                Log.d("API-DISCOVER", "onFailure: ${t.message}")
            }

        })
    }

    fun getDiscoverSuccess(response : Response<ResponseDiscoverMovie>, onResult:
        (result: ResponseDiscoverMovie) -> Unit){
        when (response.code()){
            200 -> {
                onResult(response.body()!!)
            }
            401 -> {
                val authError = "Invalid API key: You must be granted a valid key."
                val default = ResponseDiscoverMovie(message = authError)
                onResult(default)
            }
            404 -> {
                val authError = "The resource you requested could not be found."
                val default = ResponseDiscoverMovie(message = authError)
                onResult(default)
            }
        }
    }

}