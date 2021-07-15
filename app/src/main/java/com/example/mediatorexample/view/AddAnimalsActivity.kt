package com.example.mediatorexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mediatorexample.R
import com.example.mediatorexample.model.Animals
import com.example.mediatorexample.viewModel.AnimalsViewModel
import kotlinx.android.synthetic.main.activity_add_animals.*

class AddAnimalsActivity : AppCompatActivity() {

    private val animalsViewModel by lazy {
        ViewModelProvider(
            this,
            AnimalsViewModel.AnimalsViewModelFactory(this.application)
        )[AnimalsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_animals)

        btn_save.setOnClickListener {
            animalsViewModel.insertNote(Animals(edt_Name.text.toString().trim()))
            finish()
        }

    }
}