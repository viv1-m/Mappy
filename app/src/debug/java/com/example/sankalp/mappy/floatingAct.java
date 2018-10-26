package com.example.sankalp.mappy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import static android.provider.UserDictionary.Words.APP_ID;

public class floatingAct extends AppCompatActivity {

    TextView tvlocation;
    ImageButton locationButton;
    GoogleApiClient googleApiClient;
    double lat;
    double lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating);

        tvlocation = findViewById(R.id.location);
        locationButton = findViewById(R.id.locationButton);

    }


    public void locationClicked(View view){

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

            lat = lastLocation.getLatitude();
            lon = lastLocation.getLongitude();

            tvlocation.setText(lat + " , " + lon);

        }

    }

    public void searchClicked(View view){

        // Enter code to put lat and lon to firebase

        Intent intent = new Intent(this , ChooseOption.class);
        intent.putExtra("Latitude" , lat);
        intent.putExtra("longitude" , lon);

        startActivity(intent);


    }

}