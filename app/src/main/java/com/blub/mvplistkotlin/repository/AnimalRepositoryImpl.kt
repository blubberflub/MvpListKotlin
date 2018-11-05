package com.blub.mvplistkotlin.repository

import com.blub.mvplistkotlin.model.AnimalResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimalRepositoryImpl : AnimalRepository {

    override fun fetchAnimalList(callback: AnimalRepository.Callback) {
        AnimalApiService.create().getAnimals().enqueue(object: Callback<AnimalResponse> {

            override fun onResponse(call: Call<AnimalResponse>,
                                    response: Response<AnimalResponse>) {
                callback.onSuccess(response.body()!!.animalList)
            }

            override fun onFailure(call: Call<AnimalResponse>, t: Throwable) {
                callback.onError(IllegalStateException(t.message))
            }
        })
    }
}