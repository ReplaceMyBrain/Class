package com.aoslec.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private int[] data = {R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7,
            R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7};

    private  CustomAdapter adapter =null;
    private GridView gridView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       adapter = new CustomAdapter(this, data);
       gridView =findViewById(R.id.gv_01);
       gridView.setAdapter(adapter);
    }
}