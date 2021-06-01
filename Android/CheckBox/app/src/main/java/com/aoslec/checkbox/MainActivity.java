package com.aoslec.checkbox;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox[] checks;
    Integer[] intager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //10개 숫자 버튼 배열
        checks = new CheckBox[4];
        //10개 숫자 버튼의 id 값 배열
        intager = new Integer[]{R.id.cb1,R.id.cb2,R.id.cb3,R.id.cb4};
        for (int i = 0; i < checks.length; i++) {
            checks[i] = findViewById(intager[i]);
            checks[i].setOnCheckedChangeListener(checkChangeListener);
        }
    }//OnCreate
    CompoundButton.OnCheckedChangeListener checkChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String str = "";
            //글자값 다합치려고 변수 선언
            for (int i=0;i<checks.length;i++){
                if(checks[i].isChecked() == true){
                    str += checks[i].getText().toString();
                }
            }
            Toast.makeText(MainActivity.this, str + "is checked.", Toast.LENGTH_SHORT).show();
        }
    };
}//MainActivity