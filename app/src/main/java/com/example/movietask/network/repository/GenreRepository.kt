package com.example.movietask.network.repository

import com.example.movietask.data.model.ResponseGenreMovies
import com.example.movietask.network.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenreRepository {


//    fun getGenreMovies(apiKey : String, onResult : (result : ResponseGenreMovies)-> Unit){
//        apiConfig.server.getGenreMovies(apiKey).enqueue(object : Callback<ResponseGenreMovies>{
//            override fun onResponse(
//                call: Call<ResponseGenreMovies>, response: Response<ResponseGenreMovies>) {
//                if (response.isSuccessful){
//                    getGenreSuccess(response, onResult)
//                }else{
//                    val authError = "Invalid API key: You must be granted a valid key."
//                    val default = ResponseGenreMovies(message = authError)
//                    onResult(default)
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseGenreMovies>, t: Throwable) {
//                val authError = "Please Check Your Connection!!"
//                val default = ResponseGenreMovies(message = authError)
//                onResult(default)
//            }
//
//        })
//    }
//
//    fun getGenreSuccess(response : Response<ResponseGenreMovies>,onResult:
//        (result: ResponseGenreMovies) -> Unit){
//        when (response.code()){
//            200 -> {
//                onResult(response.body()!!)
//            }
//            401 -> {
//                val authError = "Invalid API key: You must be granted a valid key."
//                val default = ResponseGenreMovies(message = authError)
//                onResult(default)
//            }
//            404 -> {
//                val authError = "The resource you requested could not be found."
//                val default = ResponseGenreMovies(message = authError)
//                onResult(default)
//            }
//        }
//    }

}