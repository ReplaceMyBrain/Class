package com.aoslec.buttomsheetdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BottomSheet bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
    }
}