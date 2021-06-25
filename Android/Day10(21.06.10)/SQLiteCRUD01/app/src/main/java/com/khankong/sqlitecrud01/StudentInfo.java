package com.khankong.sqlitecrud01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class StudentInfo extends SQLiteOpenHelper {
    final static String TAG = "StudentInfo";

    public StudentInfo(@Nullable Context context) {
        super(context, "StudentInfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v(TAG, "onCreate()");
        String query = "CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, dept TEXT, phone TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(TAG, "onUpgrade()");
        String query = "DROP TABLE IF EXISTS student;";
        db.execSQL(query);
        onCreate(db);
    }
}
