package com.aoslec.buttonedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //전역변수에 선업해 주는것이 좋다!
    Button button;
    EditText edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        edit = findViewById(R.id.edit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edit.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

            }
        });


    }
}