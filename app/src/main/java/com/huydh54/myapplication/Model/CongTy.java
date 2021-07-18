package com.huydh54.myapplication.Model;

public class CongTy {
    private int maCongTy;
    private String hinhAnh;
    private String tenCongTy;
    private String soLuongNhanVien;
    private String diaChi;
    private int maNganh;
    private int maNguoiTao;

    public CongTy(int maCongTy, String hinhAnh, String tenCongTy, String soLuongNhanVien, String diaChi, int maNganh, int maNguoiTao) {
        this.maCongTy = maCongTy;
        this.hinhAnh = hinhAnh;
        this.tenCongTy = tenCongTy;
        this.soLuongNhanVien = soLuongNhanVien;
        this.diaChi = diaChi;
        this.maNganh = maNganh;
        this.maNguoiTao = maNguoiTao;
    }

    public int getMaCongTy() {
        return maCongTy;
    }

    public void setMaCongTy(int maCongTy) {
        this.maCongTy = maCongTy;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getSoLuongNhanVien() {
        return soLuongNhanVien;
    }

    public void setSoLuongNhanVien(String soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(int maNganh) {
        this.maNganh = maNganh;
    }

    public int getMaNguoiTao() {
        return maNguoiTao;
    }

    public void setMaNguoiTao(int maNguoiTao) {
        this.maNguoiTao = maNguoiTao;
    }
}
