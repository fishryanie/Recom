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

import com.huydh54.myapplication.Model.Nganh;
import com.huydh54.myapplication.R;

import java.util.ArrayList;

public class NganhAdapter extends BaseAdapter {
    Context context;
    ArrayList<Nganh> dsNganh = new ArrayList<Nganh>();
    ArrayList<Integer> soCTList = new ArrayList<>();

    public NganhAdapter(Context context, ArrayList<Nganh> dsNganh, ArrayList<Integer> soCTList) {
        this.context = context;
        this.dsNganh = dsNganh;
        this.soCTList = soCTList;
    }

    @Override
    public int getCount() {
        return dsNganh.size();
    }

    @Override
    public Object getItem(int i) {
        return dsNganh.get(i);
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
            view = inflater.inflate(R.layout.item_nganhnghe, null);
            viewHolder.hinh = view.findViewById(R.id.img_AnhNganh);
            viewHolder.tieuDe = view.findViewById(R.id.txt_TenNganh);
            viewHolder.soCongTy = view.findViewById(R.id.txt_SoCongTy);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        String imgName = dsNganh.get(i).getHinhAnh();
        int imgID = ((Activity) context).getResources().getIdentifier(
                imgName, "drawable", ((Activity) context).getPackageName()
        );
        try {
            viewHolder.hinh.setImageResource(imgID);
        }catch (Exception e){
            viewHolder.hinh.setImageResource(R.drawable.load_loai_loi);
        }
        if(viewHolder.hinh.getDrawable() == null){
            viewHolder.hinh.setImageResource(R.drawable.load_loai_loi);
        }
        viewHolder.hinh.setBackgroundColor(dsNganh.get(i).getMauSac());
        viewHolder.tieuDe.setText(dsNganh.get(i).getTenNganh());
        viewHolder.soCongTy.setTextColor(dsNganh.get(i).getMauSac());
        viewHolder.soCongTy.setText(soCTList.get(i)+"");
        return view;
    }

    public class ViewHolder{
        ImageView hinh;
        TextView tieuDe, soCongTy;
    }
}
