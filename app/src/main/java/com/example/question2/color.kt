package com.example.question2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class ColorFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var layout: ConstraintLayout
    private lateinit var spinner: Spinner
    private lateinit var button: Button
    private lateinit var textView: TextView
    private var selectedColor: String = "White"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_color, container, false)

        layout = view.findViewById(R.id.fragment_layout)
        spinner = view.findViewById(R.id.spinner)
        button = view.findViewById(R.id.button)
        textView = view.findViewById(R.id.textView)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.colors_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this

        button.setOnClickListener {
            changeBackgroundColor(selectedColor)
        }

        return view
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        selectedColor = parent.getItemAtPosition(position) as String
        textView.text = "Selected Color: $selectedColor"
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Do nothing
    }

    private fun changeBackgroundColor(color: String) {
        when (color) {
            "Red" -> layout.setBackgroundColor(Color.RED)
            "Green" -> layout.setBackgroundColor(Color.GREEN)
            "Blue" -> layout.setBackgroundColor(Color.BLUE)
            "Yellow" -> layout.setBackgroundColor(Color.YELLOW)
            "Black" -> layout.setBackgroundColor(Color.BLACK)
            "White" -> layout.setBackgroundColor(Color.WHITE)
        }
    }
}
