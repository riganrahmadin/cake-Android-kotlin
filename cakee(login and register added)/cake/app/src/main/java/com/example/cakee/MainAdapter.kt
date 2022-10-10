package com.example.cakee

import android.content.Context
import android.graphics.ColorSpace.Model
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cakee.R
import com.google.android.material.shape.MaterialShapeUtils


class MainAdapter : RecyclerView.Adapter<MainAdapter.MenuViewHolder>(){

    val data = listOf("aaa","bbbb","cccc","dddd","eeee","ffff","gggg","hhhh")


    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardview_main, parent, false)

        return MenuViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        holder.textNama.text = data[position]

    }

    inner class MenuViewHolder(v:View):RecyclerView.ViewHolder(v) {
        val textNama:TextView

        init {
            textNama = v.findViewById(R.id.textNamaMenu)
        }
    }


}