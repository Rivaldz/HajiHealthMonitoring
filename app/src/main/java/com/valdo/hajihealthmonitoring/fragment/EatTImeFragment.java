package com.valdo.hajihealthmonitoring.fragment;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valdo.hajihealthmonitoring.MainActivity;
import com.valdo.hajihealthmonitoring.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EatTImeFragment extends Fragment {

    public static final int notifikasi = 1;
    public EatTImeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_eat_time, container, false);
        return  view;
    }

}
