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
import com.huydh54.myapplication.Model.CongTy;
import com.huydh54.myapplication.Model.Nganh;
import com.huydh54.myapplication.R;

import java.util.ArrayList;

public class CongTyAdapter extends BaseAdapter {
    Context context;
    ArrayList<CongTy> dsCongTy = new ArrayList<CongTy>();

    public CongTyAdapter(Context context, ArrayList<CongTy> dsCongTy) {
        this.context = context;
        this.dsCongTy = dsCongTy;
    }

    @Override
    public int getCount() {
        return dsCongTy.size();
    }

    @Override
    public Object getItem(int i) {
        return dsCongTy.get(i);
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
            view = inflater.inflate(R.layout.item_congty, null);
            viewHolder.anh = view.findViewById(R.id.img_LogoCongTy);
            viewHolder.tenCongTy = view.findViewById(R.id.txt_TenCongTy);
            viewHolder.nhanVien = view.findViewById(R.id.txt_NhanVien);
            viewHolder.diaChi = view.findViewById(R.id.txt_DiaChi);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        String imgName = dsCongTy.get(i).getHinhAnh();
        int imgID = ((Activity) context).getResources().getIdentifier(
                imgName, "drawable", ((Activity) context).getPackageName()
        );
        try {
            viewHolder.anh.setImageResource(imgID);
        }catch (Exception e){
            viewHolder.anh.setImageResource(R.drawable.load_loi);
        }
        if(viewHolder.anh.getDrawable() == null){
            viewHolder.anh.setImageResource(R.drawable.load_loi);
        }
        viewHolder.tenCongTy.setText(dsCongTy.get(i).getTenCongTy());
        viewHolder.nhanVien.setText(dsCongTy.get(i).getSoLuongNhanVien());
        viewHolder.diaChi.setText(dsCongTy.get(i).getDiaChi());
        return view;
    }

    public class ViewHolder{
        ImageView anh;
        TextView tenCongTy, nhanVien, diaChi;
    }
}
