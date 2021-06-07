package com.aoslec.quiz8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button small,large;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        small = findViewById(R.id.small);
        large = findViewById(R.id.large);

        small.setOnClickListener(onClickListener);
        large.setOnClickListener(onClickListener);
    }//c

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.small:
                    tv1.setTextSize(0,10);
                    break;
                case R.id.large:
                    tv1.setTextSize(0,100);
                    break;
            }
        }
    };

}//m