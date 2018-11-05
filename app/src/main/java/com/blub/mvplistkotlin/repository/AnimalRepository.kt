package com.blub.mvplistkotlin.repository

import com.blub.mvplistkotlin.model.Animal

interface AnimalRepository {
    fun fetchAnimalList(callback: Callback)

    interface Callback {
        fun onSuccess(animalList: List<Animal>)

        fun onError(exception: Exception)
    }
}
