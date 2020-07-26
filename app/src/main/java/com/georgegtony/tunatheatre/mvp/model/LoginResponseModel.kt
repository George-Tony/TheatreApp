package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName

data class LoginResponseModel (
	@SerializedName("response") val response : String,
	@SerializedName("message") val message : String,
	@SerializedName("user_id") val user_id : Int,
	@SerializedName("user") val user : User,
	@SerializedName("access_token") val access_token : Int
)