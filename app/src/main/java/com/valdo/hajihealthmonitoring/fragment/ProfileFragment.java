package com.valdo.hajihealthmonitoring.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.valdo.hajihealthmonitoring.MainActivity;
import com.valdo.hajihealthmonitoring.Preferences.Preferences;
import com.valdo.hajihealthmonitoring.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    Button logout;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        logout = view.findViewById(R.id.LogOut);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.clearLoggedInUser(getContext());
                view.getContext().startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });

        return  view;
    }

}
