package com.tahufikprojects.richest.opening

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.tahufikprojects.richest.R
import com.tahufikprojects.richest.account.SignInActivity
import com.tahufikprojects.richest.account.SignUpActivity
import com.tahufikprojects.richest.main.PilihSawahActivity
import com.tahufikprojects.richest.main.PilihSawahJavaActivity
import com.tahufikprojects.richest.utils.Preferences

class OnBoardingActivity : AppCompatActivity() {
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        preferences = Preferences(this)
        if(preferences.getValues("onboarding").equals("1"))
        {
            finishAffinity()

//            var goHome = Intent(this@OnBoardingActivity, PilihSawahActivity::class.java)
            var goHome = Intent(this@OnBoardingActivity, PilihSawahJavaActivity::class.java)
            startActivity(goHome)
        }

        var btn_masuk = findViewById(R.id.btn_masuk) as Button
        var btn_daftar = findViewById(R.id.btn_daftar) as Button

        btn_masuk.setOnClickListener {
            preferences.setValues("onboarding", "1")
            finishAffinity()

            var intent = Intent(this@OnBoardingActivity, SignInActivity::class.java)
            startActivity(intent)
        }

        btn_daftar.setOnClickListener {
            preferences.setValues("onboarding", "1")
            finishAffinity()

            var intent = Intent(this@OnBoardingActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}