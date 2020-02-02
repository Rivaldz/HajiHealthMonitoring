package com.valdo.hajihealthmonitoring.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.valdo.hajihealthmonitoring.Preferences.Preferences;
import com.valdo.hajihealthmonitoring.R;
import com.valdo.hajihealthmonitoring.activity.KartuPantau;
import com.valdo.hajihealthmonitoring.activity.LoginActivity;

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
        RelativeLayout buttonJadwal = view.findViewById(R.id.buttonJadwalMakan);



        buttonKesehatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (Preferences.getLoggedInStatus(getContext())){
                       startActivity(new Intent(getContext(), KartuPantau.class));
                    }
                    else
                        startActivity(new Intent(getContext(), LoginActivity.class));

            }
        });

        buttonJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EatTImeFragment nextFrag= new EatTImeFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

}
