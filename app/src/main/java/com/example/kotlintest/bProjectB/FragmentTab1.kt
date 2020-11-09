package com.example.kotlintest.bProjectB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.R

class FragmentTab1 : Fragment() {
    private lateinit var viewModel: ReligionViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtReligionName = view.findViewById<TextView>(R.id.txtTab1)
        val btnYes = view.findViewById<AppCompatButton>(R.id.btnTab1Yes)
        val btnNo = view.findViewById<AppCompatButton>(R.id.btnTab1No)

        txtReligionName.text = FragmentBTab.religionSelected
        viewModel = ViewModelProvider(requireActivity()).get(ReligionViewModel::class.java)

        btnYes.setOnClickListener(sendReligionConfirm(true))
        btnNo.setOnClickListener(sendReligionConfirm(false))
    }

    private fun sendReligionConfirm(confirm: Boolean): View.OnClickListener? {
        return View.OnClickListener {
            viewModel.setConfirmReligion(confirm)
            viewModel.setConfirmTab(true)
        }
    }
}