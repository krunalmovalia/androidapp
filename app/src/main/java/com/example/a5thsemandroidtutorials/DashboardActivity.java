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
        return list;
    }


}