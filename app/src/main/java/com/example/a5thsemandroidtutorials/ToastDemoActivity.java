package com.example.a5thsemandroidtutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import es.dmoral.toasty.Toasty;

public class ToastDemoActivity extends AppCompatActivity {


    EditText getToastMsg;
    AppCompatButton buttonCreateToast;
    Toolbar toolbar;
    AppCompatImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_demo);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        imageViewBack = findViewById(R.id.ivBack);

        imageViewBack.setOnClickListener(v -> {
            super.onBackPressed();
        });





        getToastMsg = findViewById(R.id.toastMsg);
        buttonCreateToast = findViewById(R.id.btnToast);

        buttonCreateToast.setOnClickListener(v -> {

            String toastMsg = getToastMsg.getText().toString();
            //Toasty.info(this, toastMsg, Toast.LENGTH_SHORT, true).show();
            Toasty.success(this, toastMsg, Toast.LENGTH_SHORT, true).show();
        });

    }
}