package com.aoslec.quiz7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button apple, orange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.tv1);

        apple=findViewById(R.id.apple);
        orange=findViewById(R.id.orange);

        apple.setOnClickListener(button);
        orange.setOnClickListener(button);

    }

    View.OnClickListener button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.apple:
                    tv1.setText("APPLE");
                    break;
                case R.id.orange:
                    tv1.setText("ORANGE");
                    break;
            }

        }
    };

}