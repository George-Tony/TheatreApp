package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName

data class Value (

	@SerializedName("ScreenAttributes") val screenAttributes : List<String>,
	@SerializedName("ConceptAttributes") val conceptAttributes : List<String>,
	@SerializedName("ID") val iD : String,
	@SerializedName("Name") val name : String,
	@SerializedName("PhoneNumber") val phoneNumber : String,
	@SerializedName("EmailAddress") val emailAddress : String,
	@SerializedName("Address1") val address1 : String,
	@SerializedName("Address2") val address2 : String,
	@SerializedName("City") val city : String,
	@SerializedName("Latitude") val latitude : Double,
	@SerializedName("Longitude") val longitude : Double,
	@SerializedName("ParkingInfo") val parkingInfo : String,
	@SerializedName("Description") val description : String,
	@SerializedName("PublicTransport") val publicTransport : String,
	@SerializedName("image_url") val image_url : String,
	@SerializedName("datetime") val datetime : String
)