package com.example.googlemapsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img_location.setOnClickListener{
            val go_to_map = Intent(this, MapsActivity::class.java)
            startActivity(go_to_map)
        }
        tv_welcome.setOnClickListener{
           startActivity(Intent(this, MapsActivity::class.java))
        }
    }
}
