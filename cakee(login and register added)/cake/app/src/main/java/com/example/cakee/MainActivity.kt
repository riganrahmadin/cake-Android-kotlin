package com.example.cakee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()?.hide()

        val mainFragment =MainFragment()

        //default fragment

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,mainFragment)
            commit()
        }
    }
}