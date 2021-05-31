package com.aoslec.quiz3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText inputNum1, inputNum2;
     Button add,sub,mul,div;
     TextView textResult;
     Integer numA,numB;
     String result;

     //10개 숫자 버튼 배열
    Button[] numButtons = new Button[10];
    //10개 숫자 버튼의 id값 배열
    Integer[] numIDs ={R.id.num0,R.id.num1,R.id.num2,R.id.num3,R.id.num4,R.id.num5,R.id.num6,R.id.num7,R.id.num8,R.id.num9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("계산기");
        inputNum1 = findViewById(R.id.inputNum1);
        inputNum2 = findViewById(R.id.inputNum2);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        textResult = findViewById(R.id.textResult);

        add.setOnClickListener(onClickListener);
        sub.setOnClickListener(onClickListener);
        mul.setOnClickListener(onClickListener);
        div.setOnClickListener(onClickListener);

        //숫자 버튼 10개를 대입
        for (int i = 0; i < numIDs.length; i++) {
            numButtons[i] = findViewById(numIDs[i]);
        }

        //숫자 버튼 10개에 대해서 클릭 이벤트 처리
        for (int i = 0; i < numIDs.length; i++) {
            final int index = i; //인덱스는 버튼 번호를 뜻함

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //포커스가 되어 있는 에디트 텍스트에 숫자 추가
                    if (inputNum1.isFocused() == true) {
                        numA = Integer.parseInt(inputNum1.getText().toString() + numButtons[index].getText().toString());
                        inputNum1.setText(Integer.toString(numA));

                    } else if (inputNum2.isFocused() == true) {
                        numB = Integer.parseInt(inputNum2.getText().toString() + numButtons[index].getText().toString());
                        inputNum2.setText(Integer.toString(numB));
                    } else{
                        Toast.makeText(MainActivity.this, "항목을 입력하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }

    }


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
            textResult.setText("실행결과 : " + result);
        }
    };
}

//
//    EditText inputNum1, inputNum2;
//    Button add,sub,mul,div;
//    TextView textResult;
//    Integer numA,numB;
//    String result;
//
//    //10개 숫자 버튼 배열
//    Button[] numButtons = new Button[10];
//    //10개 숫자 버튼의 id값 배열
//    Integer[] numIDs ={R.id.num0,R.id.num1,R.id.num2,R.id.num3,R.id.num4,R.id.num5,R.id.num6,R.id.num7,R.id.num8,R.id.num9};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        setTitle("계산기");
//        inputNum1 = findViewById(R.id.inputNum1);
//        inputNum2 = findViewById(R.id.inputNum2);
//
//        add = findViewById(R.id.add);
//        sub = findViewById(R.id.sub);
//        mul = findViewById(R.id.mul);
//        div = findViewById(R.id.div);
//
//        textResult = findViewById(R.id.textResult);
//
//
//       add.setOnClickListener(mClickListener);
//       sub.setOnClickListener(mClickListener);
//       mul.setOnClickListener(mClickListener);
//       div.setOnClickListener(mClickListener);
//
//       //숫자 버튼 10개를 대입
//       for(int i=0; i< numIDs.length; i++){
//           numButtons[i].findViewById(numIDs[i]);
//       }
//
//       //숫자 버튼 10개에 대해서 클릭 이벤트 처리
//        for(int i=0; i< numIDs.length; i++){
//            final int index = i;
//
//            numButtons[index].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //포커스가 되어 있는 에디트텍스트에 숫자 추가
//                    if(inputNum1.isFocused() == true){
//                        //기존에 있는거 + 숫자입력한 것
//                        numA=Integer.parseInt(inputNum1.getText().toString()+ numButtons[index].getText().toString());
//                        inputNum1.setText(Integer.toString(numA));
//
//                    }else if(inputNum2.isFocused() ==true){
//                        numB=Integer.parseInt(inputNum2.getText().toString()+ numButtons[index].getText().toString());
//                        inputNum2.setText(Integer.toString(numB));
//
//                    }else {
//                        Toast.makeText(MainActivity.this, "입력 항목부터 선택하세요!" ,Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//    }
//
//    View.OnClickListener mClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            numA = Integer.parseInt((inputNum1.getText().toString()));
//            numB = Integer.parseInt((inputNum2.getText().toString()));
//
//            switch (v.getId()){
//                case R.id.add:
//                    result = Integer.toString(numA + numB);
//                    break;
//                case R.id.sub:
//                    result = Integer.toString(numA - numB);
//                    break;
//                case R.id.mul:
//                    result = Integer.toString(numA * numB);
//                    break;
//                case R.id.div:
//                    result = Double.toString(numA / (double)numB);
//                    break;
//            }
//            textResult.setText("실행결과 : " +result);
//        }
//    };
//}