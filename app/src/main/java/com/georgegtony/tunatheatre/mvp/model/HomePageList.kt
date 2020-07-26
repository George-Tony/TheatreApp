package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName

data class HomePageList (

	@SerializedName("cinema_list_all") val cinema_list_all : Cinema_list_all,
	@SerializedName("cinema_id") val cinema_id : String,
	@SerializedName("sliders") val sliders : List<Sliders>,
	@SerializedName("popular_movies") val popular_movies : List<String>,
	@SerializedName("movie_image_start") val movie_image_start : String,
	@SerializedName("movie_image_ends") val movie_image_ends : String,
	@SerializedName("response") val response : String
)