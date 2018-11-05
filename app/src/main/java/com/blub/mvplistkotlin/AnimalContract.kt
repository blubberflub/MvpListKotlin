package com.blub.mvplistkotlin

import com.blub.mvplistkotlin.model.Animal

interface AnimalContract {

    interface View {
        fun showAnimalList(responseList: List<Animal>)
        fun showToast(message: String?)
    }

    interface UserActionListener {
        fun start()
    }
}