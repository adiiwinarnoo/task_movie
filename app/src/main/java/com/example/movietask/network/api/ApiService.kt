package com.example.movietask.network.api

import com.example.movietask.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("/3/discover/movie")
    fun getDiscoverMovie(
        @Query("api_key") apiKey : String,
        @Query("with_genres") genreId : Int? = null
    ) : retrofit2.Call<ResponseDiscoverMovie>

    @GET("/3/movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId : Int,
        @Query("api_key") apiKey : String,
    ) : retrofit2.Call<ResponseMovieById>

    @GET("/3/movie/{movie_id}/reviews")
    fun getReviewById(
        @Path("movie_id") movieId : Int,
        @Query("api_key") apiKey : String,
    ) : retrofit2.Call<ResponseReviews>

}