package com.aoslec.callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message", "subOnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button btnClose = findViewById(R.id.close);

        //화면 회전
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        setContentView(R.layout.activity_sub);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Message", "subClick");
                finish(); // 뒤로가기 버튼과 같음.
            }
        });
    }
}