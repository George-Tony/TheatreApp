package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName

data class User (

	@SerializedName("username") val username : String,
	@SerializedName("role") val role : String,
	@SerializedName("updated_at") val updated_at : String,
	@SerializedName("created_at") val created_at : String,
	@SerializedName("id") val id : Int,
	@SerializedName("access_token") val access_token : Int
)