package com.huydh54.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.huydh54.myapplication.Adapter.CongTyAdapter;
import com.huydh54.myapplication.Adapter.ReviewAdapter;
import com.huydh54.myapplication.Model.CongTy;
import com.huydh54.myapplication.R;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    Toolbar tbReview;
    ListView lvReview;

    ArrayList<CongTy> dsCongTy;
    ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        tbReview = findViewById(R.id.tb_Review);

        setSupportActionBar(tbReview);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tbReview.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

        lvReview = findViewById(R.id.lv_Review);

        dsCongTy = new ArrayList<>();
        dsCongTy.add(new CongTy(0, "load_logo_unilever", "Unilever Việt Nam",
                "1000+", "Quận 7, Tp. Hồ Chí Minh", 0, 0));
        dsCongTy.add(new CongTy(0, "load_logo_fsoft", "FPT Software",
                "1000+", "Quận 9, Tp. Hồ Chí Minh", 0, 0));
        dsCongTy.add(new CongTy(0, "load_logo_lozi", "Lozi Việt Nam",
                "51-150", "Quận 10, Tp. Hồ Chí Minh", 0, 0));
        dsCongTy.add(new CongTy(0, "load_logo_tiki", "Tiki Corporation",
                "1000+", "Q. Tân Bình, Tp. Hồ Chí Minh", 0, 0));
        dsCongTy.add(new CongTy(0, "load_logo_acb", "Ngân hàng Á Châu | ACB",
                "1000+", "Quận 3, Tp. Hồ Chí Minh", 0, 0));
        reviewAdapter = new ReviewAdapter(ReviewActivity.this, dsCongTy);
        lvReview.setAdapter(reviewAdapter);

        lvReview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), BinhLuanActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_review, menu);
        return true;
    }
}