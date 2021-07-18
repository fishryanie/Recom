package com.huydh54.myapplication.Tool;

import java.util.Random;

public class MatKhau {
    private static final char[] CHU_HOA = { 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private static final char[] CHU_THUONG = { 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public String taoMatKhau(){
        Random random = new Random();
        String matKhau = (random.nextInt((999999 - 100000) + 1) + 100000) + "";
        int viTriHoa = random.nextInt(6);
        matKhau = matKhau.substring(0, viTriHoa) + CHU_HOA[random.nextInt(CHU_HOA.length)] +
                matKhau.substring(viTriHoa);
        int viTriThuong = random.nextInt(7);
        matKhau = matKhau.substring(0, viTriThuong) + CHU_THUONG[random.nextInt(CHU_THUONG.length)] +
                matKhau.substring(viTriThuong);
        return matKhau;
    }

}
