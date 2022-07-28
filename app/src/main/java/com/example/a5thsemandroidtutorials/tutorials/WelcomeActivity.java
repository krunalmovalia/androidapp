package com.example.a5thsemandroidtutorials.tutorials;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.example.a5thsemandroidtutorials.R;

public class WelcomeActivity extends AppCompatActivity {

    Toolbar cToolBar;
    AppCompatImageView imageViewBack;
    AppCompatTextView txtTutorialTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        cToolBar = findViewById(R.id.cToolBar);
        setSupportActionBar(cToolBar);
        imageViewBack = findViewById(R.id.ivBack);

        txtTutorialTitle = findViewById(R.id.txtTutorial);
        txtTutorialTitle.setText(R.string.welcome_);

        imageViewBack.setOnClickListener(v -> super.onBackPressed());

        Intent intent=getIntent();
        TextView email =(TextView)findViewById(R.id.txtDisplay);
        email.setText(intent.getStringExtra("email"));
    }
}