package com.kinderpass.network

import com.georgegtony.tunatheatre.constants.AppConstants
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitHelper() {

    fun getInstance(): APIService {
        return create()
    }


    companion object {
        fun create(): APIService {
            val retrofit =
                Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(
                        GsonConverterFactory.create(
                            GsonBuilder().setLenient().create()
                        )
                    )
                    .baseUrl(AppConstants.Network.BASE_URL)
                    .client(initOkHttp())
                    .build()
            return retrofit.create(APIService::class.java)
        }

        private fun initOkHttp(): OkHttpClient {
            val httpClient = OkHttpClient().newBuilder()
                .connectTimeout(AppConstants.Network.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(AppConstants.Network.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(AppConstants.Network.REQUEST_TIMEOUT, TimeUnit.SECONDS)

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(interceptor)
            return httpClient.build()
        }


    }

}