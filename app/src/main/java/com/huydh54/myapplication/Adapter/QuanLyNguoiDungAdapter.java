package com.huydh54.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.huydh54.myapplication.Model.NguoiDung;
import com.huydh54.myapplication.R;
import com.huydh54.myapplication.Tool.TinhToan;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class QuanLyNguoiDungAdapter extends BaseAdapter {
    Context context;
    ArrayList<NguoiDung> dsNguoiDung = new ArrayList<NguoiDung>();

    public QuanLyNguoiDungAdapter(Context context, ArrayList<NguoiDung> dsNguoiDung) {
        this.context = context;
        this.dsNguoiDung = dsNguoiDung;
    }

    @Override
    public int getCount() { return dsNguoiDung.size(); }

    @Override
    public Object getItem(int i) {
        return dsNguoiDung.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        TinhToan tinhToan = new TinhToan();
        int bacTinCay = tinhToan.tinhDoTinCay(dsNguoiDung.get(i).getTongTanThanh(), dsNguoiDung.get(i).getTongPhanDoi());
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(R.layout.item_nguoidung, null);
            viewHolder.avatar = view.findViewById(R.id.img_AvatarTT);
            viewHolder.hoTen = view.findViewById(R.id.txt_TenND);
            viewHolder.taiKhoan = view.findViewById(R.id.txt_NoiDungTaiKhoan);
            viewHolder.tenHienThi = view.findViewById(R.id.txt_NDTenHienThi);
            viewHolder.doTinCay = view.findViewById(R.id.txt_DoTinCay);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        String imgName = dsNguoiDung.get(i).getHinhAnh();
        int imgID = ((Activity) context).getResources().getIdentifier(
                imgName, "drawable", ((Activity) context).getPackageName()
        );


//        try {
//            viewHolder.avatar.setImageResource(imgID);
//        }catch (Exception e){
//            if (dsNguoiDung.get(i).isGioiTinh()){
//                viewHolder.avatar.setImageResource(R.drawable.load_avatar_macdinh_nam);
//            } else {
//                viewHolder.avatar.setImageResource(R.drawable.load_avatar_macdinh_nu);
//            }
//        }



        if(dsNguoiDung.get(i).getHinhAnh().isEmpty() || dsNguoiDung.get(i).getHinhAnh() == null){
            if(viewHolder.avatar.getDrawable() == null){
                if (dsNguoiDung.get(i).isGioiTinh()){
                    viewHolder.avatar.setImageResource(R.drawable.load_avatar_macdinh_nam);
                } else {
                    viewHolder.avatar.setImageResource(R.drawable.load_avatar_macdinh_nu);
                }
            }
        }else Glide.with(context).load(dsNguoiDung.get(i).getHinhAnh()).into(viewHolder.avatar);



        if (dsNguoiDung.get(i).getHoTen().length()<17) {
            viewHolder.hoTen.setText(dsNguoiDung.get(i).getHoTen());
        } else {
            viewHolder.hoTen.setText(dsNguoiDung.get(i).getHoTen().substring(0, 16) + "...");
        }
        if (dsNguoiDung.get(i).getTaiKhoan().length()<17) {
            viewHolder.taiKhoan.setText(dsNguoiDung.get(i).getTaiKhoan());
        } else {
            viewHolder.taiKhoan.setText(dsNguoiDung.get(i).getTaiKhoan().substring(0, 16) + "...");
        }
        if (dsNguoiDung.get(i).getTenHienThi().length()<17) {
            viewHolder.tenHienThi.setText(dsNguoiDung.get(i).getTenHienThi());
        } else {
            viewHolder.tenHienThi.setText(dsNguoiDung.get(i).getTenHienThi().substring(0, 16) + "...");
        }

        if (bacTinCay == 1) {
            viewHolder.doTinCay.setText("Bậc 1");
            viewHolder.doTinCay.setTextColor(Color.parseColor("#F44336"));
        } else if (bacTinCay == 2) {
            viewHolder.doTinCay.setText("Bậc 2");
            viewHolder.doTinCay.setTextColor(Color.parseColor("#FF9800"));
        } else if (bacTinCay == 3) {
            viewHolder.doTinCay.setText("Bậc 3");
            viewHolder.doTinCay.setTextColor(Color.parseColor("#9C27B0"));
        } else if (bacTinCay == 4) {
            viewHolder.doTinCay.setText("Bậc 4");
            viewHolder.doTinCay.setTextColor(Color.parseColor("#2196F3"));
        } else {
            viewHolder.doTinCay.setText("Bậc 5");
            viewHolder.doTinCay.setTextColor(Color.parseColor("#4CAF50"));
        }


        Animation animation = AnimationUtils.loadAnimation(context, R.anim.scale);
        view.startAnimation(animation);

        return view;
    }

    public class ViewHolder{
        CircleImageView avatar;
        TextView hoTen, taiKhoan, tenHienThi, doTinCay;
    }
}
