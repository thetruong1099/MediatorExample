package com.example.mediatorexample.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mediatorexample.database.AnimalDatabase
import com.example.mediatorexample.database.dao.AnimalsDAO
import com.example.mediatorexample.model.Animals

class AnimalsRepository(app: Application) {

    private val animalsDao: AnimalsDAO

    init {
        val animalsDataBase: AnimalDatabase = AnimalDatabase.getInstance(app)
        animalsDao = animalsDataBase.getAnimalDao()
    }

    suspend fun insertAnimal(animals: Animals) = animalsDao.insertAnimal(animals)
    fun getAllAnimal(): LiveData<List<Animals>> = animalsDao.getAllAnimal()
    fun getAllAnimalASC(): LiveData<List<Animals>> = animalsDao.getAllAnimalASC()
    fun getAllAnimalDESC(): LiveData<List<Animals>> = animalsDao.getAllAnimalDESC()
}