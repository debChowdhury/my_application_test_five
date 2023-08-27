package com.example.myapplicationtestfive.network.gallery

import com.squareup.moshi.Json

data class SingleUserInfo(
    @Json(name = "data") val user: Users
)