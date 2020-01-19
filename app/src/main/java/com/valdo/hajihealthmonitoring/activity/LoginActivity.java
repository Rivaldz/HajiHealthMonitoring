package com.valdo.hajihealthmonitoring.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.valdo.hajihealthmonitoring.MainActivity;
import com.valdo.hajihealthmonitoring.R;
import com.valdo.hajihealthmonitoring.fragment.ProfileFragment;

import java.time.Instant;

import static android.text.TextUtils.isEmpty;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

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

        firebaseAuth = FirebaseAuth.getInstance();

       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

           }
       });

       loginBut.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              String emailSt = email.getText().toString();
              String passSt = password.getText().toString();
              if (!isEmpty(emailSt) && !isEmpty(passSt)){
                  firebaseAuth.signInWithEmailAndPassword(emailSt,passSt)
                          .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {

                              }
                          });

              }
              else {

              }

               startActivity(new Intent(LoginActivity.this, MainActivity.class));

           }
       });


    }
}
