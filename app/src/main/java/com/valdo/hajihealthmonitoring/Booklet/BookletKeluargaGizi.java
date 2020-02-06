package com.valdo.hajihealthmonitoring.Booklet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.valdo.hajihealthmonitoring.R;

public class BookletKeluargaGizi extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklet_keluarga_gizi);
        pdfView = findViewById(R.id.keluargaGizi);
        pdfView.fromAsset("Keluargasadargizi.pdf").load();
    }
}
