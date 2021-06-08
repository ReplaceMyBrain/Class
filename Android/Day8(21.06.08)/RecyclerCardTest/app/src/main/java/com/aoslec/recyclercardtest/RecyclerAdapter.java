package com.aoslec.recyclercardtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private  String[] title = {"Monday 월","Tuesday 화","Wednesday 수","Thursday 목","Friday 금","Saturday 토","Sunday 일"};
    private  String[] details= {"월요일 기상정보","화요일 기상정보","수요일 기상정보","목요일 기상정보","금요일 기상정보","토요일 기상정보","일요일 기상정보"};
    private  int[] images = {R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7};


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.itemTitle.setText(title[position]);
        holder.itemDetail.setText(title[position]);
        holder.itemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
       public ImageView itemImage;
       public TextView itemTitle;
       public TextView itemDetail;

       public ViewHolder(View itemView) {
           super(itemView);
           itemImage = itemView.findViewById(R.id.imageView);
           itemTitle = itemView.findViewById(R.id.item_title);
           itemDetail = itemView.findViewById(R.id.item_detail);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    int position = getAdapterPosition();
                   Snackbar.make(v, details[position], Snackbar.LENGTH_LONG).setAction("",null).show();
               }
           });

       }



   }//Class
}//-----
