package com.valdo.hajihealthmonitoring;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.valdo.hajihealthmonitoring.Preferences.Preferences;
import com.valdo.hajihealthmonitoring.fragment.EatTImeFragment;
import com.valdo.hajihealthmonitoring.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    public static final int notifikasi = 1;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
        Intent inten = new Intent(getApplicationContext(), MainActivity.class);
        tampilNotifikasi("ini logo", "ini gatau", inten);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
//        mAdView.setVisibility(View.INVISIBLE);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment !=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.action_home:
//                fragment =new HomeFragment();
                break;
            case R.id.action_profile:
                if (Preferences.getLoggedInStatus(getBaseContext())){
//                fragment = new ProfileFragment();
                }
                else
//                startActivity(new Intent(this, LoginActivity.class));

                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    private void tampilNotifikasi(String s, String s1, Intent intent) {
        // membuat komponen pending intent
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this
                , notifikasi, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // membuat komponen notifikasi
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        Notification notification;
        notification = builder.setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentTitle(s)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(MainActivity.this.getResources()
                        , R.mipmap.ic_launcher))
                .setContentText(s1)
                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) MainActivity.this
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notifikasi, notification);
    }

}
