package com.example.android_kotlin_learning.BreakingBadApi.DB

import androidx.room.TypeConverter

object AppTypeConverters {

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