package com.example.a5thsemandroidtutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class DayNightActivity extends AppCompatActivity {

    Toolbar cToolBar;
    AppCompatTextView txtTutorialTitle;
    AppCompatImageView imageViewBack;
    AppCompatButton buttonDay, buttonNight;
    LinearLayoutCompat ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_night);

        cToolBar = findViewById(R.id.cToolBar);
        setSupportActionBar(cToolBar);
        imageViewBack = findViewById(R.id.ivBack);

        txtTutorialTitle = findViewById(R.id.txtTutorial);
        txtTutorialTitle.setText(R.string.day_night_demo);

        imageViewBack.setOnClickListener(v -> super.onBackPressed());



        buttonDay = findViewById(R.id.btnDay);
        buttonNight = findViewById(R.id.btnNight);
        ll = findViewById(R.id.ll);

        buttonDay.setOnClickListener(v -> {
            ll.setBackgroundColor(Color.WHITE);
            Toasty.success(this, "Day Mode Activated.", Toast.LENGTH_SHORT, true).show();
        });

        buttonNight.setOnClickListener(v -> {
            ll.setBackgroundColor(Color.BLACK);
            Toasty.success(this, "Night Mode Activated.", Toast.LENGTH_SHORT, true).show();
        });
    }
}