package com.valdo.hajihealthmonitoring.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.valdo.hajihealthmonitoring.MainActivity;
import com.valdo.hajihealthmonitoring.R;

public class LoginActivity extends AppCompatActivity {
    TextView register;
    EditText email, password;
    Button loginBut ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = findViewById(R.id.textRegister);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        loginBut = findViewById(R.id.buttonLogin);

       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

           }
       });

       loginBut.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(LoginActivity.this, MainActivity.class));
           }
       });


    }
}
