package com.example.android_kotlin_learning.BreakingBadApi.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_kotlin_learning.BreakingBadApi.model.BreakingBadCharacter

@Dao
interface CharacterDAO {

    @Query("SELECT * FROM character")
    fun findAllCharacters(): LiveData<List<BreakingBadCharacter>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCharacters(characterList : List<BreakingBadCharacter>)

}