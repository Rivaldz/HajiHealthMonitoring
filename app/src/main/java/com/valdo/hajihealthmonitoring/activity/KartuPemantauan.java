package com.valdo.hajihealthmonitoring.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.valdo.hajihealthmonitoring.R;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class KartuPemantauan extends AppCompatActivity {
    TextView lihatTanggal, namaBalita, minggu;
    EditText tinggi,berat;
    Button submitBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kartu_pemantauan);
        lihatTanggal = findViewById(R.id.kartuTanggal);
        namaBalita = findViewById(R.id.kartuNama);
        minggu = findViewById(R.id.kartuMinggu);
        tinggi = findViewById(R.id.editTextTinggi);

        setDate(lihatTanggal);

        submitBut = findViewById(R.id.buttonKirim);

        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeData();
            }
        });

    }

    private void writeData(){
        try {
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(tinggi.getText().toString());
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setDate(TextView view) {
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        String date = formatter.format(today);
        view.setText(date);

    }
}
