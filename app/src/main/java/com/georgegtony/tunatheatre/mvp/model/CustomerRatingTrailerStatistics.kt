package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName

data class CustomerRatingTrailerStatistics (

	@SerializedName("RatingCount") val ratingCount : Int,
	@SerializedName("RatingCountLiked") val ratingCountLiked : Int
)