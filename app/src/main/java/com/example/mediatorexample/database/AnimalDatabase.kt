package com.example.mediatorexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mediatorexample.database.dao.AnimalsDAO
import com.example.mediatorexample.model.Animals

@Database(entities = [Animals::class], version = 1)
abstract class AnimalDatabase : RoomDatabase() {

    abstract fun getAnimalDao(): AnimalsDAO

    companion object {
        @Volatile
        private var instance: AnimalDatabase? = null

        fun getInstance(context: Context): AnimalDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, AnimalDatabase::class.java, "AnimalsDataBase")
                        .build()
            }
            return instance!!
        }
    }

}