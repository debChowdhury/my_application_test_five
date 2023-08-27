package com.example.myapplicationtestfive.network.gallery

import com.squareup.moshi.Json

data class Data(
    @Json(name = "data") val userToInser: UserToInsert
)