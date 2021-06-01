package com.aoslec.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=findViewById(R.id.rg_01);
        radioGroup.setOnCheckedChangeListener(checkedChangeListener);
    }//c

    RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            String str = "";
            RadioButton radioButton = findViewById(checkedId);
            str = radioButton.getText().toString();
            Toast.makeText(MainActivity.this, str + "is checked.", Toast.LENGTH_LONG).show();
        }
    };
}


//
//    RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(RadioGroup group, int checkedId) {
//            String str= "";
//
//            switch (checkedId){
//                case R.id.rb_01:
//                    str="서울";
//                case R.id.rb_02:
//                    str="경기도";
//                case R.id.rb_03:
//                    str="강원도";
//                case R.id.rb_04:
//                    str="충청도";
//                case R.id.rb_05:
//                    str="경상도";
//                case R.id.rb_06:
//                    str="전라도";
//                case R.id.rb_07:
//                    str="제주도";
//            }
//            Toast.makeText(MainActivity.this,"나의 고향은" + str +"입니다",Toast.LENGTH_SHORT).show();
//        }
//
//    };
//
//}//m