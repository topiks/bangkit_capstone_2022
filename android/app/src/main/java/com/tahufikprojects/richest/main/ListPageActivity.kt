package com.tahufikprojects.richest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tahufikprojects.richest.R

class ListPageActivity : AppCompatActivity() {
    private lateinit var rvList: RecyclerView
    private val list = ArrayList<ThingsToDo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_page2)

        rvList = findViewById(R.id.rv_list)
        rvList.setHasFixedSize(true)

        list.addAll(ListData)
        showRecyclerList()
    }

    private val ListData : ArrayList<ThingsToDo>
    get(){
        val dataDay = resources.getStringArray(R.array.data_day)
        val dataValues = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listDataa = ArrayList<ThingsToDo>()
        for(i in dataDay.indices) {
            val vList = ThingsToDo(dataDay[i],dataValues[i],dataPhoto.getResourceId(i, -1))
            listDataa.add(vList)
        }
        return listDataa
    }



    private fun showRecyclerList() {
        rvList.layoutManager = LinearLayoutManager(this)
        val ListDataAdapter = listDataAdapter(list)
        rvList.adapter = ListDataAdapter
    }


}
