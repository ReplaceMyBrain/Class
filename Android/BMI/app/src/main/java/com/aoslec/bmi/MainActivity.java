package com.aoslec.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStart,btnCm,btnKg,btnResult;
    LinearLayout p0,p1,p2,p3,p4;
    EditText etCm,etKg;
    TextView tvBmi,tvBmiResult;
    double cm,cm2,kg;
    String bmiNum,bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼
        btnStart=findViewById(R.id.btn_start);
        btnCm=findViewById(R.id.btn_cm);
        btnKg=findViewById(R.id.btn_kg);
        btnResult=findViewById(R.id.btn_result);

        //레이아웃
        p0=findViewById(R.id.P0);
        p1=findViewById(R.id.P1);
        p2=findViewById(R.id.P2);
        p3=findViewById(R.id.P3);
        p4=findViewById(R.id.P4);

        //텍스트
        etCm=findViewById(R.id.etCm);
        etKg=findViewById(R.id.etKg);

        //텍스트뷰
        tvBmi=findViewById(R.id.tvBmi);
        tvBmiResult=findViewById(R.id.tvBmiResult);

        //레이아웃 모두숨겨놓기
        p1.setVisibility(View.INVISIBLE);
        p2.setVisibility(View.INVISIBLE);
        p3.setVisibility(View.INVISIBLE);
        p4.setVisibility(View.INVISIBLE);

        //버튼 클릭시 행동.
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setVisibility(View.VISIBLE);
                p0.setVisibility(View.INVISIBLE);

            }
        });

        btnCm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2.setVisibility(View.VISIBLE);
                p1.setVisibility(View.INVISIBLE);


            }
        });

        btnKg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p3.setVisibility(View.VISIBLE);
                p2.setVisibility(View.INVISIBLE);
                cm=Double.parseDouble(etCm.getText().toString());
                cm2=(cm/100)*(cm/100);

            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kg=Double.parseDouble(etKg.getText().toString());


                double bmi =kg/cm2;
                bmiNum = String.format("%.1f",bmi);

                if(bmi<=18.5){
                    bmiResult="저체중";
                }else if(bmi<23){
                    bmiResult="정상";
                }else if(bmi<25){
                    bmiResult="과체중 의심";
                }else if(bmi<30){
                    bmiResult="비만";
                }else {
                    bmiResult="고도비만";
                }

                p4.setVisibility(View.VISIBLE);
                p3.setVisibility(View.INVISIBLE);
                tvBmi.setText("너의 BMI는 " + bmiNum + "이고");
                tvBmiResult.setText(bmiResult+ "이야^^");

//                18.5이하 저체중
//                18.5~23 정상
//                23~25과체중 의심
//                25~30 비만
//                30이상 고도비만

            }
        });


    }//c
}//m