package com.huydh54.myapplication.Tool;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.huydh54.myapplication.R;

public class ThongBao {
    Context context;

    public ThongBao(Context context) {
        this.context = context;
    }

    public void dialogThongBao(String noiDung) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_thongbao);
        dialog.show();

        Button xacNhan = dialog.findViewById(R.id.btn_XacNhan);
        TextView thongBao = dialog.findViewById(R.id.txt_NoiDung);
        ImageView thoat = dialog.findViewById(R.id.img_Thoat);

        thongBao.setText(noiDung);

        xacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
