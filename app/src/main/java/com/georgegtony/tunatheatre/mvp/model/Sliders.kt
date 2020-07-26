package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName

data class Sliders (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("movie_id") val movie_id : String,
	@SerializedName("cinema_id") val cinema_id : String,
	@SerializedName("url") val url : String,
	@SerializedName("heading_1") val heading_1 : String,
	@SerializedName("heading_2") val heading_2 : String,
	@SerializedName("description") val description : String,
	@SerializedName("image") val image : String,
	@SerializedName("orderno") val orderno : Int,
	@SerializedName("is_active") val is_active : Int,
	@SerializedName("created_at") val created_at : String,
	@SerializedName("updated_at") val updated_at : String
)