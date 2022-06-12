package com.tahufikprojects.richest.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import com.tahufikprojects.richest.R
import com.tahufikprojects.richest.account.SignInActivity
import com.tahufikprojects.richest.opening.OnBoardingActivity
import com.tahufikprojects.richest.utils.Preferences

class PilihSawahV2Activity : AppCompatActivity() {

    lateinit var preferences: Preferences

    lateinit var recyclerView: RecyclerView
    var databaseReference: DatabaseReference? = null
    lateinit var myAdapter: MyAdapterV2
    lateinit var list: ArrayList<SawahModelV2>

    lateinit var btn_logout: Button
    lateinit var tambah_data: FloatingActionButton
    lateinit var nama_user: TextView
    lateinit var jumlah_data:TextView



    var jumlahDataSawah = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_sawah_java)

        preferences = Preferences(this)
        recyclerView = findViewById(R.id.coba_list)
        databaseReference = FirebaseDatabase.getInstance().getReference("Sawah")
            .child(preferences.getValues("username")!!)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this))

        list = java.util.ArrayList()
        myAdapter = MyAdapterV2(this, list)

        recyclerView.setAdapter(myAdapter)

        btn_logout = findViewById(R.id.titik_tiga_btn)
        nama_user = findViewById(R.id.name_user_general)
        jumlah_data = findViewById(R.id.belum_ada_data)

        if (preferences.getValues("username") == "") {
            finishAffinity()
            val intent = Intent(this, OnBoardingActivity::class.java)
            startActivity(intent)
        } else nama_user.setText(preferences.getValues("nama"))

        tambah_data = findViewById(R.id.fab_btn_tambah)
        tambah_data.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@PilihSawahV2Activity,
                    TambahSawahActivity::class.java
                )
            )
        })

        btn_logout.setOnClickListener(View.OnClickListener {
            val popupMenu = PopupMenu(applicationContext, btn_logout)
            popupMenu.menuInflater.inflate(R.menu.popup_logout, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_logout -> {
                        preferences.setValues("onboarding", "0")
                        preferences.setValues("status", "0")
                        preferences.setValues("nama", "")
                        preferences.setValues("email", "")
                        preferences.setValues("username", "")
                        preferences.setValues("nama_sawah_sekarang", "")
                        finishAffinity()

                        var goHome = Intent(this@PilihSawahV2Activity, SignInActivity::class.java)
                        startActivity(goHome)
//                        return@OnMenuItemClickListener true
                    }
                }
                false
            })
            popupMenu.show()
        })


        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    val sawahModel = dataSnapshot.getValue(SawahModelV2::class.java)
                    list!!.add(sawahModel!!)
                    jumlahDataSawah = list!!.size
                    jumlah_data.setVisibility(View.INVISIBLE)
                }
                myAdapter!!.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

}