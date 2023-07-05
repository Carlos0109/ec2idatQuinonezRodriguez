package com.carlos.ec2qrjc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlos.ec2qrjc.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMapBinding
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentMap=supportFragmentManager.findFragmentById(R.id.fcv_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        val casaLocation = LatLng(-12.024291, -76.824409)
        googleMap.addMarker(MarkerOptions().position(casaLocation).title("Esta ubicacion señala Mi hogar"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(casaLocation))
        val idatCasaLocation = LatLng(-12.023652966624985, -76.9126567748211)
        googleMap.addMarker(MarkerOptions().position(idatCasaLocation).title("La central de Idat mas cercana a mi domicilio Idat-Ate"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(idatCasaLocation))
        val plazaHogarLocation = LatLng(-12.01287412048873, -76.8264303366018)
        googleMap.addMarker(MarkerOptions().position(plazaHogarLocation).title("Esta es la ubicacion de la plaza-parque de mi comunidad"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(plazaHogarLocation))
    }
}