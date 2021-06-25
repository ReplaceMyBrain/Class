package com.khankong.sqlitecrud01;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {
    final static String TAG = "InsertActivity";
    String sname, sdept, sphone;
    EditText Ename, Edept, Ephone;
    StudentInfo studentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        studentInfo = new StudentInfo(InsertActivity.this);

        Ename = findViewById(R.id.insert_name);
        Edept = findViewById(R.id.insert_dept);
        Ephone = findViewById(R.id.insert_phone);

        Ename.setFilters(new InputFilter[]{ new InputFilter.LengthFilter(10)}); // 입력 자릿수 제한
        Edept.setFilters(new InputFilter[]{ new InputFilter.LengthFilter(12)});
        Ephone.setFilters(new InputFilter[]{ new InputFilter.LengthFilter(12)});

        findViewById(R.id.insert_btn).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        SQLiteDatabase DB;

        @Override
        public void onClick(View view) {
            sname = Ename.getText().toString();
            sdept = Edept.getText().toString();
            sphone = Ephone.getText().toString();

            try {
                DB = studentInfo.getWritableDatabase();
                String query = "INSERT INTO student(name, dept, phone) VALUES ('" + sname +"', '" + sdept + "', '" + sphone + "');";
                DB.execSQL(query);
                Log.v(TAG, query);
                studentInfo.close();
            }catch (Exception e){
                e.printStackTrace();
            }

            Toast.makeText(InsertActivity.this, sname + "님이 입력 되었습니다.", Toast.LENGTH_SHORT).show();

            // 화면 이동
            Intent intent = new Intent(InsertActivity.this, MainActivity.class);
            startActivity(intent);

        }

    };

} // ----- DB 보기 : View > Tool Windows > Device File Explorer ... data > data > package name

