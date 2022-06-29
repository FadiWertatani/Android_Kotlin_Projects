package com.example.android_kotlin_learning.PostsApiApp.DB

import androidx.room.TypeConverter

object PostAppTypeConverter {

    @TypeConverter
    fun arrayStringToString(value: Array<String>) : String{
        return value.joinToString(" ")
    }

    @TypeConverter
    @JvmStatic
    fun stringToArrayString(value: String):Array<String>{
        return value.split(" ").toTypedArray()
    }

}