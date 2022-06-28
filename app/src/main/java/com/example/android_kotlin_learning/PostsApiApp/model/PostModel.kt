package com.example.android_kotlin_learning.PostsApiApp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Post")
data class PostModel(
    @PrimaryKey
    @SerializedName("char_id")
    val id: Int,
    val title: String,
    val body: String,
) {
}