package com.valdo.hajihealthmonitoring.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.valdo.hajihealthmonitoring.R;
import com.valdo.hajihealthmonitoring.activity.KartuPantau;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RelativeLayout buttonKesehatan = view.findViewById(R.id.buttonKesehatan);



        buttonKesehatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), KartuPantau.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
