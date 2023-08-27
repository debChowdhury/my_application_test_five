package com.example.myapplicationtestfive.network.gallery

import com.squareup.moshi.Json

data class UsersInfo(
    @Json(name = "data") val users: List<Users>
)