package com.example.movietask.network.api

import com.example.movietask.data.model.ResponseGenreMovies
import com.example.movietask.data.model.ResponseGetMoviesNowPlaying
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/now_playing")
    fun getMoviePlaying(
        @Query("api_key") apiKey: String
    ) : retrofit2.Call<ResponseGetMoviesNowPlaying>

    @GET("/3/genre/movie/list")
    fun getGenreMovies(
        @Query("api_key") apiKey : String
    ) : retrofit2.Call<ResponseGenreMovies>

}