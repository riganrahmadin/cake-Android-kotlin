package com.example.cakee

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeadAdapter: RecyclerView.Adapter<HeadAdapter.MenuViewHolder>() {

    val data = listOf("Kue ", "Puding", "cccc", "dddd", "eeee", "ffff", "gggg", "hhhh")


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardview_head, parent, false)


        return MenuViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        holder.textHead.text = data[position]

    }

    inner class MenuViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textHead: TextView

        init {
            textHead = v.findViewById(R.id.textDescMenu)
        }


    }
}