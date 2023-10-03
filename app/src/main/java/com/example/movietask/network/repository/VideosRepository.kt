package com.example.movietask.network.repository

import android.util.Log
import com.example.movietask.data.model.ResponseGenreMovies
import com.example.movietask.data.model.ResponseMoviesVideos
import com.example.movietask.network.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideosRepository {

//    val apiConfig = ApiConfig()
//
//    fun getVideos(apiKey: String, movieId : Int, onResult : (result : ResponseMoviesVideos)-> Unit){
//        apiConfig.server.getVideos(movieId, apiKey).enqueue(object : Callback<ResponseMoviesVideos>{
//            override fun onResponse(call: Call<ResponseMoviesVideos>, response: Response<ResponseMoviesVideos>) {
//                getVideoSuccess(response, onResult)
//            }
//
//            override fun onFailure(call: Call<ResponseMoviesVideos>, t: Throwable) {
//                Log.d("API-VIDEOS", "onFailure: ${t.message}")
//            }
//
//        })
//    }
//
//    fun getVideoSuccess(response : Response<ResponseMoviesVideos>, onResult: (result: ResponseMoviesVideos) -> Unit){
//        when (response.code()){
//            200 -> {
//                onResult(response.body()!!)
//            }
//        }
//    }

}