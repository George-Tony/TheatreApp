package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName


data class Movie_list (

	@SerializedName("ID") val iD : String,
	@SerializedName("ScheduledFilmId") val scheduledFilmId : String,
	@SerializedName("CinemaId") val cinemaId : String,
	@SerializedName("HasFutureSessions") val hasFutureSessions : Boolean,
	@SerializedName("Title") val title : String,
	@SerializedName("TitleAlt") val titleAlt : String,
	@SerializedName("Distributor") val distributor : String,
	@SerializedName("Rating") val rating : String,
	@SerializedName("RatingAlt") val ratingAlt : String,
	@SerializedName("RatingDescription") val ratingDescription : String,
	@SerializedName("RatingDescriptionAlt") val ratingDescriptionAlt : String,
	@SerializedName("Synopsis") val synopsis : String,
	@SerializedName("SynopsisAlt") val synopsisAlt : String,
	@SerializedName("OpeningDate") val openingDate : String,
	@SerializedName("FilmHOPK") val filmHOPK : String,
	@SerializedName("FilmHOCode") val filmHOCode : String,
	@SerializedName("ShortCode") val shortCode : String,
	@SerializedName("RunTime") val runTime : Int,
	@SerializedName("TrailerUrl") val trailerUrl : String,
	@SerializedName("DisplaySequence") val displaySequence : Int,
	@SerializedName("TwitterTag") val twitterTag : String,
	@SerializedName("HasSessionsAvailable") val hasSessionsAvailable : Boolean,
	@SerializedName("GraphicUrl") val graphicUrl : String,
	@SerializedName("CinemaName") val cinemaName : String,
	@SerializedName("CinemaNameAlt") val cinemaNameAlt : String,
	@SerializedName("AllowTicketSales") val allowTicketSales : Boolean,
	@SerializedName("AdvertiseAdvanceBookingDate") val advertiseAdvanceBookingDate : Boolean,
	@SerializedName("AdvanceBookingDate") val advanceBookingDate : String,
	@SerializedName("LoyaltyAdvanceBookingDate") val loyaltyAdvanceBookingDate : String,
	@SerializedName("HasDynamicallyPricedTicketsAvailable") val hasDynamicallyPricedTicketsAvailable : Boolean,
	@SerializedName("IsPlayThroughMarketingFilm") val isPlayThroughMarketingFilm : Boolean,
	@SerializedName("CustomerRatingStatistics") val customerRatingStatistics : CustomerRatingStatistics,
	@SerializedName("CustomerRatingTrailerStatistics") val customerRatingTrailerStatistics : CustomerRatingTrailerStatistics,
	@SerializedName("NationalOpeningDate") val nationalOpeningDate : String,
	@SerializedName("CorporateFilmId") val corporateFilmId : String,
	@SerializedName("EDICode") val eDICode : String,
//	@SerializedName("show_times") val show_times : List<String>?,
	@SerializedName("next_show") val next_show : String,
	@SerializedName("next_show_time") val next_show_time : String,
	@SerializedName("OtherMovies") val otherMovies : String
//	@SerializedName("movie_show_times") val movie_show_times : List<Movie_show_times>
)