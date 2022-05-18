package com.example.e_commerce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_commerce.ResponseModelClass.fetch_response_model;
//import com.example.e_commerce.ResponseModelClass.fetch_response_model;

import java.util.ArrayList;
import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>

{
    List <fetch_response_model> data;

    public myadapter(List<fetch_response_model> data) {
        this.data = data;
    }





    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(data.get(position).getCatname());
        holder.t2.setText(data.get(position).getSdec());
        Glide.with(holder.t1.getContext()).load("http://192.168.189.169/shopkro/catgimages/"+data.get(position).getImage()).into(holder.ig);

    }

    @Override
    public int getItemCount() {
        return  data.size();          //(data == null) ? 0 :
    }

    class  myviewholder extends RecyclerView.ViewHolder{
        ImageView ig;
        TextView t1,t2;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            ig=(itemView).findViewById(R.id.im1);
            t1=(itemView).findViewById(R.id.tv1);
            t2=(itemView).findViewById(R.id.tv2);
        }
    }
}
