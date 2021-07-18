package com.huydh54.myapplication.Model;

public class ChucNangEdit {
    private int hinh;
    private String tieuDe;
    private String noiDung;
    private boolean chinhSua;

    public ChucNangEdit(int hinh, String tieuDe, String noiDung, boolean chinhSua) {
        this.hinh = hinh;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.chinhSua = chinhSua;
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

    public boolean isChinhSua() {
        return chinhSua;
    }

    public void setChinhSua(boolean chinhSua) {
        this.chinhSua = chinhSua;
    }
}
