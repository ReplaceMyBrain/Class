package com.aoslec.quiz0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnR1, btnG1, btnB1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnR1 =findViewById(R.id.btnR);
        btnG1 =findViewById(R.id.btnG);
        btnB1 =findViewById(R.id.btnB);

        btnR1.setOnClickListener(onClickListener);
        btnG1.setOnClickListener(onClickListener);
        btnB1.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String colortring = "";
            switch (v.getId()){

                case R.id.btnR:
                    colortring ="빨간색";
                    break;
                case R.id.btnG:
                    colortring ="녹색";
                    break;
                case R.id.btnB:
                    colortring ="파란색";
                    break;
            }
            Toast.makeText(MainActivity.this, colortring+" 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
        }
    };


//        btnR.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "빨간색", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        btnG.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "초록색", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        btnB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "파란색", Toast.LENGTH_SHORT).show();
//            }
//        });



}