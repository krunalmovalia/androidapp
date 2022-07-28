package com.example.a5thsemandroidtutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.a5thsemandroidtutorials.adapters.TutorialsAdapter;
import com.example.a5thsemandroidtutorials.model.TutorialsData;
import com.example.a5thsemandroidtutorials.tutorials.Tutorial01Activity;
import com.example.a5thsemandroidtutorials.tutorials.Tutorial02Activity;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity  {

    TutorialsAdapter tutorialsAdapter;
    ItemClickListener itemClickListener;
    Toolbar toolbar;
    AppCompatImageView imageViewExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        imageViewExit = findViewById(R.id.ivExit);

        imageViewExit.setOnClickListener(v -> {
            this.finish();
            System.exit(0);
        });

       // this.setTitle("Dashboard");


        List<TutorialsData> list = new ArrayList();
        list = getData();

        RecyclerView tutorialsRecyclerView = findViewById(R.id.tutorialsRecyclerView);
        tutorialsRecyclerView.setHasFixedSize(true);
        tutorialsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize listener
        itemClickListener=new ItemClickListener() {
            @Override
            public void onClick(int position, TutorialsData value) {
                switch (position){
                    case 0:
                        Intent i0 = new Intent(getApplicationContext(), CalculatorDemoActivity.class);
                        startActivity(i0);
                        break;
                    case 1:
                        Intent i1 = new Intent(getApplicationContext(), ToastDemoActivity.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(getApplicationContext(), DayNightActivity.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(getApplicationContext(), ClockDemoActivity.class);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(getApplicationContext(), ControlsActivity.class);
                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(getApplicationContext(), Tutorial01Activity.class);
                        startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(getApplicationContext(),Tutorial02Activity.class);
                        startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(getApplicationContext(), com.example.a5thsemandroidtutorials.tutorials.SplashActivity.class);
                        startActivity(i7);
                        break;
                }
//                Toast.makeText(getApplicationContext(),"Position : "
//                        +position +" || Value : "+value.toString(),Toast.LENGTH_SHORT).show();
            }
        };

        tutorialsAdapter = new TutorialsAdapter(DashboardActivity.this, (ArrayList<TutorialsData>) list, itemClickListener);
        tutorialsRecyclerView.setAdapter(tutorialsAdapter);
        tutorialsRecyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    private List<TutorialsData> getData() {
        List<TutorialsData> list = new ArrayList<>();
        list.add(new TutorialsData("Calculator Demo"));
        list.add(new TutorialsData("Toast Demo"));
        list.add(new TutorialsData("Day & Night Demo"));
        list.add(new TutorialsData("Clock Demo"));
        list.add(new TutorialsData("Controls Demo"));
        list.add(new TutorialsData("Tutorial 1"));
        list.add(new TutorialsData("Tutorial 2"));
        list.add(new TutorialsData("Tutorial 3,4 & 5"));
        return list;
    }


}