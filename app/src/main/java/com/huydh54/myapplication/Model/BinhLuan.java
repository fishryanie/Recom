package com.huydh54.myapplication.Model;

public class BinhLuan {
    private int maBinhLuan;
    private int loai;
    private String noiDung;
    private String thoiGian;
    private int maReview;
    private int maNguoiDung;

    public BinhLuan(int maBinhLuan, int loai, String noiDung, String thoiGian, int maReview, int maNguoiDung) {
        this.maBinhLuan = maBinhLuan;
        this.loai = loai;
        this.noiDung = noiDung;
        this.thoiGian = thoiGian;
        this.maReview = maReview;
        this.maNguoiDung = maNguoiDung;
    }

    public int getMaBinhLuan() {
        return maBinhLuan;
    }

    public void setMaBinhLuan(int maBinhLuan) {
        this.maBinhLuan = maBinhLuan;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getMaReview() {
        return maReview;
    }

    public void setMaReview(int maReview) {
        this.maReview = maReview;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }
}
