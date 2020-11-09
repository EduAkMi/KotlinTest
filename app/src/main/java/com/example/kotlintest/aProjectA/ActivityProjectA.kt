package com.example.kotlintest.aProjectA

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.kotlintest.R

class ActivityProjectA : AppCompatActivity() {
    private val txtText by lazy { findViewById<TextView>(R.id.txtProjectA) }
    private val edtEdit by lazy { findViewById<TextView>(R.id.edtProjectA) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_a)

        val btnUpdate = findViewById<AppCompatButton>(R.id.btnProjectAUpdate)
        val btnReset = findViewById<AppCompatButton>(R.id.btnProjectAReset)
        val btnVisible = findViewById<AppCompatButton>(R.id.btnProjectAVisible)
        val btnInvisible = findViewById<AppCompatButton>(R.id.btnProjectAInvisible)
        val btnGone = findViewById<AppCompatButton>(R.id.btnProjectAGone)

        btnUpdate.setOnClickListener(updateText())
        btnReset.setOnClickListener(resetText())
        btnVisible.setOnClickListener(makeTextVisible())
        btnInvisible.setOnClickListener(makeTextInvisible())
        btnGone.setOnClickListener(makeTextGone())
    }

    private fun makeTextGone(): View.OnClickListener? = View.OnClickListener {
        txtText.visibility = View.GONE
    }

    private fun makeTextInvisible(): View.OnClickListener? = View.OnClickListener {
        txtText.visibility = View.INVISIBLE
    }

    private fun makeTextVisible(): View.OnClickListener? = View.OnClickListener {
        txtText.visibility = View.VISIBLE
    }

    private fun resetText(): View.OnClickListener? = View.OnClickListener {
        txtText.text = ""
    }

    private fun updateText(): View.OnClickListener? = View.OnClickListener {
        txtText.text = edtEdit.text.toString()
    }
}