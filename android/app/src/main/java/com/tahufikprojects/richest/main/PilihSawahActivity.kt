package com.tahufikprojects.richest.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tahufikprojects.richest.R
import com.tahufikprojects.richest.opening.OnBoardingActivity
import com.tahufikprojects.richest.utils.Preferences

class PilihSawahActivity : AppCompatActivity() {

    lateinit var preferences: Preferences
    var mLinearLayoutManager: LinearLayoutManager? = null
    var mRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_sawah)
        preferences = Preferences(this)

        // set user name
        var nama_user_text = findViewById(R.id.nama_user) as TextView
        nama_user_text.setText(preferences.getValues("nama")).toString()

        // popup
        var popUpBtn = findViewById(R.id.pop_up_btn) as Button

        val popupMenu = PopupMenu(
            this, popUpBtn
        )

        popupMenu.menuInflater.inflate(R.menu.popup_logout, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem->
            val id = menuItem.itemId

            if(id == R.id.menu_logout)
            {
                preferences.setValues("onboarding", "")
                preferences.setValues("status", "")
                preferences.setValues("nama", "")
                preferences.setValues("email", "")
                preferences.setValues("username", "")

                finishAffinity()

                var halamanReset = Intent(this@PilihSawahActivity, OnBoardingActivity::class.java)
                startActivity(halamanReset)
            }

            false
        }

        popUpBtn.setOnClickListener {
            popupMenu.show()
        }

        // tambah sawah btn
        var tambah_btn = findViewById<Button>(R.id.tambah_sawah_btn)
        tambah_btn.setOnClickListener {
            var intent = Intent(this@PilihSawahActivity, TambahSawahActivity::class.java)
            startActivity(intent)
        }


    }
}