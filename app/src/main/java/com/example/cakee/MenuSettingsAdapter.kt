package com.example.cakee


import android.graphics.Bitmap
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cakee.model.menuModel
import org.w3c.dom.Text


class MenuSettingsAdapter(private val list: ArrayList<menuModel>) : RecyclerView.Adapter<MenuSettingsAdapter.MenuViewHolder>(){

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardview_menu_settings, parent, false)

        return MenuViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        holder.bind(list[position])

    }

    inner class MenuViewHolder(v:View):RecyclerView.ViewHolder(v) {
        val textId : TextView
        val textNama:TextView
        val textHarga: TextView
        val imageMenu : ImageView


        init {
            textId = v.findViewById(R.id.textIdMakanan)
            textNama = v.findViewById(R.id.textNamaMakanan)
            textHarga = v.findViewById(R.id.textHargaMakanan)
            imageMenu = v.findViewById(R.id.imageMakanan)
        }

        fun bind(data: menuModel){
            val id:Int = data.id
            val nama:String = data.name
            val harga:Int = data.price
            val gambar:Bitmap = data.image

            textId.text = id.toString()
            textNama.text = nama
            textHarga.text = harga.toString()
            imageMenu.setImageBitmap(gambar)
        }
    }


}