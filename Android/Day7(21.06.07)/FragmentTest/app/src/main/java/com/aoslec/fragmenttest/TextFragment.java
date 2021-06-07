package com.aoslec.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {

    TextView textView = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        Log.v("message", "f2_onCreateView");

        //textView 연결
        textView = view.findViewById(R.id.f2_text);

        return view;
    }

    public  void changTextProperties(int textSize ,String text){
        Log.v("message", "changTextProperties");
        textView.setTextSize(textSize);
        textView.setText(text);


    }

}