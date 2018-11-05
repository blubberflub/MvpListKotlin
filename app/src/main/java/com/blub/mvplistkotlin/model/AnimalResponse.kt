package com.blub.mvplistkotlin.model

import com.squareup.moshi.Json

data class AnimalResponse(
        @Json(name = "animal_list")
        val animalList: List<Animal>
)