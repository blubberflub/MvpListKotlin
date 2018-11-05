package com.blub.mvplistkotlin

import com.blub.mvplistkotlin.model.Animal
import com.blub.mvplistkotlin.repository.AnimalRepository

class AnimalPresenter(private val view: AnimalContract.View,
                      private val repository: AnimalRepository)
    : AnimalContract.UserActionListener {

    override fun start() {
        repository.fetchAnimalList(object : AnimalRepository.Callback {
            override fun onSuccess(animalList: List<Animal>) {
                view.showAnimalList(animalList)
            }

            override fun onError(exception: Exception) {
                view.showToast(exception.message)
            }
        })
    }
}