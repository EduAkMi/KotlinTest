package com.example.kotlintest.bProjectB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.kotlintest.R

class FragmentBHome : Fragment() {
    lateinit var spinner: Spinner
    lateinit var religionSelected: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnResults = view.findViewById<AppCompatButton>(R.id.btnHomeBShowResults)
        spinner = view.findViewById(R.id.spinnerHomeB)

        val religions = resources.getStringArray(R.array.religions)
        spinner.adapter = ArrayAdapter(view.context, android.R.layout.simple_spinner_dropdown_item, religions)
        spinner.onItemSelectedListener = object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                religionSelected = religions[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}
        }

        btnResults.setOnClickListener(goToResults())
    }

    private fun goToResults(): View.OnClickListener? {
        return View.OnClickListener {
//            val fragManager : FragmentManager? = fragmentManager
//            fragManager?.beginTransaction()?.replace(R.id.fragmentContainerB, FragmentBTab(), null)?.addToBackStack("")?.commit()

            val fm = ActivityProjectB.fm
            val fragmentBTab = FragmentBTab()
            val bundle = Bundle()
            bundle.putString("religionSelected", religionSelected)
            fragmentBTab.arguments = bundle
            fm.beginTransaction().replace(R.id.fragmentContainerB, fragmentBTab, null).addToBackStack("").commit()
        }
    }
}