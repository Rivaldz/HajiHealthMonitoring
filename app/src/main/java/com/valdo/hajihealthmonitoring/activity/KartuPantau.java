package com.valdo.hajihealthmonitoring.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.valdo.hajihealthmonitoring.Preferences.Preferences;
import com.valdo.hajihealthmonitoring.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class KartuPantau extends AppCompatActivity {
    TextView lihatTanggal, namaBalita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kartu_pantau);
        lihatTanggal = findViewById(R.id.tanggal);
        namaBalita = findViewById(R.id.textViewNamaBalita);
        namaBalita.setText(Preferences.getRegisteredBayi(getBaseContext()));
        setDate(lihatTanggal);
    }

    private void setDate(TextView view) {
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        String date = formatter.format(today);
        view.setText(date);
    }
}
