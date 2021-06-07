package com.aoslec.quiz14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText id,pw;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.mainEtId);
        pw = findViewById(R.id.mainEtPw);

       button =findViewById(R.id.mainBtnOk);

       button.setOnClickListener(ok);

    }//c

    View.OnClickListener ok = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.mainBtnOk:
                    intent = new Intent(MainActivity.this, SubActivity.class);
                    intent.putExtra("id", id.getText().toString());
                    intent.putExtra("pw", pw.getText().toString());
                    startActivity(intent);
                    break;

            }

        }
    };
}