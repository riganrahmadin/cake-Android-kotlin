package com.example.cakee


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MenuManagementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_management)
        getSupportActionBar()?.hide()

        val databaseHelper = DatabaseHelper(this)
        val listData = databaseHelper.ShowMenu()
        val rvmenu: RecyclerView = findViewById(R.id.recyclermenusettings)
        rvmenu.layoutManager = LinearLayoutManager(this)
        rvmenu.adapter = MenuSettingsAdapter(listData)


        val buttonAdd:Button = findViewById(R.id.addmenubutton)

        buttonAdd.setOnClickListener {
        val intent = Intent (this@MenuManagementActivity, AddMenuActivity::class.java)
            startActivity(intent)
        }


    }

}


