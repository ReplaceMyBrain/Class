package com.aoslec.recyclercardwebviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String urlAddr = "http://172.30.1.11:8080/test/people.json";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<JsonPeople> peoples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("RRR", "onCreate");

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Log.v("RRR", "onCreate1");

        try {
            NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr);
            Object obj = networkTask.execute().get();
            Log.v("RRR", "onCreate2");

            peoples = (ArrayList<JsonPeople>) obj;

            Log.v("RRR", "onCreate3");
            adapter = new PeoplesAdapter(MainActivity.this, R.layout.card_layout, peoples);
            recyclerView.setAdapter(adapter);

            Log.v("RRR", "onCreate4");

        } catch (Exception e) {
            e.printStackTrace();
            Log.v("RRR", "onCreate5");
        }

    }
}//---