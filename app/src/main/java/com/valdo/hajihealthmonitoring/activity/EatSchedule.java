package com.valdo.hajihealthmonitoring.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.valdo.hajihealthmonitoring.R;
import com.valdo.hajihealthmonitoring.activity.webview.Asi;


public class EatSchedule extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout scedule1,scedule2, scedule4, scedule5, scedule6, scedule7, scedule8 , scedule3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_schedule);

        scedule1 = findViewById(R.id.firstSce);
        scedule1.setOnClickListener(this);

        scedule2 = findViewById(R.id.secondSce);
        scedule2.setOnClickListener(this);

        scedule3 = findViewById(R.id.thirdSce);
        scedule3.setOnClickListener(this);

        scedule4 = findViewById(R.id.fourSce);
        scedule4.setOnClickListener(this);

        scedule5 = findViewById(R.id.fiveSce);
        scedule5.setOnClickListener(this);

        scedule6 = findViewById(R.id.sixSce);
        scedule6.setOnClickListener(this);

        scedule7 = findViewById(R.id.sevenSce);
        scedule7.setOnClickListener(this);

        scedule8 = findViewById(R.id.eightSce);
        scedule8.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firstSce:
                startActivity(new Intent(getApplication(), Asi.class));
                break;
        }

    }
}
