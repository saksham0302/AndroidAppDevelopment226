package com.example.cse226_notes.unit_5

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cse226_notes.R

class GeoCodeExample : AppCompatActivity() {

    private lateinit var address: EditText
    private lateinit var submitAddress: Button
    private lateinit var latitude: TextView
    private lateinit var longitude: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geo_code_example)

        address = findViewById(R.id.address)
        submitAddress = findViewById(R.id.submitAddress)
        latitude = findViewById(R.id.latitude)
        longitude = findViewById(R.id.longitude)

        submitAddress.setOnClickListener {

            if (address.text.toString().isEmpty()) {

                Toast.makeText(this, "Enter Address", Toast.LENGTH_SHORT).show()

            } else {

                getLocationFromAddress(address.text.toString())
            }
        }
    }

    private fun getLocationFromAddress(address: String) {

        val geoCoder = Geocoder(this)
        val list: List<Address> = geoCoder.getFromLocationName(address, 5)!!

        if (list.isNullOrEmpty()) {
            return
        }
        latitude.text = "Latitude: ${list[0].latitude}"
        longitude.text = "Longitude: ${list[0].longitude}"
    }
}