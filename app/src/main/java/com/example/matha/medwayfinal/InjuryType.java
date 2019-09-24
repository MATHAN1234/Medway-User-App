package com.example.matha.medwayfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InjuryType extends AppCompatActivity {

    public Button btn_heart;
    public Button btn_skin;
    public Button btn_paralysis;
    public Button btn_neural;
    public Button btn_fracture;
    public Button btn_head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury_type);

        btn_heart = (Button) findViewById(com.example.matha.medwayfinal.R.id.btn_headinjury);
       // btn_skin = (Button) findViewById();
      //  btn_paralysis = (Button) findViewById(qazi.tooba.com.drawer.R.id.btn_paralysis);
      //  btn_neural = (Button) findViewById(qazi.tooba.com.drawer.R.id.btn_neural);
      //  btn_fracture = (Button) findViewById(qazi.tooba.com.drawer.R.id.btn_fractures);
      //  btn_heart = (Button) findViewById(qazi.tooba.com.drawer.R.id.btn_headinjury);


    }

    public void onClick(View v) {
        Object dataTransfer[] = new Object[2];
        GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();

        switch (v.getId()) {

            case com.example.matha.medwayfinal.R.id.btn_headinjury:
                Intent i = new Intent(this,HeadInjury.class);
                startActivity(i);
                break;

/*
            case qazi.tooba.com.drawer.R.id.btn_heart:
                Intent heartintent = new Intent(this,HeartInjury.class);
                startActivity(heartintent);
                break;


            case qazi.tooba.com.drawer.R.id.btn_skin:
                Intent skinintent = new Intent(this,SkinInjury.class);
                startActivity(skinintent);
                break;


            case qazi.tooba.com.drawer.R.id.btn_paralysis:
                Intent paralysisintent = new Intent(this,ParalysisInjury.class);
                startActivity(paralysisintent);
                break;



            case qazi.tooba.com.drawer.R.id.btn_neural:
                Intent neuralintent = new Intent(this,NeuralInjury.class);
                startActivity(neuralintent);
                break;

            case R.id.btn_fractures:
                Intent fractureintent = new Intent(this,FractureInjury.class);
                startActivity(fractureintent);
                break;


                **/
        }


    }
}
