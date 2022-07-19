package com.example.a5thsemandroidtutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ClockDemoActivity extends AppCompatActivity {


    Toolbar cToolBar;
    AppCompatTextView txtTutorialTitle;
    AppCompatImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_demo);

        cToolBar = findViewById(R.id.cToolBar);
        setSupportActionBar(cToolBar);
        imageViewBack = findViewById(R.id.ivBack);

        txtTutorialTitle = findViewById(R.id.txtTutorial);
        txtTutorialTitle.setText(R.string.clock_demo);

        imageViewBack.setOnClickListener(v -> super.onBackPressed());

    }
}