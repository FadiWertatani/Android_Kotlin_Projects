package com.example.android_kotlin_learning.BreakingBadApi.repository

import androidx.lifecycle.LiveData
import com.example.android_kotlin_learning.BreakingBadApi.DB.CharacterDAO
import com.example.android_kotlin_learning.BreakingBadApi.model.BreakingBadCharacter
import com.example.android_kotlin_learning.BreakingBadApi.services.BreakingBadNetwork

class BreakingBadRepository(private val characterDAO: CharacterDAO) {

    //GETTING LIST FROM LOCAL DB
    var characterList: LiveData<List<BreakingBadCharacter>> = characterDAO.findAllCharacters()

    suspend fun refreshCharacter(){
        // Getting the list from API
        val characterList = BreakingBadNetwork.serviceApi.getCharacters()

        //SAVE TO THE LOCAL DATABASE
        characterDAO.insertAllCharacters(characterList)
    }

}