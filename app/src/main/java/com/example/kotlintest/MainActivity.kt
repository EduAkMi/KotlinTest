package com.example.kotlintest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.kotlintest.aProjectA.ActivityProjectA
import com.example.kotlintest.bProjectB.ActivityProjectB
import com.example.kotlintest.cProjectC.ActivityProjectC
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnA: AppCompatButton = findViewById(R.id.btnMainOpenProjectA)
        val btnB: AppCompatButton = findViewById(R.id.btnMainOpenProjectB)
        val btnC: AppCompatButton = findViewById(R.id.btnMainOpenProjectC)

        btnA.setOnClickListener(openActivity(ActivityProjectA::class.java))
        btnB.setOnClickListener(openActivity(ActivityProjectB::class.java))
        btnC.setOnClickListener(openActivity(ActivityProjectC::class.java))
    }

    private fun openActivity(activity: Class<out Activity?>): View.OnClickListener? {
        return View.OnClickListener {
            startActivity(Intent(this, activity))
        }
    }
}