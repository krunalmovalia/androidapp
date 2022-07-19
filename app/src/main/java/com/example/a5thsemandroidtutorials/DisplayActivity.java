package com.example.a5thsemandroidtutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {


    Toolbar cToolBar;
    AppCompatImageView imageViewBack;
    AppCompatTextView txtTutorialTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        cToolBar = findViewById(R.id.cToolBar);
        setSupportActionBar(cToolBar);
        imageViewBack = findViewById(R.id.ivBack);

        txtTutorialTitle = findViewById(R.id.txtTutorial);
        txtTutorialTitle.setText(R.string.controls_demo);

        imageViewBack.setOnClickListener(v -> super.onBackPressed());


        Intent intent=getIntent();
        TextView name =(TextView)findViewById(R.id.name);
        name.setText(intent.getStringExtra("name"));
        TextView email =(TextView)findViewById(R.id.email);
        email.setText(intent.getStringExtra("email"));
        TextView age =(TextView)findViewById(R.id.age);
        age.setText(intent.getStringExtra("age"));
        TextView gender=(TextView)findViewById(R.id.gender);
        gender.setText(intent.getStringExtra("radioSex"));
        TextView branch=(TextView)findViewById(R.id.branch);
        branch.setText(intent.getStringExtra("branch"));
        TextView language=(TextView)findViewById(R.id.language);
        language.setText(intent.getStringExtra("language"));


    }
}