package com.huydh54.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.huydh54.myapplication.Database.MyDatabase;
import com.huydh54.myapplication.Model.NguoiDung;

import java.util.ArrayList;

public class NguoiDungDAO {
    MyDatabase myDatabase;

    public NguoiDungDAO(Context context) {
        myDatabase = new MyDatabase(context);
    }

    public ArrayList<NguoiDung> getAll(){
        ArrayList<NguoiDung> dsNguoiDung = new ArrayList<>();
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nguoidung", null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            int ma = c.getInt(0);
            String taiKhoan = c.getString(1);
            String matKhau = c.getString(2);
            int loaiTaiKhoan = c.getInt(3);
            String hinhAnh = c.getString(4);
            String hoTen = c.getString(5);
            boolean gioiTinh = true;
            if (c.getInt(6)==0) {
                gioiTinh = false;
            }
            String chucVu = c.getString(7);
            String email = c.getString(8);
            String soDienThoai = c.getString(9);
            String tenHienThi = c.getString(10);
            int trangThai = c.getInt(11);
            if ((trangThai == 1 && loaiTaiKhoan == 0) || (trangThai == 2 && loaiTaiKhoan == 0)) {
                dsNguoiDung.add(new NguoiDung(ma, taiKhoan, matKhau, loaiTaiKhoan, hinhAnh, hoTen,
                        gioiTinh, chucVu, email, soDienThoai, tenHienThi, trangThai));
            }
            c.moveToNext();
        }
        c.close();
        return dsNguoiDung;
    }
//
//    public ArrayList<NguoiDung> getByStatus(int status){
//        ArrayList<NguoiDung> dsNguoiDung = new ArrayList<>();
//        SQLiteDatabase db = myDatabase.getReadableDatabase();
//        Cursor c = db.rawQuery("select * from nguoidung", null);
//        c.moveToFirst();
//        while (!c.isAfterLast()){
//            int ma = c.getInt(0);
//            String taiKhoan = c.getString(1);
//            String matKhau = c.getString(2);
//            int loaiTaiKhoan = c.getInt(3);
//            String hinhAnh = c.getString(4);
//            String hoTen = c.getString(5);
//            boolean gioiTinh = true;
//            if (c.getInt(6)==0) {
//                gioiTinh = false;
//            }
//            String chucVu = c.getString(7);
//            String email = c.getString(8);
//            String soDienThoai = c.getString(9);
//            String tenHienThi = c.getString(10);
//            int trangThai = c.getInt(11);
//            if (trangThai == status && loaiTaiKhoan == 0) {
//                dsNguoiDung.add(new NguoiDung(ma, taiKhoan, matKhau, loaiTaiKhoan, hinhAnh, hoTen,
//                        gioiTinh, chucVu, email, soDienThoai, tenHienThi),);
//            }
//            c.moveToNext();
//        }
//        c.close();
//        return dsNguoiDung;
//    }

//    public NguoiDung getById(int ma){
//        SQLiteDatabase db = myDatabase.getReadableDatabase();
//        Cursor c = db.rawQuery("select * from nguoidung where _id=?", new String[]{ma+""});
//        c.moveToFirst();
//        String taiKhoan = c.getString(1);
//        String matKhau = c.getString(2);
//        int loaiTaiKhoan = c.getInt(3);
//        String hinhAnh = c.getString(4);
//        String hoTen = c.getString(5);
//        boolean gioiTinh = true;
//        if (c.getInt(6)==0) {
//            gioiTinh = false;
//        }
//        String chucVu = c.getString(7);
//        String email = c.getString(8);
//        String soDienThoai = c.getString(9);
//        String tenHienThi = c.getString(10);
//        NguoiDung nguoiDung = new NguoiDung(ma, taiKhoan, matKhau, loaiTaiKhoan, hinhAnh, hoTen,
//                gioiTinh, chucVu, email, soDienThoai, tenHienThi);
//        c.close();
//        return nguoiDung;
//    }

    public int getStatus(int ma){
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nguoidung where _id=?", new String[]{ma+""});
        c.moveToFirst();
        int trangThai = c.getInt(11);
        c.close();
        return trangThai;
    }

    public void insert(String taiKhoan, String matKhau, int loaiTaiKhoan, String hinhAnh, String hoTen,
                     boolean gioiTinh, String chucVu, String email, String soDienThoai, String tenHienThi) {
        SQLiteDatabase db = myDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TaiKhoan", taiKhoan);
        values.put("MatKhau", matKhau);
        values.put("LoaiTaiKhoan", loaiTaiKhoan);
        values.put("HinhAnh", hinhAnh);
        values.put("HoTen", hoTen);
        values.put("GioiTinh", gioiTinh);
        values.put("ChucVu", chucVu);
        values.put("Email", email);
        values.put("SoDienThoai", soDienThoai);
        values.put("TenHienThi", tenHienThi);
        values.put("TrangThai", 1);
        db.insertOrThrow("nguoidung", null, values);
    }

    public void setStatusById(int maXoa, int trangThai){
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("TrangThai", trangThai);
        db.update("nguoidung", values, "_id=?", new String[]{maXoa+""});
    }

    public void updatePassword(int ma, String matKhauMoi){
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("MatKhau", matKhauMoi);
        db.update("nguoidung", values, "_id=?", new String[]{ma+""});
    }

    public void updateAvatar(int ma, String tenAnh){
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("HinhAnh", tenAnh);
        db.update("nguoidung", values, "_id=?", new String[]{ma+""});
    }

    public ArrayList<String> getUsername(){
        ArrayList<String> dsTenTaiKhoan = new ArrayList<>();
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nguoidung", null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            String taiKhoan = c.getString(1);
            int trangThai = c.getInt(11);
            if (trangThai == 1 || trangThai == 2) {
                dsTenTaiKhoan.add(taiKhoan);
            }
            c.moveToNext();
        }
        c.close();
        return dsTenTaiKhoan;
    }

    public ArrayList<String> getEmail(){
        ArrayList<String> dsEmail = new ArrayList<>();
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nguoidung", null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            String email = c.getString(8);
            int trangThai = c.getInt(11);
            if (trangThai == 1 || trangThai == 2) {
                dsEmail.add(email);
            }
            c.moveToNext();
        }
        c.close();
        return dsEmail;
    }

    public ArrayList<String> getPhoneNumber(){
        ArrayList<String> dsSoDienThoai = new ArrayList<>();
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nguoidung", null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            String soDienThoai = c.getString(9);
            int trangThai = c.getInt(11);
            if (trangThai == 1 || trangThai == 2) {
                dsSoDienThoai.add(soDienThoai);
            }
            c.moveToNext();
        }
        c.close();
        return dsSoDienThoai;
    }

    public int getUserId(int viTri){
        ArrayList<Integer> dsMaNguoiDung = new ArrayList<>();
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nguoidung", null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            int maTam = c.getInt(0);
            int loaiTaiKhoan = c.getInt(3);
            int trangThai = c.getInt(11);
            if ((trangThai == 1 && loaiTaiKhoan == 0) ||
                    (trangThai == 2 && loaiTaiKhoan == 0)) {
                dsMaNguoiDung.add(maTam);
            }
            c.moveToNext();
        }
        c.close();
        return dsMaNguoiDung.get(viTri);
    }

    public int getFavoriteUserId(int viTri){
        ArrayList<Integer> dsMaNguoiDung = new ArrayList<>();
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nguoidung", null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            int maTam = c.getInt(0);
            int loaiTaiKhoan = c.getInt(3);
            int trangThai = c.getInt(11);
            if (trangThai == 2 && loaiTaiKhoan == 0) {
                dsMaNguoiDung.add(maTam);
            }
            c.moveToNext();
        }
        c.close();
        return dsMaNguoiDung.get(viTri);
    }

    public int getDeleteUserId(int viTri){
        ArrayList<Integer> dsMaNguoiDung = new ArrayList<>();
        SQLiteDatabase db = myDatabase.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nguoidung", null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            int maTam = c.getInt(0);
            int loaiTaiKhoan = c.getInt(3);
            int trangThai = c.getInt(11);
            if (trangThai == 0 && loaiTaiKhoan == 0) {
                dsMaNguoiDung.add(maTam);
            }
            c.moveToNext();
        }
        c.close();
        return dsMaNguoiDung.get(viTri);
    }

    public void update(int maCapNhat, String taiKhoan, String matKhau, int loaiTaiKhoan, String hinhAnh, String hoTen,
                       boolean gioiTinh, String chucVu, String email, String soDienThoai, String tenHienThi){
        SQLiteDatabase sqLiteDatabase = myDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TaiKhoan", taiKhoan);
        values.put("MatKhau", matKhau);
        values.put("LoaiTaiKhoan", loaiTaiKhoan);
        values.put("HinhAnh", hinhAnh);
        values.put("HoTen", hoTen);
        values.put("GioiTinh", gioiTinh);
        values.put("ChucVu", chucVu);
        values.put("Email", email);
        values.put("SoDienThoai", soDienThoai);
        values.put("TenHienThi", tenHienThi);
        sqLiteDatabase.update("nguoidung", values, "_id=?", new String[]{maCapNhat+""});
    }
}
