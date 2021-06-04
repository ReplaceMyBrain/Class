package com.aoslec.question1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a=3, b=4;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문")
                        .setMessage("어떤연산을 하시겠습니까?")
                        .setPositiveButton("덧셈",mClick)
                        .setNegativeButton("곱셈",mClick)
                        .show();
            }
        });
    }//c

    DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            if(which==DialogInterface.BUTTON_POSITIVE){
                result = a+b;
            }else {
                result = a*b;
            }
            TextView textView = findViewById(R.id.result);
            textView.setText("연산결과 : " + result);
            Toast.makeText(MainActivity.this, "연산을 완료하였습니다" , Toast.LENGTH_SHORT).show();
        }
    };

}//m