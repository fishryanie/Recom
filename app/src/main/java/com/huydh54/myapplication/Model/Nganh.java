package com.huydh54.myapplication.Model;

public class Nganh {
    private int maNganh;
    private String hinhAnh;
    private String tenNganh;
    private int mauSac;

    public Nganh(int maNganh, String hinhAnh, String tenNganh, int mauSac) {
        this.maNganh = maNganh;
        this.hinhAnh = hinhAnh;
        this.tenNganh = tenNganh;
        this.mauSac = mauSac;
    }

    public int getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(int maNganh) {
        this.maNganh = maNganh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public int getMauSac() {
        return mauSac;
    }

    public void setMauSac(int mauSac) {
        this.mauSac = mauSac;
    }
}
