package com.valdo.hajihealthmonitoring.Booklet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.valdo.hajihealthmonitoring.R;

public class BookletStunting extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklet_stunting);
        pdfView =findViewById(R.id.pdfStunting);
        pdfView.fromAsset("PENGERTIAN STUNTING.pdf").load();
    }
}
