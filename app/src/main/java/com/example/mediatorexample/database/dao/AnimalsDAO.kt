package com.example.mediatorexample.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mediatorexample.model.Animals
import kotlinx.coroutines.selects.select

@Dao
interface AnimalsDAO {

    @Insert
    suspend fun insertAnimal(animal: Animals)

    @Query("select * from animals_table")
    fun getAllAnimal(): LiveData<List<Animals>>

    @Query("select * from animals_table order by name_col")
    fun getAllAnimalASC(): LiveData<List<Animals>>

    @Query("select * from animals_table order by name_col desc")
    fun getAllAnimalDESC(): LiveData<List<Animals>>
}