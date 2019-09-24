package com.example.matha.medwayfinal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BottomSheetRiderFragment extends BottomSheetDialogFragment {
    String mTag;
    String mLocation, mdistance;

    public static BottomSheetRiderFragment newInstance(String Location)
    {
        BottomSheetRiderFragment f = new BottomSheetRiderFragment();
        Bundle args = new Bundle();
        args.putString("Location",Location);
       // args.putString("distance",Distance);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocation = getArguments().getString("Location");
      //  mdistance = getArguments().getString("distance");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_rider,container,false);

        TextView txtlocation = (TextView)view.findViewById(R.id.txtlocation);
        TextView txtdistance = (TextView)view.findViewById(R.id.txtdistance);


        txtlocation.setText(mLocation);
        return view;
    }
}
