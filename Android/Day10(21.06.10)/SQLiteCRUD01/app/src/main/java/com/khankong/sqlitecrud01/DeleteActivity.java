package com.khankong.sqlitecrud01;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {
    final static String TAG = "DeleteActivity";
    String scode, sname, sdept, sphone;
    EditText Ecode, Ename, Edept, Ephone;
    StudentInfo studentInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v(TAG, "Start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        studentInfo = new StudentInfo(DeleteActivity.this);

        Intent intent = getIntent();
        scode = intent.getStringExtra("code");
        sname = intent.getStringExtra("name");
        sdept = intent.getStringExtra("dept");
        sphone = intent.getStringExtra("phone");

        Ecode = findViewById(R.id.delete_code);
        Ename = findViewById(R.id.delete_name);
        Edept = findViewById(R.id.delete_dept);
        Ephone = findViewById(R.id.delete_phone);

        Ecode.setText(scode);
        Ename.setText(sname);
        Edept.setText(sdept);
        Ephone.setText(sphone);

        findViewById(R.id.delete_btn).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        SQLiteDatabase DB;

        @Override
        public void onClick(View v) {
            scode = Ecode.getText().toString();

            try {
                DB = studentInfo.getWritableDatabase();
                String query = "DELETE FROM student WHERE id = " + Integer.parseInt(scode) + ";";
                Log.v(TAG, query);
                DB.execSQL(query);
                studentInfo.close();
            }catch (Exception e){
                e.printStackTrace();
                Log.v(TAG, String.valueOf(e));
            }

            Toast.makeText(DeleteActivity.this, sname + "님이 삭제 되었습니다.", Toast.LENGTH_SHORT).show();

            // 화면 이동
            Intent intent = new Intent(DeleteActivity.this, SelectAllActivity.class);
            startActivity(intent);
        }
    };
}

