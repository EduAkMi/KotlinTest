package com.example.kotlintest.bProjectB

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.kotlintest.R

class ActivityProjectB : AppCompatActivity() {
    companion object {
        lateinit var fm: FragmentManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_b)

        fm = supportFragmentManager
        fm.beginTransaction().add(R.id.fragmentContainerB, FragmentBHome(), null).commit()
    }
}