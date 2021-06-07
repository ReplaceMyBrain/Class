package com.aoslec.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb01,pb02;
    Button progressBtn, resetBtn, showBtn, hideBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb01 = findViewById(R.id.pb_01);
        pb02 = findViewById(R.id.pb_02);

        progressBtn = findViewById(R.id.btn_01);
        resetBtn = findViewById(R.id.btn_02);
        showBtn = findViewById(R.id.btn_03);
        hideBtn = findViewById(R.id.btn_04);

        progressBtn.setOnClickListener(clickListener);
        resetBtn.setOnClickListener(clickListener);
        showBtn.setOnClickListener(clickListener);
        hideBtn.setOnClickListener(clickListener);
    }//c

    View.OnClickListener clickListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_01:
                    pb01.incrementProgressBy(10);
                    pb01.incrementSecondaryProgressBy(10);
                    break;
                case R.id.btn_02:
                    pb01.setProgress(0);
                    pb01.setSecondaryProgress(10);
                    break;
                case R.id.btn_03:
                    pb02.setVisibility(ProgressBar.VISIBLE);
                    break;
                case R.id.btn_04:
                    pb02.setVisibility(ProgressBar.INVISIBLE);
                    break;


            }
        }
    };
}