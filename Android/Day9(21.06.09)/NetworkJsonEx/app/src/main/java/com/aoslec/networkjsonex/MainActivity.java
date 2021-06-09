package com.aoslec.networkjsonex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String urlAddr = "http://172.30.1.11:8080/test/students.json";

    Button button;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<JsonStudents> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_network_con);

        recyclerView = findViewById(R.id.rv_students);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_network_con:
                        try{
                            NetworkTask networkTask = new NetworkTask(MainActivity.this,urlAddr);
                            Object obj = networkTask.execute().get();

                            students = (ArrayList<JsonStudents>) obj;

                            adapter = new StudentsAdapter(MainActivity.this, R.layout.students_layout,students);
                            recyclerView.setAdapter(adapter);
                            button.setText("Results");

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                }
            }
        });
    }
}//----