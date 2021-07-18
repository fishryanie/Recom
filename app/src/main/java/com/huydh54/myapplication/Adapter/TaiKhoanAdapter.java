package com.huydh54.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huydh54.myapplication.Model.ChucNang;
import com.huydh54.myapplication.R;

import java.util.ArrayList;

public class TaiKhoanAdapter extends BaseAdapter {
    Context context;
    ArrayList<ChucNang> dsChucNang = new ArrayList<ChucNang>();
    int loai;

    public TaiKhoanAdapter(Context context, ArrayList<ChucNang> dsChucNang, int loai) {
        this.context = context;
        this.dsChucNang = dsChucNang;
        this.loai = loai;
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
            view = inflater.inflate(R.layout.item_taikhoan2, null);
            viewHolder.hinh = view.findViewById(R.id.img_ChucNang);
            viewHolder.tieuDe = view.findViewById(R.id.txt_ChucNang);
            viewHolder.noiDung = view.findViewById(R.id.txt_NoiDung);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.hinh.setImageResource(dsChucNang.get(i).getHinh());
        viewHolder.tieuDe.setText(dsChucNang.get(i).getTieuDe());
        viewHolder.noiDung.setText(dsChucNang.get(i).getNoiDung());
        return view;
    }

    public class ViewHolder{
        ImageView hinh;
        TextView tieuDe, noiDung;
    }
}
