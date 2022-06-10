package com.tahufikprojects.richest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tahufikprojects.richest.R

class list_page : AppCompatActivity() {
    private lateinit var rvList: RecyclerView
    private val list = ArrayList<list_data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_page)

        rvList = findViewById(R.id.rv_list)
        rvList.setHasFixedSize(true)

        list.addAll(ListData)
        showRecyclerList()

    }



    private val ListData: ArrayList<list_data>
    get(){
        val dataDay = resources.getStringArray(R.array.data_day)
        val dataValues = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listDataa = ArrayList<list_data>()
        for(i in dataDay.indices){
            val vList = list_data(dataDay[i],dataValues[i],dataPhoto.getResourceId(i, -1))
            listDataa.add(vList)
        }
        return ListData
    }

    private fun showRecyclerList() {
        rvList.layoutManager = LinearLayoutManager(this)
        val list_DataAdapter = listDataAdapter(list)
        rvList.adapter = list_DataAdapter
    }
}
