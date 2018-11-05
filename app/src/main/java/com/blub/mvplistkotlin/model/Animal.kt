package com.blub.mvplistkotlin.model

import com.squareup.moshi.Json

data class Animal(
        @Json(name = "name")
        val name: String,
        @Json(name = "sound")
        val sound: String
)