package com.georgegtony.tunatheatre.mvp.model

import com.google.gson.annotations.SerializedName

data class Cinema_list_all (

	@SerializedName("odata.metadata") val odata_metadata : String,
	@SerializedName("value") val value : List<Value>
)