package com.tahufikprojects.richest.main

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.firebase.database.*
import com.tahufikprojects.richest.R
import com.tahufikprojects.richest.account.SignInActivity
import com.tahufikprojects.richest.account.User
import com.tahufikprojects.richest.utils.Preferences
import java.util.*

class TambahSawahActivity : AppCompatActivity() {

    lateinit var namaSawah:String
    lateinit var tanggalMulai:String

    lateinit var mDatabaseReference: DatabaseReference
    lateinit var mFirebaseDatabase: FirebaseDatabase
    lateinit var mDatabase: DatabaseReference

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_sawah)

        mFirebaseDatabase = FirebaseDatabase.getInstance()
        mDatabase = mFirebaseDatabase.getReference()
        mDatabaseReference = mFirebaseDatabase.getReference("Sawah")

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DATE)

        var cal_btn = findViewById<Button>(R.id.cal_btn)
        var btn_hari = findViewById<TextView>(R.id.edit_hari)

        cal_btn.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view:DatePicker, mYear:Int, mMonth:Int, mDay->
                btn_hari.setText(""+ mDay + "/" + mMonth + "/" + mYear)
            }, year, month, day)
            dpd.show()
        }

        var simpan = findViewById<Button>(R.id.simpan_sawah_baru)
        var inputNama = findViewById<EditText>(R.id.edit_nama_sawah)
        var inputHari = findViewById<EditText>(R.id.edit_hari)

        simpan.setOnClickListener {
            namaSawah = inputNama.text.toString()
            tanggalMulai = inputHari.text.toString()

            if(inputNama.equals(""))
            {
                inputNama.error = "Silahkan Tulis Nama Sawah Anda"
                inputNama.requestFocus()
            }

            else if(inputHari.equals(""))
            {
                 inputHari.error = "Silahkan Tulis Nama Sawah Anda"
                 inputHari.requestFocus()
            }

            else
            {
                simpanDataBaru(namaSawah, tanggalMulai)
                finish()
            }
        }
    }

    private fun simpanDataBaru(inputNama:String, inputTanggal:String)
    {
        // pecah tanggalan
//        var sliceTanggalan =  inputTanggal.split("/").toTypedArray()
//        for(i in sliceTanggalan)
//            Log.d("tglan", i)

        preferences = Preferences(this)
        mDatabaseReference.child(preferences.getValues("username").toString()).child(inputNama).addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError)
            {
                Toast.makeText(this@TambahSawahActivity, "database error", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                    mDatabaseReference.child(preferences.getValues("username").toString()).child(inputNama).child("mulai").setValue(inputTanggal)

                    var intent = Intent(this@TambahSawahActivity, PilihSawahActivity::class.java)
                    startActivity(intent)

                    finishAffinity()
                }
            }
            )
    }
}