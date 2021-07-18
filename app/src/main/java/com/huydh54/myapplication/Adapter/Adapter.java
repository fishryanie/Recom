package com.huydh54.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huydh54.myapplication.Model.Model;
import com.huydh54.myapplication.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    Context context;
//    LayoutInflater layoutInflater;
    ArrayList<Model> list;

    public Adapter(Context context, ArrayList<Model> list) {
        this.context = context;
//        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle.setText(list.get(position).getTitle());
        holder.txtTaiKhoan.setText(list.get(position).getDetail());
//        holder.txtdetail.setText(list.get(position).getDetail());
//        Glide.with(context).load(list.get(position).getImage().substring(0, 4) + "s" + list.get(position).getImage().substring(4, list.get(position).getImage().length())).into(holder.imageView);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, Detail.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                Bundle bundle = new Bundle();
//
////                bundle.putString("hinh",list.get(position).getImage().substring(0, 4) + "s" + list.get(position).getImage().substring(4, list.get(position).getImage().length()));
//                bundle.putString("ten",list.get(position).getTitle());
//                bundle.putString("mota",list.get(position).getDetail());
//
//                intent.putExtras(bundle);
//                context.startActivity(intent);
//                Toast.makeText(context,list.get(position).getTitle()+"",Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle, txtTaiKhoan;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtTaiKhoan = itemView.findViewById(R.id.txtTaiKhoan);
            imageView = itemView.findViewById(R.id.layoutImg);
        }
    }
}
