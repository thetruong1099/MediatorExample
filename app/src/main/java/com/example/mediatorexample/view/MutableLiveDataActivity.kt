package com.example.mediatorexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediatorexample.R
import com.example.mediatorexample.adapter.AnimalAdapter
import com.example.mediatorexample.viewModel.AnimalsViewModel
import kotlinx.android.synthetic.main.activity_mutable_live_data.*

class MutableLiveDataActivity : AppCompatActivity() {

    private val animalsViewModel by lazy {
        ViewModelProvider(
            this,
            AnimalsViewModel.AnimalsViewModelFactory(this.application)
        )[AnimalsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mutable_live_data)

        val animalApdapter = AnimalAdapter()
        rv_animals.apply {
            adapter = animalApdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MutableLiveDataActivity)
        }

        animalsViewModel.getAllAnimal().observe(this) {
            animalApdapter.setNote(it)
        }

        fab_add_animals.setOnClickListener {
            val intent = Intent(this, AddAnimalsActivity::class.java)
            startActivity(intent)
        }
    }
}