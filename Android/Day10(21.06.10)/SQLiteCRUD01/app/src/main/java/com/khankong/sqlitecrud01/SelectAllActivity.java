package com.khankong.sqlitecrud01;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SelectAllActivity extends AppCompatActivity {

    final static String TAG = "SelectAllActivity";
    ArrayList<Student> students = new ArrayList<Student>();
    StudentAdapter adapter;
    ListView listView;
    StudentInfo studentInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectall);

        listView = findViewById(R.id.lv_student);
        studentInfo = new StudentInfo(SelectAllActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        connectGetData();
        Log.v(TAG, "onResume()");
    }

    private void connectGetData(){
        SQLiteDatabase DB;

        try {
            students.clear();
            DB = studentInfo.getReadableDatabase();
            String query = "SELECT id, name, dept, phone FROM student;";
            Cursor cursor = DB.rawQuery(query, null);

            while(cursor.moveToNext()){
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String dept = cursor.getString(2);
                String phone = cursor.getString(3);

                Student student = new Student(Integer.toString(id), name, dept, phone);
                students.add(student);
            }
            cursor.close();
            studentInfo.close();
            Toast.makeText(SelectAllActivity.this, "Select OK!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(SelectAllActivity.this, "Select Error", Toast.LENGTH_SHORT).show();
        }

        try {
            adapter = new StudentAdapter(SelectAllActivity.this, R.layout.student_layout, students);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(onItemClickListener);
            listView.setOnItemLongClickListener(onItemLongClickListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        Intent intent = null;
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(SelectAllActivity.this, UpdateActivity.class);
            intent.putExtra("code", students.get(position).getCode());
            intent.putExtra("name", students.get(position).getName());
            intent.putExtra("dept", students.get(position).getDept());
            intent.putExtra("phone", students.get(position).getPhone());
            startActivity(intent);
        }
    };

    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        Intent intent = null;
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(SelectAllActivity.this, DeleteActivity.class);
            intent.putExtra("code", students.get(position).getCode());
            intent.putExtra("name", students.get(position).getName());
            intent.putExtra("dept", students.get(position).getDept());
            intent.putExtra("phone", students.get(position).getPhone());
            startActivity(intent);

            return false;
        }
    };

} // -----
