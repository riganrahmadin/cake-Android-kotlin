package com.example.cakee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //hide title bar
        getSupportActionBar()?.hide()


        //variable declaration
        val txtEmail:EditText = findViewById(R.id.et_email)
        val txtNama:EditText = findViewById(R.id.et_nama)
        val txtLevel:EditText = findViewById(R.id.et_level_r)
        val txtPassword:EditText = findViewById(R.id.et_password_r)
        //button
        val btnSave:TextView = findViewById(R.id.tv_register_r)

        btnSave.setOnClickListener(){
            val databaseHelper = DatabaseHelper(this)
            val email:String = txtEmail.text.toString().trim()
            val nama:String = txtNama.text.toString().trim()
            val level:String = txtLevel.text.toString().trim()
            val password:String = txtPassword.text.toString().trim()

            //data check
            val data = databaseHelper.checkData(email)
            if (data == null){
                databaseHelper.addAccount(email,nama,level,password)
                //go to LoginAct

                val intentLogin = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intentLogin)
            }else{
                //if data exists
                Toast.makeText(this@RegisterActivity, "Register failed, " + "your Email already registered", Toast.LENGTH_SHORT).show()
            }
        }

    }


    }
