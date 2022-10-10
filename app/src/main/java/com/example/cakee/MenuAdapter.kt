package com.example.cakee

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ColorSpace.Model
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cakee.R
import com.example.cakee.model.menuModel
import com.google.android.material.shape.MaterialShapeUtils
import org.w3c.dom.Text


class MenuAdapter(private val list: ArrayList<menuModel>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){




    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardview_main, parent, false)

        return MenuViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        holder.bind(list[position])

    }

    inner class MenuViewHolder(v:View):RecyclerView.ViewHolder(v) {
        val textNama:TextView
        val textHarga: TextView
        val imageMenu : ImageView



        init {
            textNama = v.findViewById(R.id.textNamaMenu)
            textHarga = v.findViewById(R.id.textHargaMenu)
            imageMenu = v.findViewById(R.id.imageMenu)

        }
        fun bind(data: menuModel){
            val nama:String = data.name
            val harga:Int = data.price
            val gambar: Bitmap = data.image


            textNama.text = nama
            textHarga.text = harga.toString()
            imageMenu.setImageBitmap(gambar)
        }

    }


}
