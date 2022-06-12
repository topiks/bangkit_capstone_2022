package com.tahufikprojects.richest.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import com.tahufikprojects.richest.R
import com.tahufikprojects.richest.utils.Preferences
import kotlinx.android.synthetic.main.activity_report.*

class ReportActivity : AppCompatActivity() {

    // input user
    lateinit var inputMasalah: String
    lateinit var inputKapanMasalah: String
    lateinit var inputLevelMasalah: String

    // firebase
    lateinit var mDatabaseReference: DatabaseReference
    lateinit var mFirebaseDatabase: FirebaseDatabase
    lateinit var mDatabase: DatabaseReference

    // data user
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        mFirebaseDatabase = FirebaseDatabase.getInstance()
        mDatabase = mFirebaseDatabase.getReference()
        mDatabaseReference = mFirebaseDatabase.getReference("Report")

        preferences = Preferences(this)

        btn_submit_report.setOnClickListener {

            inputMasalah = editMasalah.text.toString()
            inputKapanMasalah = editHariMasalah.text.toString()
            inputLevelMasalah = editLevelMasalah.text.toString()

            if(inputMasalah.equals(""))
            {
                editMasalah.error = "Silahkan tulis permasalahan pada sawah anda"
                editMasalah.requestFocus()
            }
            else if(inputKapanMasalah.equals("") || inputKapanMasalah.equals("hh-mm-yy") )
            {
                editHariMasalah.error = "Silahkan tulis kapan masalah anda terjadi"
                editHariMasalah.requestFocus()
            }
            else if(inputLevelMasalah.equals(""))
            {
                editLevelMasalah.error = "Silahkan level kerusakan yang menggambarkan masalah anda"
                editLevelMasalah.requestFocus()
            }
            else
            {
                simpanData(inputMasalah, inputKapanMasalah, inputLevelMasalah)
            }
        }
    }

    private fun simpanData(_masalah:String, _waktu:String, _level:String)
    {
        var dataReport = ReportModel()
        dataReport.masalah = _masalah
        dataReport.waktu = _waktu
        dataReport.level = _level

        pushToDB(dataReport)
    }

    private fun pushToDB(_dataReport:ReportModel)
    {
        var username = preferences.getValues("username")!!
        var namaSawah = preferences.getValues("nama_sawah_sekarang")!!
        var waktu = _dataReport.waktu!!

        mDatabaseReference.child(username).child(namaSawah).child(waktu).addValueEventListener(object:
            ValueEventListener
        {
            override fun onCancelled(databaseError: DatabaseError)
            {
                Toast.makeText(this@ReportActivity, "database error", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                var dataReport = dataSnapshot.getValue(ReportModel::class.java)
                if(dataReport == null)
                {
                    mDatabaseReference.child(username).child(namaSawah).child(waktu).setValue(_dataReport)

                    var intent = Intent(this@ReportActivity, HalamanUtamaActivity::class.java)
                    startActivity(intent)

                    finishAffinity()
                }
                else
                {
                    Toast.makeText(this@ReportActivity, "Laporan sudah disimpan", Toast.LENGTH_LONG).show()
                }
            }
        })

    }
}