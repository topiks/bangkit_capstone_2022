package com.tahufikprojects.richest.main

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tahufikprojects.richest.R

class listDataAdapter(private val thingsToDo: ArrayList<ThingsToDo>): RecyclerView.Adapter<listDataAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (day, value, im_photo) = thingsToDo[position]
        holder.imPhoto.setImageResource(im_photo)
        holder.tvDay.text = day
        holder.tvValue.text = value

    }

    override fun getItemCount(): Int = thingsToDo.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvDay: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvValue: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}