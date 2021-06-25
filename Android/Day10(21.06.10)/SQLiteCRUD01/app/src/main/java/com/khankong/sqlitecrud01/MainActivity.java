package com.khankong.sqlitecrud01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button insertBtn = null;
    private Button updateBtn = null;
    private Button deleteBtn = null;
    private Button selectAllBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListener();
    }

    private void addListener(){
        insertBtn = findViewById(R.id.btn_insert);
        updateBtn = findViewById(R.id.btn_update);
        deleteBtn = findViewById(R.id.btn_delete);
        selectAllBtn = findViewById(R.id.btn_selectA);

        insertBtn.setOnClickListener(onClickListener);
        updateBtn.setOnClickListener(onClickListener);
        deleteBtn.setOnClickListener(onClickListener);
        selectAllBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_insert:
                    intent = new Intent(MainActivity.this, InsertActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_update:
                    Toast.makeText(MainActivity.this,"검색후 선택을 짧게 수정화면으로 이동 합니다", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_delete:
                    Toast.makeText(MainActivity.this,"검색후 선택을 길게 누르면 삭제화면으로 이동 합니다.", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_selectA:
                    intent = new Intent(MainActivity.this, SelectAllActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };


} // ------