package com.blub.mvplistkotlin.repository

import com.blub.mvplistkotlin.model.AnimalResponse
import com.blub.mvplistkotlin.retro.RetrofitClient
import retrofit2.Call
import retrofit2.http.GET

interface AnimalApiService {

    @GET("animals")
    fun getAnimals(): Call<AnimalResponse>

    companion object {
        fun create(): AnimalApiService {
            return RetrofitClient.getInstance().create(AnimalApiService::class.java)
        }
    }
}