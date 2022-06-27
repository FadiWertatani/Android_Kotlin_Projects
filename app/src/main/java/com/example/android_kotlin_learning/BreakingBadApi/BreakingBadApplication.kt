package com.example.android_kotlin_learning.BreakingBadApi

import android.app.Application
import com.example.android_kotlin_learning.BreakingBadApi.repository.BreakingBadRepository
import com.example.android_kotlin_learning.BreakingBadApi.DB.CharacterDB

class BreakingBadApplication : Application() {

    val database by lazy {
        CharacterDB.createDatabase(this)
    }

    val characterRepository by lazy {
        BreakingBadRepository(database.createCharacterDAO())
    }

}