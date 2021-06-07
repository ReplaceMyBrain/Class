package com.aoslec.listadddel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items =new ArrayList<String>();
        items.add("First");
        items.add("Second");
        items.add("Third");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,items);

        list =findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        list.setOnItemClickListener(mItemClickListener);
        findViewById(R.id.add).setOnClickListener(mClickListener);
        findViewById(R.id.delete).setOnClickListener(mClickListener);

    }//c

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText editText =findViewById(R.id.newItem);
            switch (v.getId()){
                case R.id.add:
                    String text = editText.getText().toString();
                    if (text.length() != 0){
                        items.add(text); //어레이 리스트에 넣어줌.
                        editText.setText(""); // text 초기화
                        adapter.notifyDataSetChanged();//어레이 리스트 재구성한다라는 말.
                    }
                    break;
                case R.id.delete:
                    int id;
                    id=list.getCheckedItemPosition(); // 체크된 것의 포지션 찾기
                    if(id !=ListView.INVALID_POSITION){
                        items.remove(id); //id값을 어레이리스트에서 지운다.
                        list.clearChoices(); //기존 선택했던것을 지워라!
                        adapter.notifyDataSetChanged();//어레이 리스트 재구성한다라는 말.
                    }
                    break;
            }

        }
    };

    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String message ="";
            message = "Select Item = " + items.get(position);
            Toast.makeText(MainActivity.this, message+"", Toast.LENGTH_SHORT).show();
        }
    };

}//m