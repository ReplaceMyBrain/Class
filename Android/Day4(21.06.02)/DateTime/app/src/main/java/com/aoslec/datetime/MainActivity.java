package com.aoslec.datetime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.Year;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear,tvMonth,tvDay, tvHour, tvMinute;

    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //처음 실행 후 다시는 실행 안한다! 꼭 기억할 것!

        setTitle("시간 예약");


        //코멘트 꼭 적어두기!

        //크로노미터
        chrono = findViewById(R.id.chronometer1);

        //버튼
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);

        //라디오버튼
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);

        //FrameLayout의 2개 위젯
        tPicker = findViewById(R.id.timePicker1);
        calView = findViewById(R.id.calendarView1);

        //TextView중에서 년,월,일,시,분
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay= findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);



        // 처음에는 2개를 안보이게 설정 속성도 여기서 해주는거 좋다.
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        //타이머 설정
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        //캘린더 선택
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1; //0월부터 시작이다 꼭+1할것
                selectDay = dayOfMonth;
            }
        });

        //예약완료 버튼
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                //Picker에서 선택한 시간과 분
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

            }
        });

    }//c
}//m