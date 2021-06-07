package com.aoslec.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputNum1, inputNum2;
    Button add,sub,mul,div;
    Integer numA,numB;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("두 값을 입력받아 계산하기");
        inputNum1 = findViewById(R.id.inputNum1);
        inputNum2 = findViewById(R.id.inputNum2);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        add.setOnClickListener(onClickListener);
        sub.setOnClickListener(onClickListener);
        mul.setOnClickListener(onClickListener);
        div.setOnClickListener(onClickListener);
    }//c

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            numA = Integer.parseInt(inputNum1.getText().toString());
            numB = Integer.parseInt(inputNum2.getText().toString());

            switch (v.getId()) {
                case (R.id.add):
                    result = Integer.toString(numA + numB);
                    break;
                case (R.id.sub):
                    result = Integer.toString(numA - numB);
                    break;
                case (R.id.mul):
                    result = Integer.toString(numA * numB);
                    break;
                case (R.id.div):
                    if(numB==0){
                        Toast.makeText(MainActivity.this, "0은 나눗셈이 불가능합니다", Toast.LENGTH_SHORT).show();
                    }else{
                        result = Double.toString(numA / numB);
                    }
                    break;
            }
            Toast.makeText(MainActivity.this, "실행결과 : " + result, Toast.LENGTH_SHORT).show();
        }
    };

}//m