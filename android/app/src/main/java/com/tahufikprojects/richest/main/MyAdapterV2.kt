package com.tahufikprojects.richest.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tahufikprojects.richest.R
import com.tahufikprojects.richest.main.MyAdapterV2.MyViewHolder
import com.tahufikprojects.richest.utils.Preferences

class MyAdapterV2(var context: Context, var list: ArrayList<SawahModelV2>) :
    RecyclerView.Adapter<MyViewHolder>() {
    var preferences: Preferences? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.list_sawah_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sawahModel = list[position]
        holder.btnSawah.text = sawahModel.getNamaSawah()
        holder.tanggalMulai2.text = sawahModel.getTanggalMulaiSawah()
        preferences = Preferences(context)
        val pos: String
        pos = position.toString()
        holder.btnSawah.setOnClickListener {
            preferences!!.setValues("nama_sawah_sekarang", sawahModel.getNamaSawah())
            //                Log.d("inf", preferences.getValues("nama_sawah_sekarang"));
            startActivity(context)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var namaSawah: TextView? = null
        var tanggalMulai: TextView? = null
        var tanggalMulai2: TextView
        var btnSawah: Button

        init {
            btnSawah = itemView.findViewById(R.id.btn_list_sawah)
            tanggalMulai2 = itemView.findViewById(R.id.text_mulai_2)
        }
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, HalamanUtamaActivity::class.java))
        }
    }
}