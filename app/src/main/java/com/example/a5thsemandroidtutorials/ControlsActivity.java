package com.example.a5thsemandroidtutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlsActivity extends AppCompatActivity {


    Toolbar cToolBar;
    AppCompatImageView imageViewBack;
    AppCompatTextView txtTutorialTitle;

    EditText Name;
    EditText Email;
    EditText Age;
    RadioGroup radioSex;
    Spinner branch;
    ArrayAdapter<CharSequence> adapter;
    CheckBox hindi,english;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);


        cToolBar = findViewById(R.id.cToolBar);
        setSupportActionBar(cToolBar);
        imageViewBack = findViewById(R.id.ivBack);

        txtTutorialTitle = findViewById(R.id.txtTutorial);
        txtTutorialTitle.setText(R.string.controls_demo);

        imageViewBack.setOnClickListener(v -> super.onBackPressed());


        //View form Button
        AppCompatButton button =findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Name.getText().toString().trim().isEmpty()){
                    Name.setError("Please enter your name");
                    Name.requestFocus();
                }
                else if (!isValideEmail(Email.getText().toString()))
                {
                    Email.setError("Please enter your Email");
                    Email.requestFocus();
                }
                else if (Age.getText().toString().trim().isEmpty()){
                    Age.setError("Please enter your");
                    Age.requestFocus();
                }
                else {
                    sendMessage();
                }
            }
        });
        Name=(EditText)findViewById(R.id.name);
        Email=(EditText)findViewById(R.id.email);
        Age=(EditText)findViewById(R.id.age);
        radioSex=(RadioGroup)findViewById(R.id.radioSex);
        branch=(Spinner)findViewById(R.id.branch);
        adapter =ArrayAdapter.createFromResource(this,R.array.branch,R.layout.custom_spinner_layout);
        adapter.setDropDownViewResource(R.layout.custom_spinner_layout);
        hindi=(CheckBox)findViewById(R.id.hindi);
        english=(CheckBox)findViewById(R.id.english);
        branch.setAdapter(adapter);
        branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private boolean isValideEmail(String Email){
        String Email_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(Email_PATTERN);
        Matcher matcher = pattern.matcher(Email);
        return matcher.matches();
    }

    public void sendMessage(){
        Intent intent =new Intent(ControlsActivity.this,DisplayActivity.class);
        intent.putExtra("name",Name.getText().toString());
        intent.putExtra("email",Email.getText().toString());
        intent.putExtra("age",Age.getText().toString());
        //get selected radio button from radioGroup
        int selectedId =radioSex.getCheckedRadioButtonId();
        //find the radiobutton by retunend id
        RadioButton radioSexButton = (RadioButton)findViewById(selectedId);
        intent.putExtra("radioSex", radioSexButton.getText());
        intent.putExtra("branch",branch.getSelectedItem().toString());
        if(hindi.isChecked()&&english.isChecked())
        {
            intent.putExtra("language","Hindi,English");
        }
        else if(hindi.isChecked())
        {
            intent.putExtra("language","Hindi");
        }
        else if(english.isChecked())
        {
            intent.putExtra("language","English");
        }
        else
        {
            intent.putExtra("language","None");
        }
        startActivity(intent);


    }
}


