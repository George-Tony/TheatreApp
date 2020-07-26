package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName

data class Movie_show_times (

	@SerializedName("prefix") val prefix : String,
	@SerializedName("movie") val movie : String
//	@SerializedName("show_times") val show_times : List<String>
)