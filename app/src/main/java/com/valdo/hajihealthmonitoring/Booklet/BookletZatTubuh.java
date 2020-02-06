package com.valdo.hajihealthmonitoring.Booklet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.valdo.hajihealthmonitoring.R;

public class BookletZatTubuh extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklet_zat_tubuh);
        pdfView = findViewById(R.id.zatTubuh);
        pdfView.fromAsset("zatgizitubuh.pdf").load();
    }
}
