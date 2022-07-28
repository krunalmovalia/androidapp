package com.example.a5thsemandroidtutorials.tutorials;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.example.a5thsemandroidtutorials.R;

public class DisplayActivity extends AppCompatActivity {

    Toolbar cToolBar;
    AppCompatImageView imageViewBack;
    AppCompatTextView txtTutorialTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tutorial);

        cToolBar = findViewById(R.id.cToolBar);
        setSupportActionBar(cToolBar);
        imageViewBack = findViewById(R.id.ivBack);

        txtTutorialTitle = findViewById(R.id.txtTutorial);
        txtTutorialTitle.setText(R.string.registration_form);

        imageViewBack.setOnClickListener(v -> super.onBackPressed());


        Intent intent=getIntent();
        TextView fname =(TextView)findViewById(R.id.dFname);
        fname.setText(intent.getStringExtra("fname"));
        TextView lname =(TextView)findViewById(R.id.dLname);
        lname.setText(intent.getStringExtra("lname"));
        TextView email =(TextView)findViewById(R.id.email);
        email.setText(intent.getStringExtra("email"));
        TextView pass =(TextView)findViewById(R.id.password);
        pass.setText(intent.getStringExtra("pass"));
        TextView gender=(TextView)findViewById(R.id.gender);
        gender.setText(intent.getStringExtra("radioSex"));
        TextView city=(TextView)findViewById(R.id.city);
        city.setText(intent.getStringExtra("city"));
        TextView status=(TextView)findViewById(R.id.status);
        status.setText(intent.getStringExtra("status"));


    }
}