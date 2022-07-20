package com.vast.singleactivitywithmorefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vast.singleactivitywithmorefragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, FirstFragment.newInstance(0))
            .commit()
    }
}