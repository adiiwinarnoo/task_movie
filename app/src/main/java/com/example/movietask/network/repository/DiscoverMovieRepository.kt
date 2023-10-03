package com.example.movietask.network.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movietask.data.model.ResponseDiscoverMovie
import com.example.movietask.data.model.ResponseGenreMovies
import com.example.movietask.network.api.ApiConfig
import com.example.movietask.network.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class DiscoverMovieRepository @Inject constructor(private val apiService : ApiService){

    fun getDiscoverMovie(apiKey: String, genreId: Int? = null): LiveData<Response<ResponseDiscoverMovie>> {
        val liveData = MutableLiveData<Response<ResponseDiscoverMovie>>()
        apiService.getDiscoverMovie(apiKey, genreId).enqueue(object : Callback<ResponseDiscoverMovie> {
            override fun onResponse(call: Call<ResponseDiscoverMovie>, response: Response<ResponseDiscoverMovie>) {
                liveData.postValue(response)
            }
            override fun onFailure(call: Call<ResponseDiscoverMovie>, t: Throwable) {
                // Handle failure
                Log.d("FAILURE", "onFailure: ${t.message}")
            }
        })
        return liveData
    }

    suspend fun getDisMovie(apiKey: String,genreId: Int? = null) : Response<ResponseDiscoverMovie> {
        return withContext(Dispatchers.IO){
            try {
                var response = apiService.getDiscoverMovie(apiKey,genreId).execute()
                Log.d("RESPONSE-CODE", "getDisMovie: ${response.code()}")
                response
            }catch (e : Throwable){
                Log.d("RESPONSE-CODE", "getDisMovie: ${e.message}")
                throw e
            }
        }
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