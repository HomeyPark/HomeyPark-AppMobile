package com.example.trabajomovil.app

import Beans.Parking
import PlaceHolder.ParkingPlaceHolder
import Resource.CreateParkingResource
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.trabajomovil.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ParkingRegisterFragment : Fragment() {
    lateinit var service:ParkingPlaceHolder

    private lateinit var view: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_parking_register, container, false)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create<ParkingPlaceHolder>(ParkingPlaceHolder::class.java)

//        val btnRegister = view.findViewById<Button>(R.id.btn_register_parking)
//        btnRegister.setOnClickListener(){
//            val direccionText = view.findViewById<TextInputEditText>(R.id.direccion).text.toString()
//            val espacioText = view.findViewById<TextInputEditText>(R.id.espacio).text.toString()
//            val alturaText = view.findViewById<TextInputEditText>(R.id.altura).text.toString()
//            val longitudText = view.findViewById<TextInputEditText>(R.id.longitud).text.toString()
//            val anchoText = view.findViewById<TextInputEditText>(R.id.ancho).text.toString()
//            val horaInicioText = view.findViewById<TextInputEditText>(R.id.horaini).text.toString()
//            val horaCierreText = view.findViewById<TextInputEditText>(R.id.horacie).text.toString()
//            val precioText = view.findViewById<TextInputEditText>(R.id.precio).text.toString()
//            val telefonoText = view.findViewById<TextInputEditText>(R.id.num).text.toString()
//            val descripcionText = view.findViewById<TextInputEditText>(R.id.desc).text.toString()
//
//            // Convertir los datos necesarios a sus tipos correctos
//            val espaciosDisponibles = espacioText.toIntOrNull() ?: 0
//            val altura = alturaText.toDoubleOrNull() ?: 0.0
//            val longitud = longitudText.toDoubleOrNull() ?: 0.0
//            val ancho = anchoText.toDoubleOrNull() ?: 0.0
//            val precioPorHora = precioText.toDoubleOrNull() ?: 0.0
//
//            // Crear el objeto CreateParkingResource con los datos recogidos
//            val newParking = CreateParkingResource(
//                address = direccionText,
//                espaciosDisponibles = espaciosDisponibles,
//                width = altura,
//                length = longitud,
//                height = ancho,
//                horaInicio = horaInicioText,
//                horaCierre = horaCierreText,
//                precioPorHora = precioPorHora,
//                telefono = telefonoText,
//                descripcion = descripcionText
//            )
//        }
//
//
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

    fun createParking(newParking:CreateParkingResource){
        service.createParking(newParking).enqueue(object : Callback<Parking> {
            override fun onResponse(p0: Call<Parking>, p1: Response<Parking>) {
                if (p1.isSuccessful) {
                    val createdParking = p1.body()
                    if (createdParking != null) {
                        Log.d("API_SUCCESS", "Parking creado: ${createdParking.id}")
                    } else {
                        Log.e("API_ERROR", "Error")
                    }
                } else {
                    Log.e("API_ERROR", "Error al crear el parking: ${p1.code()}")
                }
            }

            override fun onFailure(p0: Call<Parking>, p1: Throwable) {
                p1.printStackTrace()
                Log.e("API_ERROR", "Error en la llamada a la API: ${p1.message}")
            }
        })
    }

}