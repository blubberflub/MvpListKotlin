package com.blub.mvplistkotlin

import com.blub.mvplistkotlin.model.Animal

interface AnimalContract {

    interface View {
        fun showAnimalList(responseList: List<Animal>)
        fun showMessage(message: String)
    }

    interface UserActionListener {
        fun start()
        fun clickedItem(animal: Animal)
    }
}