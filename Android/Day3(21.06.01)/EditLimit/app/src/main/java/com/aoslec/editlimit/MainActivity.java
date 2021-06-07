package com.aoslec.editlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    editText = findViewById(R.id.limit);
    editText.setFilters(new InputFilter[]{
            new InputFilter.LengthFilter(3)

        });

    }

}