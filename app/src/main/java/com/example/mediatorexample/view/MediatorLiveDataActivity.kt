package com.example.mediatorexample.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediatorexample.R
import com.example.mediatorexample.adapter.AnimalAdapter
import com.example.mediatorexample.viewModel.AnimalsViewModel
import kotlinx.android.synthetic.main.activity_mediator_live_data.*

class MediatorLiveDataActivity : AppCompatActivity() {

    private val animalsViewModel by lazy {
        ViewModelProvider(
            this,
            AnimalsViewModel.AnimalsViewModelFactory(this.application)
        )[AnimalsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mediator_live_data)

        val animalApdapter = AnimalAdapter()

        rv_animals.apply {
            adapter = animalApdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MediatorLiveDataActivity)
        }

        animalsViewModel.getAnimalsMediatorLiveData().observe(this) {
            animalApdapter.setNote(it)
        }

        btn_asc.setOnClickListener {
            animalsViewModel.setValueAnimalsMediatorLiveData("ASC")
        }

        btn_desc.setOnClickListener {
            animalsViewModel.setValueAnimalsMediatorLiveData("DESC")
        }

        fab_add_animals.setOnClickListener {
            val intent = Intent(this, AddAnimalsActivity::class.java)
            startActivity(intent)
        }

    }
}