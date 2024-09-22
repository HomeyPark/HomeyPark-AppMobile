package com.example.trabajomovil.app

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.trabajomovil.AddCardActivity
import com.example.trabajomovil.R

class ProfileFragment : Fragment() {
    private lateinit var view: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false)

        val addCardButton =
            view.findViewById<Button>(R.id.btn_add_card)  // Asegúrate de tener este botón en el layout


        addCardButton.setOnClickListener {
            val intent = Intent(context, AddCardActivity::class.java)
            startActivity(intent)
        }

        return view
    }


}