package com.example.a5thsemandroidtutorials.tutorials;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import com.example.a5thsemandroidtutorials.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {


    SwitchCompat switchButton;

    EditText FName, LName, Email, Password;
    RadioGroup radioSex;
    Spinner city;
    ArrayAdapter<CharSequence> adapter;
    CheckBox activeInactive;

    Toolbar cToolBar;
    AppCompatImageView imageViewBack;
    AppCompatTextView txtTutorialTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        cToolBar = findViewById(R.id.cToolBar);
        setSupportActionBar(cToolBar);
        imageViewBack = findViewById(R.id.ivBack);

        txtTutorialTitle = findViewById(R.id.txtTutorial);
        txtTutorialTitle.setText(R.string.registration_form);

        imageViewBack.setOnClickListener(v -> super.onBackPressed());

        AppCompatButton button =findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FName.getText().toString().trim().isEmpty()){
                    FName.setError("Please enter your First Name");
                    FName.requestFocus();
                }
                else if (LName.getText().toString().trim().isEmpty()){
                    LName.setError("Please enter your Last Name");
                    LName.requestFocus();
                }
                else if (Email.getText().toString().trim().isEmpty()){
                    Email.setError("Please enter your Email");
                    Email.requestFocus();
                }
                else if (!isValidEmail(Email.getText().toString()) )
                {
                    Email.setError("Please enter valid Email");
                    Email.requestFocus();
                }
                else if (Password.getText().toString().trim().isEmpty()){
                    Password.setError("Please enter your Password");
                    Password.requestFocus();
                }
                else {
                    sendMessage();
                }
            }
        });
        FName=(EditText)findViewById(R.id.fname);
        LName=(EditText)findViewById(R.id.lname);
        Email=(EditText)findViewById(R.id.email);
        Password=(EditText)findViewById(R.id.passd);
        switchButton = (SwitchCompat) findViewById(R.id.switchButton);
        radioSex=(RadioGroup)findViewById(R.id.radioSex);
        city=(Spinner)findViewById(R.id.branch);
        adapter =ArrayAdapter.createFromResource(this,R.array.city,R.layout.custom_spinner_layout);
        adapter.setDropDownViewResource(R.layout.custom_spinner_layout);
        activeInactive=(CheckBox)findViewById(R.id.activeInactive);
        city.setAdapter(adapter);
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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

    public void sendMessage(){
        Intent intent =new Intent(RegistrationActivity.this, com.example.a5thsemandroidtutorials.tutorials.DisplayActivity.class);
        intent.putExtra("fname",FName.getText().toString());
        intent.putExtra("lname",LName.getText().toString());
        intent.putExtra("email",Email.getText().toString());
        intent.putExtra("pass",Password.getText().toString());
        //get selected radio button from radioGroup
        int selectedId =radioSex.getCheckedRadioButtonId();
        //find the radiobutton by retunend id
        RadioButton radioSexButton = (RadioButton)findViewById(selectedId);
        intent.putExtra("radioSex", radioSexButton.getText());
        intent.putExtra("city",city.getSelectedItem().toString());
        if(activeInactive.isChecked())
        {
            intent.putExtra("status","Active");
        }
        else
        {
            intent.putExtra("status","Inactive");
        }
        startActivity(intent);


    }
}

