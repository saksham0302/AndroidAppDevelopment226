package com.example.cse226_notes.unit_5

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.cse226_notes.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale

class CurrentLocationExample : AppCompatActivity() {

    private lateinit var btnCurrentLocation: Button
    private lateinit var tvLatitude: TextView
    private lateinit var tvLongitude: TextView
    private lateinit var tvCountry: TextView
    private lateinit var tvLocality: TextView
    private lateinit var tvAddress: TextView

    private lateinit var mFusedLocationProviderClient: FusedLocationProviderClient
    private val permissionId = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_location_example)

        btnCurrentLocation = findViewById(R.id.getCurrentLocation)
        tvLatitude = findViewById(R.id.tvLatitude)
        tvLongitude = findViewById(R.id.tvLongitude)
        tvCountry = findViewById(R.id.tvCountry)
        tvLocality = findViewById(R.id.tvLocality)
        tvAddress = findViewById(R.id.tvAddress)

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        btnCurrentLocation.setOnClickListener {
            getLocation()
        }
    }

    @SuppressLint("MissingPermission", "SetTextI18n")
    private fun getLocation() {

        if (checkPermissions()) {

            if (isLocationEnabled()) {

                mFusedLocationProviderClient.lastLocation.addOnSuccessListener {

                        location: Location? ->
                    location?.let {

                        val geocoder = Geocoder(this, Locale.getDefault())
                        val list: List<Address> =
                            geocoder.getFromLocation(
                                location.latitude, location.longitude,
                                1
                            )!!
                        tvLatitude.text = "Latitude: ${list[0].latitude}"
                        tvLongitude.text = "Longitude: ${list[0].longitude}"
                        tvCountry.text = "Country Name: ${list[0].countryName}"
                        tvLocality.text = "Locality: ${list[0].locality}"
                        tvAddress.text = "Address: ${list[0].getAddressLine(0)}"
                    }
                }
            } else {

                Toast.makeText(this, "Please turn on location", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }
    }

    private fun isLocationEnabled(): Boolean {

        val locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun checkPermissions(): Boolean {

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun requestPermissions() {

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ), permissionId
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == permissionId) {

            if ((grantResults.isNotEmpty() && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED)
            ) {

                getLocation()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (checkPermissions())
            getLocation()
    }
}