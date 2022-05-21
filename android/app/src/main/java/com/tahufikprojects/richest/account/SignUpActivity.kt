package com.tahufikprojects.richest.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import com.tahufikprojects.richest.R

//import kotlinx.android.synthetic.account.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    // variabel user
    lateinit var inputNama:String
    lateinit var inputEmail:String
    lateinit var inputPass:String
    lateinit var inputUsername:String

    // variabel firebase
    lateinit var mDatabaseReference: DatabaseReference
    lateinit var mFirebaseDatabase: FirebaseDatabase
    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mFirebaseDatabase = FirebaseDatabase.getInstance()
        mDatabase = mFirebaseDatabase.getReference()
        mDatabaseReference = mFirebaseDatabase.getReference("User")

        var btn_daftar = findViewById(R.id.button_daftar) as Button
        var edit_nama = findViewById(R.id.edit_nama) as EditText
        var edit_username = findViewById(R.id.edit_username) as EditText
        var edit_email = findViewById(R.id.edit_email) as EditText
        var edit_pass = findViewById(R.id.edit_pass) as EditText

        // button ke activity masuk
        var btn_masuk = findViewById(R.id.atau_masuk_from_daftar) as Button
        btn_masuk.setOnClickListener {
            var intent = Intent(this@SignUpActivity, SignInActivity::class.java)
            startActivity(intent)
        }

        btn_daftar.setOnClickListener {
            inputNama = edit_nama.text.toString()
            inputUsername = edit_username.text.toString()
            inputEmail = edit_email.text.toString()
            inputPass = edit_pass.text.toString()

            if(inputNama.equals(""))
            {
                edit_nama.error = "Silahkan isi Nama Anda"
                edit_nama.requestFocus()
            }
            else if(inputUsername.equals(""))
            {
                edit_username.error = "Silahkan isi Username Anda"
                edit_username.requestFocus()
            }
            else if(inputEmail.equals(""))
            {
                edit_email.error = "Silahkan isi Email Anda"
                edit_email.requestFocus()
            }
            else if(inputPass.equals(""))
            {
                edit_pass.error = "Silahkan isi Password Anda"
                edit_pass.requestFocus()
            }
            else
            {
                // cek panjang username
                if(inputUsername.length <= 7)
                {
                    edit_username.error = "Silahkan isi Username Anda Minimal 8 karakter"
                    edit_username.requestFocus()
                }

                // cek alamat email
                else if(inputEmail.isNotEmpty())
                {
                    var isEmail = false
                    var sliceEmail = inputEmail.split("").toTypedArray()
                    for(i in sliceEmail){
                        if(i == "@")
                        {
                            isEmail = true
                            break
                        }
                        else
                            isEmail = false
                    }

                    // apabila email valid
                    if(isEmail == true)
                    {
                        // cek jumlah karakter password
                        if(inputPass.length <= 7){
                            edit_pass.error = "Silahkan isi Password Anda Minimal 8 karakter"
                            edit_pass.requestFocus()
                        }
                        else
                        {
                            var slicePass = inputPass.split("").toTypedArray()
                            var jumlahKarakter = 0;
                            var jumlahInt = 0;

                            for(p in slicePass)
                            {
                                if(p.equals("0") || p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") || p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") || p.equals("9"))
                                    jumlahInt += 1
                                if(p.equals("!") || p.equals("@") || p.equals("#") || p.equals("$") || p.equals("%") || p.equals("^") || p.equals("&") || p.equals("*") || p.equals("(") || p.equals(")"))
                                    jumlahKarakter += 1
                            }

                            if(jumlahInt > 0 && jumlahKarakter > 0)
                            {
                                simpanDataBaru(inputNama, inputUsername, inputEmail, inputPass)
                                finish()
                            }
                            else
                            {
                                edit_pass.error = "Silahkan gunakan huruf, angka, dan karakter"
                                edit_pass.requestFocus()
                            }
                        }
                    }
                    else
                    {
                        edit_email.error = "Alamat email tidak valid"
                        edit_email.requestFocus()
                    }
                }
            }
        }
    }

    private fun cekDataPadaDB(_db_username:String, _db_data:User)
    {
        mDatabaseReference.child(_db_username).addValueEventListener(object : ValueEventListener
        {
            override fun onCancelled(databaseError: DatabaseError)
            {
                Toast.makeText(this@SignUpActivity, "database error", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                var user = dataSnapshot.getValue(User::class.java)
                if(user == null)
                {
                    mDatabaseReference.child(inputUsername).setValue(_db_data)

                    var intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                    startActivity(intent)

                    finishAffinity()
                }
                else
                {
                    Toast.makeText(this@SignUpActivity, "Akun sudah dibuat", Toast.LENGTH_LONG).show()
                }
            }
        }
        )
    }

    private fun simpanDataBaru(_nama:String, _username:String, _email:String, _pass:String)
    {
        var user = User()
        user.nama = _nama
        user.username = _username
        user.email = _email
        user.pass = _pass

        cekDataPadaDB(_username, user)
    }
}