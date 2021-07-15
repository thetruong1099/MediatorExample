package com.example.mediatorexample.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.mediatorexample.database.repository.AnimalsRepository
import com.example.mediatorexample.model.Animals
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class AnimalsViewModel(application: Application) : ViewModel() {

    private val animalsRepository: AnimalsRepository = AnimalsRepository(application)
    private val animalsMediatorLiveData = MediatorLiveData<List<Animals>>()
    private val animalsASCLiveData = animalsRepository.getAllAnimalASC()
    private val animalsDESCLiveData = animalsRepository.getAllAnimalDESC()
    private var currentOrder = "ASC"

    init {
        setAnimalsMediatorLiveData()
    }

    private fun setAnimalsMediatorLiveData() {
        animalsMediatorLiveData.addSource(animalsASCLiveData) {
            if (currentOrder == "ASC") animalsMediatorLiveData.value = it
        }

        animalsMediatorLiveData.addSource(animalsDESCLiveData) {
            if (currentOrder == "DESC") {
                animalsMediatorLiveData.value = it
            }
        }
    }

    fun insertNote(animal: Animals) = viewModelScope.launch {
        animalsRepository.insertAnimal(animal)
    }

    fun getAllAnimal(): LiveData<List<Animals>> = animalsRepository.getAllAnimal()

    fun getAnimalsMediatorLiveData(): MediatorLiveData<List<Animals>> = animalsMediatorLiveData

    fun setValueAnimalsMediatorLiveData(order: String) = when (order) {
        "ASC" -> animalsASCLiveData.value?.let { animalsMediatorLiveData.value = it }
        "DESC" -> animalsDESCLiveData.value?.let { animalsMediatorLiveData.value = it }
        else -> animalsASCLiveData.value?.let { animalsMediatorLiveData.value = it }
    }.also { currentOrder = order }

    class AnimalsViewModelFactory(private val application: Application) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AnimalsViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AnimalsViewModel(application) as T
            }

            throw IllegalArgumentException("unable construct viewModel")
        }

    }
}