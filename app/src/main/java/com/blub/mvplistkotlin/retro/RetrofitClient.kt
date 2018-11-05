package com.blub.mvplistkotlin.retro

import com.blub.mvplistkotlin.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://73d67115-309d-4ee6-9e25-f40b6c691e2b.mock.pstmn.io"

object RetrofitClient {

    fun getInstance(): Retrofit {
        val interceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(
                        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
                .baseUrl(BASE_URL)
                .build()
    }
}