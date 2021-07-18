package com.huydh54.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.huydh54.myapplication.ViewPager.MainViewPager;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView menuChanTrang;
    ViewPager khungHienThi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuChanTrang = findViewById(R.id.mnu_MainBottom);
        khungHienThi = findViewById(R.id.vp_Main);

        caiDatKhungMain();

        menuChanTrang.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.topcongty:
                        khungHienThi.setCurrentItem(0);
                        break;
                    case R.id.nganhnghe:
                        khungHienThi.setCurrentItem(1);
                        break;
                    case R.id.congtymoi:
                        khungHienThi.setCurrentItem(2);
                        break;
                    case R.id.taikhoan:
                        khungHienThi.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }

    private void caiDatKhungMain() {
        MainViewPager mainViewPager = new MainViewPager(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        khungHienThi.setAdapter(mainViewPager);

        khungHienThi.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        menuChanTrang.getMenu().getItem(0).setChecked(true);
                        break;
                    case 1:
                        menuChanTrang.getMenu().getItem(1).setChecked(true);
                        break;
                    case 2:
                        menuChanTrang.getMenu().getItem(2).setChecked(true);
                        break;
                    case 3:
                        menuChanTrang.getMenu().getItem(3).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}