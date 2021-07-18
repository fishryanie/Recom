package com.huydh54.myapplication.Model;

public class NguoiDung {
    private int maNguoiDung;
    private String hoTen;
    private String tenHienThi;
    private String taiKhoan;
    private String matKhau;
    private int loaiTaiKhoan;
    private String hinhAnh;
    private boolean gioiTinh;
    private String chucVu;
    private String email;
    private String soDienThoai;
    private int luotReview;
    private int tongTanThanh;
    private int tongPhanDoi;
    private int trangThai;

    public NguoiDung(){

    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public NguoiDung(int maNguoiDung, String taiKhoan, String matKhau, int loaiTaiKhoan, String hinhAnh,
                     String hoTen, boolean gioiTinh, String chucVu, String email, String soDienThoai,
                     String tenHienThi, int luotReview, int tongTanThanh, int tongPhanDoi) {
        this.maNguoiDung = maNguoiDung;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.loaiTaiKhoan = loaiTaiKhoan;
        this.hinhAnh = hinhAnh;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.tenHienThi = tenHienThi;
        this.luotReview = luotReview;
        this.tongTanThanh = tongTanThanh;
        this.tongPhanDoi = tongPhanDoi;
    }

    public NguoiDung(int maNguoiDung, String taiKhoan, String matKhau, int loaiTaiKhoan, String hinhAnh,
                     String hoTen, boolean gioiTinh, String chucVu, String email, String soDienThoai,
                     String tenHienThi, int trangThai) {
        this.maNguoiDung = maNguoiDung;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.loaiTaiKhoan = loaiTaiKhoan;
        this.hinhAnh = hinhAnh;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.tenHienThi = tenHienThi;
        this.trangThai = trangThai;
        this.luotReview = 0;
        this.tongTanThanh = 0;
        this.tongPhanDoi = 0;


    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(int loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTenHienThi() {
        return tenHienThi;
    }

    public void setTenHienThi(String tenHienThi) {
        this.tenHienThi = tenHienThi;
    }

    public int getLuotReview() {
        return luotReview;
    }

    public void setLuotReview(int luotReview) {
        this.luotReview = luotReview;
    }

    public int getTongTanThanh() {
        return tongTanThanh;
    }

    public void setTongTanThanh(int tongTanThanh) {
        this.tongTanThanh = tongTanThanh;
    }

    public int getTongPhanDoi() {
        return tongPhanDoi;
    }

    public void setTongPhanDoi(int tongPhanDoi) {
        this.tongPhanDoi = tongPhanDoi;
    }
}
