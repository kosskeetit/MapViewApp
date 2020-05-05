package com.example.googlemapsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        val cities = HashMap<String, String>()
        cities["Lagos"] = "6.5480357,3.1438665"
        cities["Wuhan"] = "30.567816,114.0201731"
        cities["Prague"] = "50.0593324,14.1854288"
        cities["Accra"] = "5.5911921,-0.3198226"
        cities["Paris"] = "48.8587741,2.2069729"
        cities["Guadalajara"] = "20.6737777,-103.4054551"
        cities["Florida"] = "27.3015726,-92.8472251"
        cities["Medellin"] = "6.2686594,-75.7364788"

        for (key in cities.keys){
            val location = cities[key]//string
            val coords = location?.split(",")
//            coords = (6.5480357,3.1438665)
            val lat: Double = (coords?.get(0)?.toDouble()?:Double) as Double
            val long: Double = (coords?.get(1)?.toDouble()?:Double) as Double

//            add a marker
            val cityname = LatLng(lat, long)
            mMap.addMarker(MarkerOptions().position(cityname).title("Marker in $key"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(cityname))


        }




        }




    }
