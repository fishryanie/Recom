package com.huydh54.myapplication.Model;

public class ChucNang {
    private int hinh;
    private String tieuDe;
    private String noiDung;

    public ChucNang(int hinh, String tieuDe, String noiDung) {
        this.hinh = hinh;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
