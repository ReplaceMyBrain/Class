package com.aoslec.frametest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    LinearLayout f1,f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        f1=findViewById(R.id.f1);
        f2=findViewById(R.id.f2);


    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (f1.getVisibility() == v.INVISIBLE){
              f1.setVisibility(v.VISIBLE);
              f2.setVisibility(v.INVISIBLE);
            }else {
                f1.setVisibility(v.INVISIBLE);
            }
        }
    });


    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (f2.getVisibility() == v.INVISIBLE){
                f2.setVisibility(v.VISIBLE);
                f1.setVisibility(v.INVISIBLE);
            }else {
                f2.setVisibility(v.INVISIBLE);
            }
        }
    });



    }
}