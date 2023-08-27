package com.example.myapplicationtestfive.network.gallery

import com.squareup.moshi.Json

data class Users(
    val id: String,
    @Json(name = "first_name") val fName: String,
    @Json(name = "last_name") val lName: String
)