package com.tahufikprojects.richest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.tahufikprojects.richest.R
import com.tahufikprojects.richest.utils.Preferences

class HalamanUtamaActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_utama)

        preferences = Preferences(this)

        var nama_sawah = findViewById(R.id.text_nama_sawah) as TextView
        nama_sawah.setText(preferences.getValues("nama_sawah_sekarang"))

//        var btn_scan = findViewById(R.id.btn_scan) as Button
//        btn_scan
    }
}