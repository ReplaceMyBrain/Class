package com.aoslec.orderdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.call);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout linear = (LinearLayout) View.inflate(MainActivity.this, R.layout.oder, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("주문정보를 입력하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        .setView(linear)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText product = linear.findViewById(R.id.product); //리니어에 있는것을 가져와야 하기 때문에! 기억하라!
                                EditText number = linear.findViewById(R.id.number);
                                CheckBox paymethod = linear.findViewById(R.id.paymethod);
                                TextView textView =findViewById(R.id.text);
                                textView.setText("주문정보 : " + product.getText() + "상품, " + number.getText() + "개" + (paymethod.isChecked() ? "  착불결재" : ""));
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TextView textView =findViewById(R.id.text);
                                textView.setText("추문을 취소했습니다.");
                            }
                        })
                        .show();
            }
        });

    }
}