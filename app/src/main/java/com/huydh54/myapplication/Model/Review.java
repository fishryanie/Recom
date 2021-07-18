package com.huydh54.myapplication.Model;

public class Review {
    private int maReview;
    private int soSao;
    private String noiDung;
    private String thoiGian;
    private int maNguoiDung;

    public Review(int maReview, int soSao, String noiDung, String thoiGian, int maNguoiDung) {
        this.maReview = maReview;
        this.soSao = soSao;
        this.noiDung = noiDung;
        this.thoiGian = thoiGian;
        this.maNguoiDung = maNguoiDung;
    }

    public int getMaReview() {
        return maReview;
    }

    public void setMaReview(int maReview) {
        this.maReview = maReview;
    }

    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(int soSao) {
        this.soSao = soSao;
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

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }
}
