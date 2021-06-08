package com.aoslec.datajson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    final static String Tag = "ABBS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parser();
    }

    private void parser(){
        Log.v(Tag,"parser();");

        //파일 불러올때만 쓰는법
        InputStream inputStream = getResources().openRawResource(R.raw.jsonex);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        try {
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            Log.v(Tag, "StringBuffer : "+ stringBuffer.toString()) ;

            JSONObject jsonObject = new JSONObject(stringBuffer.toString());

            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));

            for(int i = 0; i<jsonArray.length(); i++){

                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

                String name = jsonObject1.getString("name");
                Log.v(Tag,"name : " + name);

                int age = jsonObject1.getInt("age");
                Log.v(Tag,"age : " + age);

                JSONArray jsonArray1 = jsonObject1.getJSONArray("hobbies");

                for(int j=0; j<jsonArray1.length(); j++){
                    String hobby = jsonArray1.getString(j);
                    Log.v(Tag,"hobby : " + hobby);
                }

                JSONObject jsonObject2 = jsonObject1.getJSONObject("info");

                int no = jsonObject2.getInt("no");
                Log.v(Tag,"no : " + no);

                String id = jsonObject2.getString("id");
                Log.v(Tag,"id : " + id);
                String pw = jsonObject2.getString("pw");
                Log.v(Tag,"pw : " + pw);

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(inputStream != null) inputStream.close();
                if(inputStreamReader !=null) inputStreamReader.close();
                if(bufferedReader != null) bufferedReader.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}