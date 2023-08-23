package com.example.movietask.data.model

import com.google.gson.annotations.SerializedName

data class ResponseGenreMovies(

	@field:SerializedName("genres")
	val genres: List<GenresItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,
)

data class GenresItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
