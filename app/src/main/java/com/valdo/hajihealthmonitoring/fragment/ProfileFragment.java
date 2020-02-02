package com.valdo.hajihealthmonitoring.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valdo.hajihealthmonitoring.MainActivity;
import com.valdo.hajihealthmonitoring.Preferences.Preferences;
import com.valdo.hajihealthmonitoring.R;
import com.valdo.hajihealthmonitoring.model.ProfileModel;
import com.valdo.hajihealthmonitoring.model.RegisterModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private Button logout,saveBt;
    private EditText email,username,noHp;
    private String emailSplit,key,pass;


    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        logout = view.findViewById(R.id.LogOut);
        username = view.findViewById(R.id.usernameProfil);
        email = view.findViewById(R.id.emailProfil);
        noHp = view.findViewById(R.id.noHpProfil);
        saveBt = view.findViewById(R.id.saveChanges);



        String emailLogin = Preferences.getLoggedInUser(getContext());
        String[] part = emailLogin.split("\\.");
        emailSplit = part[0];
        getFirebase();


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.clearLoggedInUser(getContext());
                view.getContext().startActivity(new Intent(getActivity(), MainActivity.class));

            }
        });

        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               updateProfile();
            }
        });


        return  view;
    }

    private void getFirebase(){

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        databaseReference.child("User").child(emailSplit).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ProfileModel showProfil = dataSnapshot.getValue(ProfileModel.class);
                key = dataSnapshot.getKey();
                username.setText(showProfil.getNama());
                email.setText(showProfil.getEmail());
                noHp.setText(showProfil.getNoHp());
                pass = showProfil.getPass();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void updateProfile(){
        RegisterModel registerModel = new RegisterModel(username.getText().toString(),email.getText().toString(),noHp.getText().toString(),pass);
        databaseReference.child("User").child(emailSplit).child(key).setValue(registerModel);
    }

}
