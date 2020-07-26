package com.kinderpass.network

import com.georgegtony.tunatheatre.constants.AppConstants
import com.georgegtony.tunatheatre.mvp.model.HomePageList
import com.georgegtony.tunatheatre.mvp.model.LoginResponseModel
import com.georgegtony.tunatheatre.mvp.model.MovieListResponseModel
import io.reactivex.Single
import retrofit2.http.*

interface APIService {

    @POST(AppConstants.Network.LOGIN_URL)
    fun doLogin(
        @Query("login_type") loginType: String,
        @Query("device_type") deviceType: String,
        @Query("device_id") deviceId: String
    ): Single<LoginResponseModel>

@POST(AppConstants.Network.HOME_PAGE_BANNER)
    fun getHomePageList(
        @Query("user_id") userId: Int,
        @Query("device_id") deviceId: String,
        @Query("cinema_id") cinemaId: String
    ): Single<HomePageList>

@POST(AppConstants.Network.GET_MOVIE_LIST)
    fun getMovieList(
        @Query("user_id") userId: Int,
        @Query("device_id") deviceId: String,
        @Query("cinema_id") cinemaId: String
    ): Single<MovieListResponseModel>


}