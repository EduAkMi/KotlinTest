package com.example.kotlintest.cProjectC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintest.R

class ActivityProjectC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_c)

        val fm = supportFragmentManager
        fm.beginTransaction().add(R.id.fragmentContainerC, FragmentCHome(), null).commit()
    }
}