package com.huydh54.myapplication.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.huydh54.myapplication.Activity.BinhLuanActivity;
import com.huydh54.myapplication.Activity.QuanLyNguoiDungActivity;
import com.huydh54.myapplication.Adapter.TaiKhoanAdapter;
import com.huydh54.myapplication.Model.ChucNang;
import com.huydh54.myapplication.R;
import com.huydh54.myapplication.demo;

import java.util.ArrayList;

public class TaiKhoanFragment extends Fragment {

    ListView lvChucNang;
    GridView gvChucNang;

    TaiKhoanAdapter taiKhoanListAdapter;
    ArrayList<ChucNang> chucNangList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tai_khoan, container, false);

        gvChucNang = view.findViewById(R.id.gv_ChucNang);
        chucNangList = new ArrayList<>();

        addDuLieu();

        taiKhoanListAdapter = new TaiKhoanAdapter(getContext(), chucNangList, 1);
        gvChucNang.setAdapter(taiKhoanListAdapter);

        gvChucNang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 3) startActivity(new Intent(view.getContext(), QuanLyNguoiDungActivity.class));
                if (i == 4) startActivity(new Intent(view.getContext(), demo.class));
            }
        });

        return view;
    }

    private void addDuLieu() {
        chucNangList.add(new ChucNang(R.drawable.load_taikhoan_chucnang_danhgia, "Phản hồi", "Chưa đánh giá"));
        chucNangList.add(new ChucNang(R.drawable.load_taikhoan_chucnang_hotro, "Hỗ trợ", "0938364156"));
        chucNangList.add(new ChucNang(R.drawable.load_taikhoan_chucnang_phienban, "Phiên bản", "v1.0.0"));
        chucNangList.add(new ChucNang(R.drawable.load_taikhoan_chucnang_nguoidung, "Quản lý", "Người dùng"));
        chucNangList.add(new ChucNang(R.drawable.load_taikhoan_chucnang_nguoidung, "demoAPI", "get data"));
    }
}