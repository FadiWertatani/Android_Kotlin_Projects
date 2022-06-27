package com.example.android_kotlin_learning.BreakingBadApi.services

import com.example.android_kotlin_learning.BreakingBadApi.model.BreakingBadCharacter
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://www.breakingbadapi.com/api"
interface BreakingBadService {

    @GET("/characters")
    suspend fun getCharacters() : List<BreakingBadCharacter>
}
object BreakingBadNetwork{
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val serviceApi = retrofit.create(BreakingBadService::class.java)

}