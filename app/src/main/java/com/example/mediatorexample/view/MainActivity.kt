package com.example.mediatorexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediatorexample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMutableLiveData.setOnClickListener {
            val intent = Intent(this, MutableLiveDataActivity::class.java)
            startActivity(intent)
        }

        btnMediatorLiveData.setOnClickListener {
            val intent = Intent(this, MediatorLiveDataActivity::class.java)
            startActivity(intent)
        }
    }
}