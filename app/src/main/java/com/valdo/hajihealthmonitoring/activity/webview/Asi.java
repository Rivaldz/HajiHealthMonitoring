package com.valdo.hajihealthmonitoring.activity.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.valdo.hajihealthmonitoring.R;

public class Asi extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asi);
        webView = findViewById(R.id.webVIew);
        webView.loadUrl("https://m.facebook.com/");
    }
}
