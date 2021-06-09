package com.aoslec.recyclercardwebviewex;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PeoplesAdapter extends RecyclerView.Adapter<PeoplesAdapter.ViewHolder>  {

    private Context mContext = null;
    private int Layout = 0;
    private LayoutInflater inflater = null;
    private ArrayList<JsonPeople> data = null;

    public PeoplesAdapter(Context mContext, int layout, ArrayList<JsonPeople> data) {
        this.mContext = mContext;
        Layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public PeoplesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        Log.v("RRR", "Peo onCreate");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PeoplesAdapter.ViewHolder holder, int position) {
        Log.v("RRR", "bindview");
        holder.tv_code.setText("code : " + data.get(position).getCode());
        holder.tv_name.setText("name : " + data.get(position).getName());
        holder.tv_dept.setText("dept : " + data.get(position).getDept());
        holder.tv_phone.setText("phone : " + data.get(position).getPhone());
        holder.webView.loadDataWithBaseURL(null,htmlData(data.get(position).getImg()),"text/html,","UTF-8",null);
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
        public WebView webView;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.v("RRR", "holder");
            tv_code = itemView.findViewById(R.id.tv_code);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_dept = itemView.findViewById(R.id.tv_dept);
            tv_phone = itemView.findViewById(R.id.tv_phone);
            webView = itemView.findViewById(R.id.webView);
        }

    }//Class

    private  String htmlData(String location){
        String htmlData = "<html>" +
                "<head>"+
                "<meta name = \"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "</head>" +
                "<body>"+
                "<center>"+
                "<img src=\"http://192.168.2.3:8080/test/"+location+"\" style=\"width: 100%; height: auto;\">"+
                "</body>" +
                "</html>";

        return  htmlData;
    }
}//-----

