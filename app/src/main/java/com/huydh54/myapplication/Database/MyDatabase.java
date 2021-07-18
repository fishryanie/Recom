package com.huydh54.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase(@Nullable Context context) {
                super(context, "LibManaDatabase", null, 1);
            }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table nguoidung" +
                "(_id integer primary key autoincrement," +
                " TaiKhoan text, " +
                " MatKhau text, " +
                " LoaiTaiKhoan integer, " +
                " HinhAnh text, " +
                " HoTen text, " +
                " GioiTinh integer, " +
                " ChucVu text, " +
                " Email text, " +
                " SoDienThoai text, " +
                " TenHienThi text, " +
                " TrangThai integer not null)";
        sqLiteDatabase.execSQL(sql);

        sql = "create table nganh" +
                "(_id integer primary key autoincrement," +
                " HinhAnh text, " +
                " TenNganh text, " +
                " TrangThai integer not null)";
        sqLiteDatabase.execSQL(sql);

        sql = "create table congty" +
                "(_id integer primary key autoincrement," +
                " HinhAnh text, " +
                " TenCongTy text, " +
                " SoLuongNhanVien integer, " +
                " DiaChi text, " +
                " MaNganh integer, " +
                " MaNguoiTao integer, " +
                " TrangThai integer not null, " +
                " foreign key (MaNganh) references nganh(_id)," +
                " foreign key (MaNguoiTao) references nguoidung(_id))";
        sqLiteDatabase.execSQL(sql);

        sql = "create table review" +
                "(_id integer primary key autoincrement," +
                " SoSao text, " +
                " NoiDung text, " +
                " ThoiGian integer, " +
                " MaNguoiDung integer, " +
                " TrangThai integer not null, " +
                " foreign key (MaNguoiDung) references nguoidung(_id))";
        sqLiteDatabase.execSQL(sql);

        sql = "create table binhluan" +
                "(_id integer primary key autoincrement," +
                " TanThanh boolean, " +
                " NoiDung text, " +
                " ThoiGian integer, " +
                " MaReview integer, " +
                " MaNguoiDung integer, " +
                " TrangThai integer not null, " +
                " foreign key (MaReview) references review(_id), " +
                " foreign key (MaNguoiDung) references nguoidung(_id))";
        sqLiteDatabase.execSQL(sql);

        sql = "insert into nguoidung(TaiKhoan, MatKhau, LoaiTaiKhoan, HinhAnh, HoTen, GioiTinh, ChucVu, " +
                "Email, SoDienThoai, TenHienThi, TrangThai)" +
                " values('admin', 'admin', 2, '', 'Đặng Hoàng Huy', 1, 'Admin', 'huydh54@gmail.com', " +
                "'0938364156', 'Đặng Hoàng Huy', 1)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists admin");
        sqLiteDatabase.execSQL("drop table if exists thuthu");
        sqLiteDatabase.execSQL("drop table if exists khachmuon");
        sqLiteDatabase.execSQL("drop table if exists phieumuon");
        sqLiteDatabase.execSQL("drop table if exists loaisach");
        sqLiteDatabase.execSQL("drop table if exists tacgia");
        sqLiteDatabase.execSQL("drop table if exists nhaxuatban");
        sqLiteDatabase.execSQL("drop table if exists sach");
        sqLiteDatabase.execSQL("drop table if exists phieumuon_sach");
        onCreate(sqLiteDatabase);
    }
}
