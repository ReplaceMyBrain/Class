package com.aoslec.listfromarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adapter 만들기
        ArrayAdapter<CharSequence> Adpater;
        Adpater = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_list_item_1);

        ListView list =findViewById(R.id.list);
        list.setAdapter(Adpater);

    }
}