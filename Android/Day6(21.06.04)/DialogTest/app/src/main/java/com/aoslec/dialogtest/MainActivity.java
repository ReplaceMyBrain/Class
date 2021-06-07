package com.aoslec.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.call);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                AlertDialog.Builder bld = new AlertDialog.Builder(MainActivity.this);
//                bld.setTitle("알립니다");
//                bld.setMessage("대화상자를 열었습니다.");
//                bld.setIcon(R.mipmap.ic_launcher);
//                bld.show();

                new AlertDialog.Builder(MainActivity.this) // ;지워야함!
                    .setTitle("알립니다")
                    .setMessage("대화상자를 열었습니다.")
                    .setIcon(R.drawable.a)
                    .setCancelable(false)
                    .setPositiveButton("닫기", null)
                    .show();

            }
        });

    }
}