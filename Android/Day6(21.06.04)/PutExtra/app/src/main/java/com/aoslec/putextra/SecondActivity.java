package com.aoslec.putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView = null;
    Button button = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.tv_second);
        button = findViewById(R.id.btn_second);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");
        int passwd = intent.getIntExtra("passwd",0);
        textView.setText("UserID :" + userid + " / " + "Password : " + passwd);

        button.setOnClickListener(onClickListener);
    }//c

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}