package com.example.a5thsemandroidtutorials.tutorials;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.example.a5thsemandroidtutorials.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {


    EditText emailID, password;
    TextView txtRegistration;
    String email = "admin@gmail.com", pass = "admin";
    AppCompatButton btnLogin;

    Toolbar cToolBar;
    AppCompatImageView imageViewBack;
    AppCompatTextView txtTutorialTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        cToolBar = findViewById(R.id.cToolBar);
        setSupportActionBar(cToolBar);
        imageViewBack = findViewById(R.id.ivBack);

        txtTutorialTitle = findViewById(R.id.txtTutorial);
        txtTutorialTitle.setText(R.string.login);

        imageViewBack.setOnClickListener(v -> super.onBackPressed());

        Toast.makeText(this, "Krunal Movalia 21SOECE13085", Toast.LENGTH_LONG).show();

        emailID = findViewById(R.id.email);
        password = findViewById(R.id.pwd);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegistration = findViewById(R.id.txtRegistration);

        txtRegistration.setOnClickListener(v -> {
            Intent in = new Intent(getApplicationContext(), RegistrationActivity.class);
            startActivity(in);
        });

        btnLogin.setOnClickListener(v -> {
            if (emailID.getText().toString().trim().isEmpty()){
                emailID.setError("Please enter your Email");
                emailID.requestFocus();
            }
            else if (!isValidEmail(emailID.getText().toString()) )
            {
                emailID.setError("Please enter valid Email");
                emailID.requestFocus();
            }
            else if (password.getText().toString().trim().isEmpty()){
                password.setError("Please enter your Password");
                password.requestFocus();
            }
            else if (emailID.getText().toString().equals(email) && password.getText().toString().equals(pass))
            {
                Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
                i.putExtra("email",emailID.getText().toString());
                startActivity(i);
                Toast.makeText(this, "Login Successfully !", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Invalid Email or Password.", Toast.LENGTH_SHORT).show();
            }

        });


    }
    private boolean isValidEmail(String Email){
        String Email_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(Email_PATTERN);
        Matcher matcher = pattern.matcher(Email);
        return matcher.matches();
    }
}