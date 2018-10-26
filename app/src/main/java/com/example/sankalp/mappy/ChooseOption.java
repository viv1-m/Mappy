package com.example.sankalp.mappy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ChooseOption extends AppCompatActivity {

    double lat;
    double lon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        lat = bundle.getDouble("latitude");
        lon = bundle.getDouble("longitude");



    }
}
