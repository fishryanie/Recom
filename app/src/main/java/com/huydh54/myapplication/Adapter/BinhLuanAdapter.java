package com.huydh54.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huydh54.myapplication.Model.BinhLuan;
import com.huydh54.myapplication.Model.CongTy;
import com.huydh54.myapplication.R;

import java.util.ArrayList;

public class BinhLuanAdapter extends BaseAdapter {
    Context context;
    ArrayList<BinhLuan> dsBinhLuan = new ArrayList<BinhLuan>();

    public BinhLuanAdapter(Context context, ArrayList<BinhLuan> dsBinhLuan) {
        this.context = context;
        this.dsBinhLuan = dsBinhLuan;
    }

    @Override
    public int getCount() {
        return dsBinhLuan.size();
    }

    @Override
    public Object getItem(int i) {
        return dsBinhLuan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(R.layout.item_binhluan, null);
            viewHolder.icon = view.findViewById(R.id.img_IconHoatDong);
            viewHolder.nguoiBinhLuan = view.findViewById(R.id.txt_NguoiBinhLuan);
            viewHolder.hoatDong = view.findViewById(R.id.txt_HoatDong);
            viewHolder.noidung = view.findViewById(R.id.txt_NoiDungBL);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        if (dsBinhLuan.get(i).getLoai()==0){
            viewHolder.icon.setImageResource(R.drawable.load_review_chat);
            viewHolder.hoatDong.setText(" đã bình luận");
        } else if (dsBinhLuan.get(i).getLoai()==-1){
            viewHolder.icon.setImageResource(R.drawable.load_review_x);
            viewHolder.hoatDong.setText(" đã phản đối");
        } else {
            viewHolder.icon.setImageResource(R.drawable.load_review_check);
            viewHolder.hoatDong.setText(" đã tán thành");
        }
//        viewHolder.nguoiBinhLuan.setText(dsCongTy.get(i).getTenCongTy());
        viewHolder.noidung.setText(dsBinhLuan.get(i).getNoiDung());
        if (dsBinhLuan.get(i).getNoiDung().length()==0){
            viewHolder.noidung.setVisibility(View.GONE);
        }
//        viewHolder.diaChi.setText(dsCongTy.get(i).getDiaChi());
        return view;
    }

    public class ViewHolder{
        ImageView icon;
        TextView nguoiBinhLuan, hoatDong, noidung;
    }
}
