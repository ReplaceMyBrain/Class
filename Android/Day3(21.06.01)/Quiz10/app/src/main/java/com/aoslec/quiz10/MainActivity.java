package com.aoslec.quiz10;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox start;
    LinearLayout startLayout;
    RadioGroup radioGroup;
    Button button;
    String str = "";
    ImageView dog,cat,rabbit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.cb_start);
        startLayout = findViewById(R.id.LL_start);

        radioGroup = findViewById(R.id.rg_animal);

        button = findViewById(R.id.btn_select);
        dog =findViewById(R.id.img_dog);
        cat =findViewById(R.id.img_cat);
        rabbit =findViewById(R.id.img_rabbit);



    start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if (start.isChecked() == true){
                startLayout.setVisibility(View.VISIBLE);
            }else {
                startLayout.setVisibility(View.INVISIBLE);
            }

        }
    });


//    button.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (radioGroup.getCheckedRadioButtonId()){
//                case R.id.rb_dog:
//                    imgPet.setImageResoursce(R.drawable.dog);
//                default:
//                    실패시 내용 적어주기 getApplicationContextext() 구동되고 있는 위치!
//            }
//        }

//    });


    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton radioButton = findViewById(checkedId);
            str = radioButton.getText().toString();
        }
    });

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (str.equals("강아지")){
               dog.setVisibility(v.VISIBLE);
               cat.setVisibility(v.INVISIBLE);
               rabbit.setVisibility(v.INVISIBLE);
            }
            if (str.equals("고양이")){
                dog.setVisibility(v.INVISIBLE);
                cat.setVisibility(v.VISIBLE);
                rabbit.setVisibility(v.INVISIBLE);
            }
            if (str.equals("토끼")){
                dog.setVisibility(v.INVISIBLE);
                cat.setVisibility(v.INVISIBLE);
                rabbit.setVisibility(v.VISIBLE);
            }
        }
    });

    }//c
}//m