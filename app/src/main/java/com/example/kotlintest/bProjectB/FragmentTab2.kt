package com.example.kotlintest.bProjectB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.R

class FragmentTab2 : Fragment() {
    private lateinit var viewModel: ReligionViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtConfirm = view.findViewById<TextView>(R.id.txtTab2)
        val imgConfirm = view.findViewById<ImageView>(R.id.imgTab2)

        txtConfirm.text = "Nos diga se a escolha estava certa ou errada"
        imgConfirm.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.ic_do_not_touch_24))

        viewModel = ViewModelProvider(requireActivity()).get(ReligionViewModel::class.java)
        viewModel.confirmReligion.observe(this, {
            if (it) {
                txtConfirm.text = "Você está no caminho certo!"
                imgConfirm.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.ic_architecture_24))
            } else {
                txtConfirm.text = "Pare sua build e volte para o código"
                imgConfirm.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.ic_local_fire_department_24))
            }
        })
    }
}