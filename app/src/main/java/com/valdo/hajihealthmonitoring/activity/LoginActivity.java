package com.valdo.hajihealthmonitoring.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.valdo.hajihealthmonitoring.MainActivity;
import com.valdo.hajihealthmonitoring.Preferences.Preferences;
import com.valdo.hajihealthmonitoring.R;
import com.valdo.hajihealthmonitoring.fragment.ProfileFragment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.time.Instant;

import static android.text.TextUtils.isEmpty;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    TextView register,lupaPass;
    EditText namaIbu, namaBalita, ttl;
    Button loginBut ;
    String emailSto;

    private ProgressBar mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        namaIbu = findViewById(R.id.editTextNamaIbu);
        namaBalita = findViewById(R.id.editTextBalita);
        ttl = findViewById(R.id.editTtl);

        loginBut = findViewById(R.id.buttonLogin);
        lupaPass = findViewById(R.id.forgotPassword);
        mProgress = findViewById(R.id.simpleProgressBar);


        firebaseAuth = FirebaseAuth.getInstance();

        lupaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotPassActivity.class ));
            }
        });


       loginBut.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String namaIbuSt = namaIbu.getText().toString();
               String namaBalitaSt = namaBalita.getText().toString();
               String ttlSt = ttl.getText().toString();
               if (!isEmpty(namaBalitaSt) && !isEmpty(namaIbuSt) && !isEmpty(ttlSt)) {

                   Preferences.setRegisteredIbu(getBaseContext(), namaIbuSt);
                   Preferences.setRegisteredBayi(getBaseContext(), namaBalitaSt);
                   Preferences.setRegisteredTtl(getBaseContext(), ttlSt);

                   Preferences.setLoggedInStatus(getBaseContext(),true);

                   startActivity(new Intent(LoginActivity.this, KartuPantau.class));
               }
               else {
                   Toast.makeText(getBaseContext(), "Silahkan isi semua form", Toast.LENGTH_SHORT);
               }


           }
       });


    }

}
