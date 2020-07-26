package com.georgegtony.tunatheatre.constants

class AppConstants {

    object Network{

       const val BASE_URL = "https://devemagine3.thetunagroup.com/api/"
       const val LOGIN_URL = "login/user"
       const val HOME_PAGE_BANNER = "getHomePageList"
       const val GET_MOVIE_LIST = "getMovieListAll"
        const val REQUEST_TIMEOUT = 60L

    }

    object Prefs{

        var DEVICE_ID: String?="deviceId"
        var USER_ID: String? = "userID"
        val PREFS_NAME: String? = "TunaApp"
    }

}