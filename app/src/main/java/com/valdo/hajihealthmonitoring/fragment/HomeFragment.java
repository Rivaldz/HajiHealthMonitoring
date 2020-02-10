package com.valdo.hajihealthmonitoring.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.valdo.hajihealthmonitoring.Booklet.BookletAkg;
import com.valdo.hajihealthmonitoring.Booklet.BookletKeluargaGizi;
import com.valdo.hajihealthmonitoring.Booklet.BookletMakanBalita;
import com.valdo.hajihealthmonitoring.Booklet.BookletStunting;
import com.valdo.hajihealthmonitoring.Booklet.BookletZatTubuh;
import com.valdo.hajihealthmonitoring.Preferences.Preferences;
import com.valdo.hajihealthmonitoring.R;
import com.valdo.hajihealthmonitoring.activity.KartuPantau;
import com.valdo.hajihealthmonitoring.activity.KartuPemantauan;
import com.valdo.hajihealthmonitoring.activity.LoginActivity;

import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

//    PDFView pdfView;



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
//        pdfView = view.findViewById(R.id.pdfv);
//        pdfView.fromAsset("ISI BOOKLET SEMENTARA18px.pdf").load();




        buttonKesehatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (Preferences.getLoggedInStatus(getContext())){
                       startActivity(new Intent(getContext(), KartuPemantauan.class));
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
                /// do this

                startActivity(new Intent(getContext(), BookletZatTubuh.class));
                break;

            case R.id.makanBalita:
                /// do this

                startActivity(new Intent(getContext(), BookletMakanBalita.class));
                break;

            case  R.id.KSG:

                startActivity(new Intent(getContext(), BookletKeluargaGizi.class));

                break;
        }



    }
}
