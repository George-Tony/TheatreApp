package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName

data class CustomerRatingStatistics (

	@SerializedName("RatingCount") val ratingCount : Int,
	@SerializedName("AverageScore") val averageScore : String
)