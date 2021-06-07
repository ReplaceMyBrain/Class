package com.aoslec.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ToolBarFragment.ToolbarListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Message", "onCreate");
    }

    @Override
    public void onButtonClick(int postion, String text) {
        Log.v("Message", "onButtonClick");

        //클래스를 받아옴.
        TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_2);

        //textFragment에 있는 메소드 실행
        textFragment.changTextProperties(postion, text);


    }
}