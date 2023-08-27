package com.example.myapplicationtestfive.network.gallery

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


private const val BASE_URL =
    "https://reqres.in/api/"

/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * The Retrofit object with the Moshi converter.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface UsersApiService {

    @GET("users")
    suspend fun getUsers() : UsersInfo

    @GET("users/{id}")
    suspend fun getSingleUser(@Path("id") userId:String) : SingleUserInfo

    @POST("users")
    suspend fun createUser(@Body user: UserToInsert): UserToInsertResponse

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") userId: String, @Body user: UserToUpdate): UserToUpdateResponse

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") userId: String): String?
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object UsersApi {
    val retrofitService: UsersApiService by lazy { retrofit.create(UsersApiService::class.java) }
}