package com.tahufikprojects.richest.main

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import com.tahufikprojects.richest.R
import com.tahufikprojects.richest.account.SignUpActivity
import com.tahufikprojects.richest.scan.CaptureActivity
import com.tahufikprojects.richest.utils.Preferences
import kotlinx.android.synthetic.main.activity_halaman_utama.*

//var jumlahReport = ArrayList<String> = "0"

var jumlahReport = intArrayOf(0)

class HalamanUtamaActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    // firebase
    lateinit var mDatabaseReference: DatabaseReference
    lateinit var mFirebaseDatabase: FirebaseDatabase
    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_utama)

        mFirebaseDatabase = FirebaseDatabase.getInstance()
        mDatabase = mFirebaseDatabase.getReference()
        mDatabaseReference = mFirebaseDatabase.getReference("Report")

        preferences = Preferences(this)

        var nama_sawah = findViewById(R.id.text_nama_sawah) as TextView
        nama_sawah.setText(preferences.getValues("nama_sawah_sekarang"))

        var btn_scan = findViewById(R.id.menuju_btn_scan) as Button
        btn_scan.setOnClickListener {
            var intent = Intent(this@HalamanUtamaActivity, CaptureActivity::class.java)
            startActivity(intent)
        }

        btn_report.setOnClickListener {
            var intent = Intent(this@HalamanUtamaActivity, ReportActivity::class.java)
            startActivity(intent)
        }

        btn_list.setOnClickListener {
            var pagelist = Intent(this@HalamanUtamaActivity, ListPageActivity::class.java)
            startActivity(pagelist)
        }

        cekLevelReportDB()
    }

    fun asSyncAdapter(uri: Uri, account: String, accountType: String): Uri {
        return uri.buildUpon()
            .appendQueryParameter(CalendarContract.CALLER_IS_SYNCADAPTER, "true")
            .appendQueryParameter(CalendarContract.Calendars.ACCOUNT_NAME, account)
            .appendQueryParameter(CalendarContract.Calendars.ACCOUNT_TYPE, accountType).build()
    }

    private fun addElement(arr: IntArray, element: Int): IntArray {
        val mutableArray = arr.toMutableList()
        mutableArray.add(element)
        return mutableArray.toIntArray()
    }

    private fun cekLevelReportDB()
    {
        var nilai = 100
        var username = preferences.getValues("username")!!
        var sawahSekarang = preferences.getValues("nama_sawah_sekarang")!!

        mDatabaseReference.child(username).child(sawahSekarang)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (snapshot in dataSnapshot.children) {
                        val dataReport = snapshot.getValue(
                            ReportModel::class.java
                        )

//                        Log.d("loop", dataReport!!.waktu.toString())
//                        println(dataReport!!.waktu)
                        mDatabaseReference.child(username).child(sawahSekarang).child(dataReport!!.waktu.toString()).child("level").get().addOnCompleteListener { task ->
                            if (!task.isSuccessful) {
                                Log.e(
                                    "firebase",
                                    "Error getting data",
                                    task.exception
                                )
                            } else {
                                Log.d(
                                    "firebase",
                                    java.lang.String.valueOf(task.result.value)
                                )

                                if(java.lang.String.valueOf(task.result.value) == "1")
                                {
                                    nilai = nilai - 5
                                    Log.d("ifcok",nilai.toString())
                                }

                                else if(java.lang.String.valueOf(task.result.value) == "2")
                                {
                                    nilai = nilai - 7
                                    Log.d("ifcok",nilai.toString())
                                }

                                else if(java.lang.String.valueOf(task.result.value) == "3") {
                                    nilai = nilai - 15
                                    Log.d("ifcok",nilai.toString())
                                }
//                                    nilai = nilai - 5
//                                else if(java.lang.String.valueOf(task.result.value) == 3)
//                                    nilai = nilai - 10
//                                jumlahReport = addElement(jumlahReport, java.lang.String.valueOf(task.result.value).toInt())

//                                Log.d("nilai", nilai.toString())
                            }
//                            Toast.makeText(this@HalamanUtamaActivity, nilai.toString(), Toast.LENGTH_LONG).show()
                            persenan.setText("Keberhasilan panen : " + nilai.toString() + " %")

                        }

                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })


    }
}