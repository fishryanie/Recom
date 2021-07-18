package com.huydh54.myapplication.Tool;

import android.content.Context;
import android.widget.EditText;

import com.huydh54.myapplication.DAO.NguoiDungDAO;
import com.huydh54.myapplication.Model.NguoiDung;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class KiemTra {
    Context context;
    NguoiDungDAO nguoiDungDAO;

    public KiemTra(Context context) {
        this.context = context;
        nguoiDungDAO = new NguoiDungDAO(context);
    }

    public boolean kiemTraRong(EditText...dsTruong){
        boolean ketQua = true;
        for (EditText truong : dsTruong) {
            if (truong.getText().toString().isEmpty()) {
                ketQua = false;
                break;
            }
        }
        return ketQua;
    }

    public boolean kiemTraTenTaiKhoan(String taiKhoan){
        ArrayList<String> dsTaiKhoan = nguoiDungDAO.getUsername();
        boolean ketQua = true;
        for (int j=0; j<dsTaiKhoan.size(); j++) {
            if (dsTaiKhoan.get(j).equals(taiKhoan)) {
                ketQua = false;
                break;
            }
        }
        return ketQua;
    }

    public boolean dinhDangEmail(String email){
        boolean ketQua;
        String EMAIL_PATTERN = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (pattern.matcher(email).matches()) {
            ketQua = true;
        } else {
            ketQua = false;
        }
        return ketQua;
    }

    public boolean kiemTraEmail(String email){
        ArrayList<String> dsEmail = nguoiDungDAO.getEmail();
        boolean ketQua = true;
        for (int j=0; j<dsEmail.size(); j++) {
            if (dsEmail.get(j).equals(email)) {
                ketQua = false;
                break;
            }
        }
        return ketQua;
    }

    public boolean kiemTraSDT(String soDienThoai){
        ArrayList<String> dsSoDienThoai = nguoiDungDAO.getPhoneNumber();
        boolean ketQua = true;
        for (int j=0; j<dsSoDienThoai.size(); j++) {
            if (dsSoDienThoai.get(j).equals(soDienThoai)) {
                ketQua = false;
                break;
            }
        }
        return ketQua;
    }
}
