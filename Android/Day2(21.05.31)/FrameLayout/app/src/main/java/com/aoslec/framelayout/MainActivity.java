package com.aoslec.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =findViewById(R.id.button);
        image = findViewById(R.id.image1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(image.getVisibility() == v.VISIBLE){
                    image.setVisibility(v.INVISIBLE);
                }else{
                    image.setVisibility(v.VISIBLE);
                }
            }
        });

    }
}