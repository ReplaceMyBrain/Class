package com.khankong.sqlitecrud01;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    final static String TAG = "UpdateActivity";
    String scode, sname, sdept, sphone;
    EditText Ecode, Ename, Edept, Ephone;
    StudentInfo studentInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        studentInfo = new StudentInfo(UpdateActivity.this);

        Intent intent = getIntent();
        scode = intent.getStringExtra("code");
        sname = intent.getStringExtra("name");
        sdept = intent.getStringExtra("dept");
        sphone = intent.getStringExtra("phone");

        Ecode = findViewById(R.id.update_code);
        Ename = findViewById(R.id.update_name);
        Edept = findViewById(R.id.update_dept);
        Ephone = findViewById(R.id.update_phone);

        Ecode.setText(scode);
        Ename.setText(sname);
        Edept.setText(sdept);
        Ephone.setText(sphone);

        Ename.setFilters(new InputFilter[]{ new InputFilter.LengthFilter(10)});
        Edept.setFilters(new InputFilter[]{ new InputFilter.LengthFilter(12)});
        Ephone.setFilters(new InputFilter[]{ new InputFilter.LengthFilter(12)});

        findViewById(R.id.update_btn).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        SQLiteDatabase DB;

        @Override
        public void onClick(View v) {
            scode = Ecode.getText().toString();
            sname = Ename.getText().toString();
            sdept = Edept.getText().toString();
            sphone = Ephone.getText().toString();

            try {
                Log.v("ggg", "try들어옴?");
                DB = studentInfo.getWritableDatabase();
                Log.v("ggg", "여기도함??");
                String query = "UPDATE student SET name = '" + sname + "', dept = '" + sdept + "', phone = '" + sphone + "' WHERE id = " + Integer.parseInt(scode) + ";";
                Log.v("ggg", query);
                DB.execSQL(query);
                studentInfo.close();
            }catch (Exception e){
                e.printStackTrace();
                Log.v(TAG, String.valueOf(e));
            }

            Toast.makeText(UpdateActivity.this, sname + "님이 수정 되었습니다.", Toast.LENGTH_SHORT).show();

            // 화면 이동
            Intent intent = new Intent(UpdateActivity.this, SelectAllActivity.class);
            startActivity(intent);
        }
    };
}
