package com.aoslec.quiz14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.subTv);
        button = findViewById(R.id.subBtn);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("pw");

        button.setOnClickListener(main);

        if (id.equals("aaa") && pw.equals("1111")){
            textView.setText("인증되었습니다");
        }else {
            textView.setText("인증실패");
        }
    }//c

    View.OnClickListener main = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           finish();
        }
    };

}