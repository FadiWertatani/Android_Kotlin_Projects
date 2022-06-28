package com.example.android_kotlin_learning.PostsApiApp.services

import com.example.android_kotlin_learning.BreakingBadApi.services.BreakingBadService
import com.example.android_kotlin_learning.PostsApiApp.model.PostModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com"
interface PostServices {

    @GET("/posts")
    suspend fun getPosts() : List<PostModel>
}
object PostNetwork{
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val serviceApi = retrofit.create(PostServices::class.java)

}