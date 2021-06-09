package com.aoslec.networkjsonex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {

    private Context mContext = null;
    private int Layout = 0;
    private LayoutInflater inflater = null;
    private ArrayList<JsonStudents> data = null;

    public StudentsAdapter(Context mContext, int layout, ArrayList<JsonStudents> data) {
        this.mContext = mContext;
        Layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public StudentsAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.students_layout,parent,false);
       ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentsAdapter.ViewHolder holder, int position) {
        holder.tv_code.setText("code : " + data.get(position).getCode());
        holder.tv_name.setText("name : " + data.get(position).getName());
        holder.tv_dept.setText("dept : " + data.get(position).getDept());
        holder.tv_phone.setText("phone : " + data.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

        public class ViewHolder extends RecyclerView.ViewHolder{
            public TextView tv_code;
            public TextView tv_name;
            public TextView tv_dept;
            public TextView tv_phone;

            public ViewHolder(View itemView) {
                super(itemView);
                    tv_code = itemView.findViewById(R.id.tv_code);
                    tv_name = itemView.findViewById(R.id.tv_name);
                    tv_dept = itemView.findViewById(R.id.tv_dept);
                    tv_phone = itemView.findViewById(R.id.tv_phone);
            }

    }//Class
}//-----