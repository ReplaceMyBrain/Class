package com.aoslec.customadapterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdaoter  extends BaseAdapter {

    private Context mContext = null; //뷰? ex)Activity
    private int layout = 0; // 번호순서
    private ArrayList<Weather> data = null; // 내용
    private LayoutInflater inflater =null;

    public WeatherAdaoter(Context mContext, int layout, ArrayList<Weather> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //직접 써준다.
    }

    @Override
    public int getCount() {
        return data.size(); // ArrayList 크기 이 크기만큼 넣어준다.
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getDay();
    }

    @Override
    public long getItemId(int position) {
        return position; //포지션만 넣어주자
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView =inflater.inflate(this.layout,parent,false);
        }
        TextView tv_day = convertView.findViewById(R.id.tv_day);
        ImageView iv_icon = convertView.findViewById(R.id.iv_weather);
        TextView tv_comment = convertView.findViewById(R.id.tv_comment);


        //한줄을 넣어준다.
        tv_day.setText(data.get(position).getDay()+" "); // 맨 텍스트 넣어줌
        iv_icon.setImageResource(data.get(position).getIcon()); // 이미지 넣어줌
        tv_comment.setText(data.get(position).getComment()); // 텍스트 넣어줌

        //배경색 바꿔주기.
        if(position%2==1){
            convertView.setBackgroundColor(0x5000ff00);
        }else {
            convertView.setBackgroundColor(0x2000ff00);
        }
        return convertView; //이거 꼭 넣어주기 잊지말기!!!
    }
}
