package com.example.movietask.network.repository

import android.util.Log
import com.example.movietask.data.model.ResponseDiscoverMovie
import com.example.movietask.data.model.ResponseMovieById
import com.example.movietask.data.model.ResponseReviews
import com.example.movietask.network.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewRepository {

//    val apiConfig = ApiConfig()
//
//    fun getReviews(apiKey: String,movieId : Int? = null, onResult : (result : ResponseReviews)-> Unit){
//        apiConfig.server.getReviewById(movieId!!,apiKey).enqueue(object : Callback<ResponseReviews> {
//            override fun onResponse(call: Call<ResponseReviews>, response: Response<ResponseReviews>) {
//                Log.d("API-REVIEWS", "onFailure: ${response.code()}")
//                if (response.isSuccessful){
//                    getReviewSuccess(response, onResult)
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseReviews>, t: Throwable) {
//                Log.d("API-REVIEWS", "onFailure: ${t.message}")
//            }
//
//        })
//    }
//
//    fun getReviewSuccess(response : Response<ResponseReviews>, onResult:
//        (result: ResponseReviews) -> Unit){
//        when (response.code()){
//            200 -> {
//                onResult(response.body()!!)
//            }
//        }
//    }

}