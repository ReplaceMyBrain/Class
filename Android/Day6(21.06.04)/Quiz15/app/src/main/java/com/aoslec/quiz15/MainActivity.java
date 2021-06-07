package com.aoslec.quiz15;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a,b,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);

        button.setOnClickListener(btn);
    }//c


    View.OnClickListener btn =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문")
                    .setMessage("좌변을 선택 하십이오.")
                    .setPositiveButton("4",Click1)
                    .setNegativeButton("3",Click1)
                    .show();
        }
    };

    DialogInterface.OnClickListener Click1 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            if (which==DialogInterface.BUTTON_POSITIVE) {
                a = 4;
            }else {
                a = 3;
            }

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문2")
                    .setMessage("우변을 선택 하십이오.")
                    .setPositiveButton("6",Click2)
                    .setNegativeButton("5",Click2)
                    .show();
        }
    };

    DialogInterface.OnClickListener Click2 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            if (which==DialogInterface.BUTTON_POSITIVE) {
                b = 6;
            }else {
                b = 5;
            }

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문3")
                    .setMessage("어떤연산을 하시겠습니까?")
                    .setPositiveButton("곱셈",Click3)
                    .setNegativeButton("덧셈",Click3)
                    .show();
        }
    };

    DialogInterface.OnClickListener Click3 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            if(which==DialogInterface.BUTTON_POSITIVE){
                result = a*b;
            }else {
                result = a+b;
            }
            TextView textView = findViewById(R.id.tv);
            textView.setText("연산결과 : " + result);
            Toast.makeText(MainActivity.this, "연산을 완료하였습니다" , Toast.LENGTH_SHORT).show();
        }
    };




}//m