package com.tahufikprojects.richest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById(R.id.button_daftar) as Button
        btn.setOnClickListener{
            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.setValue("Hello, Pik!")
        }
    }
}