package com.example.a5thsemandroidtutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a5thsemandroidtutorials.adapters.TutorialsAdapter;
import com.example.a5thsemandroidtutorials.model.TutorialsData;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    TutorialsAdapter tutorialsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.setTitle("Dashboard");


        List<TutorialsData> list = new ArrayList();
        list = getData();

        RecyclerView tutorialsRecyclerView = findViewById(R.id.tutorialsRecyclerView);
        tutorialsRecyclerView.setHasFixedSize(true);
        tutorialsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tutorialsAdapter = new TutorialsAdapter(DashboardActivity.this, (ArrayList<TutorialsData>) list);
        tutorialsRecyclerView.setAdapter(tutorialsAdapter);
        tutorialsRecyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    private List<TutorialsData> getData() {
        List<TutorialsData> list = new ArrayList<>();
        list.add(new TutorialsData("Tutorial 1"));
        list.add(new TutorialsData("Tutorial 2"));
        list.add(new TutorialsData("Tutorial 3"));
        list.add(new TutorialsData("Tutorial 4"));
        list.add(new TutorialsData("Tutorial 5"));
        return list;
    }
}