package com.huydh54.myapplication.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.huydh54.myapplication.Fragment.CongTyMoiFragment;
import com.huydh54.myapplication.Fragment.NganhNgheFragment;
import com.huydh54.myapplication.Fragment.TaiKhoanFragment;
import com.huydh54.myapplication.Fragment.TopCongTyFragment;

public class MainViewPager extends FragmentStatePagerAdapter {

    public MainViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TopCongTyFragment();
            case 1:
                return new NganhNgheFragment();
            case 2:
                return new CongTyMoiFragment();
            case 3:
                return new TaiKhoanFragment();
            default:
                return new TopCongTyFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
