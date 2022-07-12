package com.example.a5thsemandroidtutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ClockDemoActivity extends AppCompatActivity {


    Toolbar toolbar;
    AppCompatImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_demo);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        imageViewBack = findViewById(R.id.ivBack);

        imageViewBack.setOnClickListener(v -> {
            super.onBackPressed();
        });

    }
}