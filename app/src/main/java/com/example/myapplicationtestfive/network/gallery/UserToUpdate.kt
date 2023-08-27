package com.example.myapplicationtestfive.network.gallery

import com.squareup.moshi.Json

data class UserToUpdateResponse(
    @Json(name = "name") val name: String,
    @Json(name = "job") val job: String,
    @Json(name = "updatedAt") val updatedAt: String
)

data class UserToUpdate(
    @Json(name = "name") val userName: String,
    @Json(name = "job") val userJob: String
)