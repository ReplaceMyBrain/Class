package com.aoslec.quiz8;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;
    Button btn;
    ImageView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        btn = findViewById(R.id.btn);
        image1 = findViewById(R.id.image1);

        //숨김
        tv2.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
        image1.setVisibility(View.INVISIBLE);


    tv1.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    btn.setVisibility(View.VISIBLE);
                    break;
                }
            }
            return true;
        }
    });

    btn.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            image1.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "롱클릭", Toast.LENGTH_SHORT).show();
            return true;
        }
    });

        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        tv2.setVisibility(View.VISIBLE);
                        break;
                    }
                }
                return true;
            }
        });




    }//c
}//m