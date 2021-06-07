package com.aoslec.quiz6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(MainActivity.this,"DOWN",Toast.LENGTH_SHORT).show();//손가락으로 화면을 누르기 시작했을 때 할 일
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Toast.makeText(MainActivity.this,"MOVE",Toast.LENGTH_SHORT).show();//터치 후 손가락을 움직일 때 할 일
                        break;
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainActivity.this,"UP",Toast.LENGTH_SHORT).show();//손가락을 화면에서 뗄 때 할 일
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Toast.makeText(MainActivity.this,"CANCEL",Toast.LENGTH_SHORT).show();// 터치가 취소될 때 할 일
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


    }//c
}//m