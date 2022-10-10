package com.example.cakee

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.VectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.cakee.model.menuModel

class AddMenuActivity : AppCompatActivity() {
    lateinit var image: ImageView
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu)

        image = findViewById(R.id.addImageMenu)
        val textId : EditText = findViewById(R.id.editTextidMenu)
        val namaMenu : EditText = findViewById(R.id.editTextNamaMenu)
        val hargaMenu : EditText = findViewById(R.id.editTextHargaMenu)
        val btnAdd : ImageView = findViewById(R.id.addImageMenu)
        val btnSave : Button = findViewById(R.id.buttonSave)

        btnAdd.setOnClickListener {
            pickImageGalery()
        }



        btnSave.setOnClickListener {
            val databaseHelper = DatabaseHelper(this)
            val id : Int = textId.text.toString().toInt()
            val name : String =  namaMenu.text.toString().trim()
            val price : Int = hargaMenu.text.toString().toInt()
            val bitmapDrawable : BitmapDrawable = image.drawable as BitmapDrawable
            val bitmap : Bitmap = bitmapDrawable.bitmap

            val menuModel = menuModel(id,name,price,bitmap)
            databaseHelper.addMenu(menuModel)

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)



        }

    }
    private fun pickImageGalery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            image.setImageURI(data?.data)
        }
    }
}