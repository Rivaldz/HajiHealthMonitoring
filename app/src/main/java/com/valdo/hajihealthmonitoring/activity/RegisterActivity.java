package com.valdo.hajihealthmonitoring.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valdo.hajihealthmonitoring.R;
import com.valdo.hajihealthmonitoring.model.RegisterModel;

import static android.text.TextUtils.isEmpty;

public class RegisterActivity extends AppCompatActivity {
    ImageView backImage;
    EditText nama, email,noHp, pass;
    Button register;
    ProgressBar progressBar;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nama = findViewById(R.id.namaRegister);
        email = findViewById(R.id.emailRegister);
        noHp = findViewById(R.id.noHpRegister);
        pass = findViewById(R.id.passRegister);
        progressBar = findViewById(R.id.simpleProgressBarRegis);

        backImage = findViewById(R.id.buttonBack);
        register = findViewById(R.id.buttonDaftar);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");


        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });

       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String namaString = nama.getText().toString();
               String emailString = email.getText().toString();
               String noHpString = noHp.getText().toString();
               String passString = pass.getText().toString();
               if (!isEmpty(namaString) && !isEmpty(emailString) && !isEmpty(noHpString) && !isEmpty(passString)){
                   if (validasiEmail(emailString)) {
                       progressBar.setVisibility(View.VISIBLE);
                       regiterEmail();
                   }
                   else {
                       Toast.makeText(getBaseContext(), "Silahkan isi email dengan format yang benar", Toast.LENGTH_LONG).show();
                   }
               }
               else {
                   Toast.makeText(getBaseContext(), "Silahkan isi semua kolom", Toast.LENGTH_LONG).show();
               }

           }
       });

    }

    private void regiterEmail(){
        String emailString = email.getText().toString();
        String passString = pass.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(emailString, passString)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        fillDatabaseRegister();
                        Toast.makeText(getBaseContext(), "Berhasil Register Silahkan Login Untuk Melanjutkan",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();

                    }

                });

    }

    public static  boolean validasiEmail(String email){
        boolean validate;

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern)) {
            validate = true;
        } else if (email.matches(emailPattern2)) {
            validate = true;
        } else {
            validate = false;
        }
        return validate;

    }

    private  void fillDatabaseRegister(){
        String namaString = nama.getText().toString();
        String emailString = email.getText().toString();
        String noHpString = noHp.getText().toString();
        String passString = pass.getText().toString();
        String[] emailSplit = emailString.split("\\.");
        String email = emailSplit[0];

        RegisterModel registerModel = new RegisterModel(namaString,email,noHpString,passString);
        databaseReference.child(email).setValue(registerModel);

    }
}
