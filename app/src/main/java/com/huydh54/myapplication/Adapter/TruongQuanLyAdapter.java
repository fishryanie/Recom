package com.huydh54.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huydh54.myapplication.Model.ChucNang;
import com.huydh54.myapplication.Model.ChucNangEdit;
import com.huydh54.myapplication.R;

import java.util.ArrayList;

public class TruongQuanLyAdapter extends BaseAdapter {
    Context context;
    ArrayList<ChucNangEdit> dsChucNang = new ArrayList<ChucNangEdit>();

    public TruongQuanLyAdapter(Context context, ArrayList<ChucNangEdit> dsChucNang) {
        this.context = context;
        this.dsChucNang = dsChucNang;
    }

    @Override
    public int getCount() {
        return dsChucNang.size();
    }

    @Override
    public Object getItem(int i) {
        return dsChucNang.get(i);
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
            view = inflater.inflate(R.layout.item_truongquanly, null);
            viewHolder.hinh = view.findViewById(R.id.img_Icon);
            viewHolder.tieuDe = view.findViewById(R.id.txt_TenTruong);
            viewHolder.noiDung = view.findViewById(R.id.edt_NoiDung);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.hinh.setImageResource(dsChucNang.get(i).getHinh());
        viewHolder.tieuDe.setText(dsChucNang.get(i).getTieuDe());
        viewHolder.noiDung.setText(dsChucNang.get(i).getNoiDung());
        viewHolder.noiDung.setHint(dsChucNang.get(i).getTieuDe());
        if (!dsChucNang.get(i).isChinhSua()) {
            viewHolder.noiDung.setEnabled(false);
            viewHolder.noiDung.setTextColor(Color.BLACK);
        }
        return view;
    }

    public class ViewHolder{
        ImageView hinh;
        TextView tieuDe, noiDung;
    }
}
