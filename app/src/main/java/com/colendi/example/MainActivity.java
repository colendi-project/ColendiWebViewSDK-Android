package com.colendi.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.colendi.webview.ColendiWebView;
import com.colendi.webview.ColendiWebViewCallback;

public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getSimpleName();

    ColendiWebView colendiWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colendiWebView = findViewById(R.id.wenView);
        colendiWebView.setActivity(this, s -> {
            Log.d(TAG, "onMessageReceived: ");
        });
        colendiWebView.loadUrl("http://192.168.1.24:8080/");
    }
}