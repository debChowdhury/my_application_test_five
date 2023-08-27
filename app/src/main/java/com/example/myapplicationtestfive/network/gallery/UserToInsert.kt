package com.example.myapplicationtestfive.network.gallery

import com.squareup.moshi.Json

data class UserToInsertResponse(
    @Json(name = "name") val name: String,
    @Json(name = "job") val job: String,
    @Json(name = "id") val id: String,
    @Json(name = "createdAt") val createdAt: String
)

data class UserToInsert(
    @Json(name = "name") val userName: String,
    @Json(name = "job") val userJob: String
)