package com.huydh54.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.huydh54.myapplication.Adapter.BinhLuanAdapter;
import com.huydh54.myapplication.Model.BinhLuan;
import com.huydh54.myapplication.Override.MyListView;
import com.huydh54.myapplication.R;

import java.util.ArrayList;

public class BinhLuanActivity extends AppCompatActivity {

    Toolbar tbBinhLuan;
    MyListView myListView;
    TextView txtThongBao;

    ArrayList<BinhLuan> dsBinhLuan;
    BinhLuanAdapter binhLuanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binh_luan);

        tbBinhLuan = findViewById(R.id.tb_BinhLuan);
        myListView = findViewById(R.id.lv_BinhLuan);
        txtThongBao = findViewById(R.id.txt_ThongBao);

        setSupportActionBar(tbBinhLuan);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tbBinhLuan.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

        dsBinhLuan = new ArrayList<>();
        dsBinhLuan.add(new BinhLuan(0, -1, "", "", 0, 0));
        dsBinhLuan.add(new BinhLuan(0, 1, "", "", 0, 0));
        dsBinhLuan.add(new BinhLuan(0, 0, "Bạn nói quá chuẩn luôn bạn ê. Bạn là nhất rồi.",
                "", 0, 0));
        dsBinhLuan.add(new BinhLuan(0, 0, "Bác nói đúng vãi, tặng 1 like.",
                "", 0, 0));
        dsBinhLuan.add(new BinhLuan(0, 0, "Công ty này làm ăn vớ vẩn, làm mất hàng trị giá mấy " +
                "triệu của mình rồi đòi đền 4 lần phí ship( 120k), mà éo hiểu hộp hàng to thế mà cũng đánh mất được.",
                "", 0, 0));
        dsBinhLuan.add(new BinhLuan(0, 1, "", "", 0, 0));
        dsBinhLuan.add(new BinhLuan(0, 0, "Bác nói đúng vãi, tặng 1 like.",
                "", 0, 0));
        dsBinhLuan.add(new BinhLuan(0, 0, "Bác nói đúng vãi, tặng 1 like.",
                "", 0, 0));
        dsBinhLuan.add(new BinhLuan(0, 0, "Công nhận, làm điều phối mà y như làm phụ kho v. " +
                "Mình là nữ vô làm 1 tuần muốn chạy rồi.",
                "", 0, 0));
        dsBinhLuan.add(new BinhLuan(0, -1, "", "", 0, 0));
        dsBinhLuan.add(new BinhLuan(0, 1, "", "", 0, 0));

        binhLuanAdapter = new BinhLuanAdapter(BinhLuanActivity.this, dsBinhLuan);
        myListView.setAdapter(binhLuanAdapter);
        if (dsBinhLuan.size()>0){
            txtThongBao.setVisibility(View.GONE);
        }else{
            txtThongBao.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_review, menu);
        return true;
    }
}