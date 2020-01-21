package com.valdo.hajihealthmonitoring.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.valdo.hajihealthmonitoring.R;

import static android.text.TextUtils.isEmpty;

public class ForgotPassActivity extends AppCompatActivity {
    private EditText email;
    private Button verifikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        email = findViewById(R.id.editTextEmailLupaPass);
        verifikasi = findViewById(R.id.buttonVerifikasi);

        verifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(email.getText().toString())) {
                    FirebaseAuth.getInstance().sendPasswordResetEmail(email.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent i = new Intent(ForgotPassActivity.this, LoginActivity.class);
                                        startActivity(i);
                                        Toast.makeText(ForgotPassActivity.this, "Sukses reset password silahkan cek Email", Toast.LENGTH_LONG).show();
                                    } else {

                                        Toast.makeText(ForgotPassActivity.this, "Email Tidak Terdaftar ", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
                else
                    Toast.makeText(ForgotPassActivity.this, "Silahkan isi Email anda", Toast.LENGTH_LONG).show();
            }
        });
    }
}

