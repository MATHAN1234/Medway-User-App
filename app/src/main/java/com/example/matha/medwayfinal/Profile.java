package com.example.matha.medwayfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.matha.medwayfinal.Common.Common;

public class Profile extends AppCompatActivity {
    TextView Name,email,phone_no,bloodGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Name = (TextView)findViewById(R.id.nametext);
        email   = (TextView)findViewById(R.id.emailtext);
        phone_no = (TextView)findViewById(R.id.phonetext);
        bloodGroup =(TextView)findViewById(R.id.bloodgroup);

        Name.setText(Common.currentRider.getName());
        email.setText(Common.currentRider.getEmail());
        phone_no.setText(Common.currentRider.getPhone());
        bloodGroup.setText(Common.currentRider.getBloodGroup());
    }
}
