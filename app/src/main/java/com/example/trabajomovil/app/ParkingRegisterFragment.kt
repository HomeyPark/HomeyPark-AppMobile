package com.example.trabajomovil.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trabajomovil.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ParkingRegisterFragment : Fragment() {
    private lateinit var view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_parking_register, container, false)
        return view
    }

    private var mapCallback = OnMapReadyCallback { map ->
        val defaultPosition = LatLng(-12.1035234, -76.9628504)
        map.addMarker(MarkerOptions().position(defaultPosition).title("Welcome to UPC"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultPosition, 16.0F))

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.parking_register_map) as SupportMapFragment?
        mapFragment?.getMapAsync(mapCallback)
    }
}