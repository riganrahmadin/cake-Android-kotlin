package com.example.cakee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //hide title bar
        getSupportActionBar()?.hide()

        //instance text
        val txtEmail:EditText = findViewById(R.id.editTextEmail)
        val txtPassword:EditText = findViewById(R.id.editTextPassword)
        //instance button login
        val btnLogin:Button = findViewById(R.id.buttonLogin)
        val btnRegister:TextView = findViewById(R.id.registerBtn)

        btnRegister.setOnClickListener {
            val intentRegister = Intent (this@LoginActivity, RegisterActivity::class.java)
            startActivity(intentRegister)
        }

        //event button login
        btnLogin.setOnClickListener {
            val databaseHelper = DatabaseHelper(this)
            val email = txtEmail.text.toString().trim()
            val password = txtPassword.text.toString().trim()

            //check login

            val result:Boolean = databaseHelper.checkLogin(email,password)
            if (result == true){
                Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()
                val intentLogin = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intentLogin)
            }else{
                Toast.makeText(this@LoginActivity, "Login Failed, Please Try Again", Toast.LENGTH_SHORT).show()
            }
        }
    }
}