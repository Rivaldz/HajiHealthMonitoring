package com.valdo.hajihealthmonitoring.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.valdo.hajihealthmonitoring.Booklet.BookletAkg;
import com.valdo.hajihealthmonitoring.Booklet.BookletKeluargaGizi;
import com.valdo.hajihealthmonitoring.Booklet.BookletMakanBalita;
import com.valdo.hajihealthmonitoring.Booklet.BookletStunting;
import com.valdo.hajihealthmonitoring.Booklet.BookletZatTubuh;
import com.valdo.hajihealthmonitoring.Preferences.Preferences;
import com.valdo.hajihealthmonitoring.R;
import com.valdo.hajihealthmonitoring.activity.EatSchedule;
import com.valdo.hajihealthmonitoring.activity.KartuPantau;
import com.valdo.hajihealthmonitoring.activity.KartuPemantauan;
import com.valdo.hajihealthmonitoring.activity.MenuResep;

import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment implements View.OnClickListener{

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
        RelativeLayout buttonMenuResep = view.findViewById(R.id.buttonMenuResep);

        CardView stunting = view.findViewById(R.id.stunting);
        stunting.setOnClickListener(this);
        CardView akg = view.findViewById(R.id.AKG);
        akg.setOnClickListener(this);
        CardView zatgizi = view.findViewById(R.id.zatGizi);
        zatgizi.setOnClickListener(this);
        CardView makanBalita = view.findViewById(R.id.makanBalita);
        makanBalita.setOnClickListener(this);
        CardView ksg = view.findViewById(R.id.KSG);
        ksg.setOnClickListener(this);
        TextView txtSelamat = view.findViewById(R.id.selamat);

        buttonJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), EatSchedule.class));
            }
        });

        buttonKesehatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), KartuPemantauan.class));
            }
        });
        buttonMenuResep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MenuResep.class));
            }
        });
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        String greeting = null;
        if (hour >= 12 && hour < 17){
            greeting = "Selamat Sore";
        }else if (hour >=17 && hour < 18.30){
            greeting = "Selamat Petang";
        }else if (hour >=18.30 && hour < 24){
            greeting = "Selamat Malam";
        }else if (hour >= 10 && hour < 12){
            greeting = "Selamat Siang";
        }else {
            greeting = "Selamat Pagi";
        }
        txtSelamat.setText(greeting);
        return view;

    }

// klik listener fot stunting information
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.stunting:
                startActivity(new Intent(getContext(), BookletStunting.class));
                break;
            case R.id.AKG:
                /// do this
                startActivity(new Intent(getContext(), BookletAkg.class));
                break;

            case R.id.zatGizi:
                startActivity(new Intent(getContext(), BookletZatTubuh.class));
                break;

            case R.id.makanBalita:
                startActivity(new Intent(getContext(), BookletMakanBalita.class));
                break;

            case  R.id.KSG:
                startActivity(new Intent(getContext(), BookletKeluargaGizi.class));
                break;
        }
    }

}
