package com.example.matha.medwayfinal.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import com.example.matha.medwayfinal.R;

/**
 * Created by sickbay on 12/15/2017.
 */

public class CustomInfoWindow implements GoogleMap.InfoWindowAdapter{

    View myView;

    public CustomInfoWindow(Context context) {
        myView = LayoutInflater.from(context).inflate(R.layout.custom_rider_info_window,null);
    }

    @Override
    public View getInfoWindow(Marker marker) {
        TextView txtpickup =((TextView)myView.findViewById(R.id.pickup));
        txtpickup.setText(marker.getTitle());

        TextView txtpickupSnippet =((TextView)myView.findViewById(R.id.txtPickup));
        txtpickupSnippet.setText(marker.getSnippet());

        return myView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}