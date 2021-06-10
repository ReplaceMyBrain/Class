package com.aoslec.dbcrud.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aoslec.dbcrud.Adapter.StudentAdapter;
import com.aoslec.dbcrud.Bean.Student;
import com.aoslec.dbcrud.NetworkTask.NetworkTask;
import com.aoslec.dbcrud.R;

import java.util.ArrayList;

public class SelectAllActivity extends AppCompatActivity {

    String urlAddr = null;
    ArrayList<Student> members;
    StudentAdapter adapter;
    ListView listView;
    String macIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);

        listView = findViewById(R.id.lv_student);

        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/student_query_all.jsp";
    }

    @Override
    protected void onResume() {
        super.onResume();
        connectGetData();
    }

    private  void  connectGetData(){
        try {
            NetworkTask networkTask = new NetworkTask(SelectAllActivity.this, urlAddr, "select");
            Object obj = networkTask.execute().get();
            members = (ArrayList<Student>) obj;

            adapter = new StudentAdapter(SelectAllActivity.this, R.layout.student_layout, members);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(onItemClickListener);
            listView.setOnItemLongClickListener(onItemLongClickListener);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        Intent intent = null;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(SelectAllActivity.this, UpdateActivity.class);
            intent.putExtra("code",members.get(position).getCode());
            intent.putExtra("name",members.get(position).getName());
            intent.putExtra("dept",members.get(position).getDept());
            intent.putExtra("phone",members.get(position).getPhone());
            startActivity(intent);
        }
    };

    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        Intent intent = null;

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(SelectAllActivity.this, UpdateActivity.class);
            intent.putExtra("code",members.get(position).getCode());
            intent.putExtra("name",members.get(position).getName());
            intent.putExtra("dept",members.get(position).getDept());
            intent.putExtra("phone",members.get(position).getPhone());
            startActivity(intent);
            return true;
        }
    };

}//==