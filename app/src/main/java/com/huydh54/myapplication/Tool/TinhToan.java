package com.huydh54.myapplication.Tool;

public class TinhToan {
    public int tinhDoTinCay(int tongTanThanh, int tongPhanDoi){
        int ketQua = 0;
        if (tongTanThanh+tongPhanDoi<10){
            ketQua = 3;
        } else if (tongTanThanh>=10 && tongPhanDoi==0){
            ketQua = 5;
        } else if (tongTanThanh==0 && tongPhanDoi>=10){
            ketQua = 1;
        } else {
            double tiLe = tongTanThanh/(double)tongPhanDoi;
            if (tiLe<0.5){
                ketQua = 1;
            } else if (tiLe>=0.5 && tiLe<1){
                ketQua = 2;
            } else if (tiLe>=1 && tiLe<1.5){
                ketQua = 3;
            } else if (tiLe>=1.5 && tiLe<2){
                ketQua = 4;
            } else if (tiLe>=2){
                ketQua = 5;
            }
        }
        return ketQua;
    }
}
