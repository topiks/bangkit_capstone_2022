package com.tahufikprojects.richest.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import com.tahufikprojects.richest.R
import com.tahufikprojects.richest.main.PilihSawahActivity
import com.tahufikprojects.richest.main.PilihSawahJavaActivity
import com.tahufikprojects.richest.utils.Preferences

class SignInActivity : AppCompatActivity() {

    lateinit var inputUsername:String
    lateinit var inputPass:String

    lateinit var mDatabase : DatabaseReference
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = Preferences(this)

        var edit_username = findViewById(R.id.edit_username_masuk) as EditText
        var edit_pass = findViewById(R.id.edit_pass_masuk) as EditText

        if(preferences.getValues("status").equals("1"))
        {
            finishAffinity()

//            var goHome = Intent(this@SignInActivity, PilihSawahActivity::class.java)
            var goHome = Intent(this@SignInActivity, PilihSawahJavaActivity::class.java)
            goHome.putExtra("USERNAME", preferences.getValues("nama"));
            startActivity(goHome)
        }

        var btn_daftar = findViewById(R.id.atau_daftar_from_masuk) as Button
        var btn_masuk = findViewById(R.id.masuk) as Button

        btn_masuk.setOnClickListener {
            inputUsername = edit_username.text.toString()
            inputPass = edit_pass.text.toString()

            if(inputUsername.equals(""))
            {
                edit_username.error = "Silahkan Tulis Username Anda"
                edit_username.requestFocus()
            }
            else if(inputPass.equals(""))
            {
                edit_pass.error = "Silahkan Tulis Password Anda"
                edit_pass.requestFocus()
            }
            else
            {
                pushLogin(inputUsername, inputPass)
            }
        }

        btn_daftar.setOnClickListener {
            var intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

    }

    private fun pushLogin(inputUsername: String, inputPass: String)
    {
        mDatabase.child(inputUsername).addValueEventListener(object : ValueEventListener
        {
            override fun onCancelled(databaseError: DatabaseError)
            {
                Toast.makeText(this@SignInActivity, "database error", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                var user = dataSnapshot.getValue(User::class.java)
                if(user == null)
                {
                    Toast.makeText(this@SignInActivity, "Username Tidak Ditemukan", Toast.LENGTH_LONG).show()
                }
                else
                {
                    if(user.pass.equals(inputPass))
                    {
                        preferences.setValues("nama", user.nama.toString())
                        preferences.setValues("email", user.email.toString())
                        preferences.setValues("username", user.username.toString())
                        preferences.setValues("status", "1")

                        Toast.makeText(this@SignInActivity, "Berhasil Masuk", Toast.LENGTH_LONG).show()

//                        var intent = Intent(this@SignInActivity, PilihSawahActivity::class.java)
                        var intent = Intent(this@SignInActivity, PilihSawahJavaActivity::class.java)
                        startActivity(intent)
                        finishAffinity()
                    }
                    else
                    {
                        Toast.makeText(this@SignInActivity, "Password Anda Salah", Toast.LENGTH_LONG).show()
                    }
                }

            }
        })
    }
}