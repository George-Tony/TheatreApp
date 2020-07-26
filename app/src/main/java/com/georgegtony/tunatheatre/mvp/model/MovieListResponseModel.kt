package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName


data class MovieListResponseModel (

	@SerializedName("response") val response : String,
	@SerializedName("movie_list") val movie_list : List<Movie_list>,
	@SerializedName("movie_image_start") val movie_image_start : String,
	@SerializedName("movie_image_ends") val movie_image_ends : String
)