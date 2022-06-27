package com.example.android_kotlin_learning.BreakingBadApi.UI.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.android_kotlin_learning.BreakingBadApi.repository.BreakingBadRepository
import kotlinx.coroutines.launch

class CharacterListVIewModel(private val characterRepository: BreakingBadRepository) : ViewModel() {

    init {
        refreshDataFromRepository()
    }
    //list from local database
    val characterList = characterRepository.characterList

    //calling data from repository
    fun refreshDataFromRepository(){
        viewModelScope.launch {
            characterRepository.refreshCharacter()
        }
    }
}

class CharacterListViewModelFactory(private val characterRepository: BreakingBadRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CharacterListVIewModel(characterRepository) as T
    }
}