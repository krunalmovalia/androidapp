package com.example.a5thsemandroidtutorials.tutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Toast;

import com.example.a5thsemandroidtutorials.R;

public class Tutorial01Activity extends AppCompatActivity {

    Toolbar cToolBar;
    AppCompatImageView imageViewBack;
    AppCompatTextView txtTutorialTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial01);


        cToolBar = findViewById(R.id.cToolBar);
        setSupportActionBar(cToolBar);
        imageViewBack = findViewById(R.id.ivBack);

        txtTutorialTitle = findViewById(R.id.txtTutorial);
        txtTutorialTitle.setText(R.string.tutorial01);

        imageViewBack.setOnClickListener(v -> super.onBackPressed());

        Toast.makeText(this, "Krunal Movalia 21SOECE13085", Toast.LENGTH_LONG).show();

    }
}