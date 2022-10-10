package com.example.cakee

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()?.hide()

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val mainFragment =MainFragment()
        val menuFragment = MenuFragment()
        val settingFragment = SettingFragment()

        //default fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,mainFragment)
            commit()
        }
        currentFragment(mainFragment)


        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->currentFragment(mainFragment)
                R.id.menu->currentFragment(menuFragment)
                R.id.settings->currentFragment(settingFragment)

            }
            true
        }

    }
    private fun currentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }


}