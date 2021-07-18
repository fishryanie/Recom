package com.huydh54.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.huydh54.myapplication.Activity.ReviewActivity;
import com.huydh54.myapplication.Adapter.CongTyAdapter;
import com.huydh54.myapplication.Model.CongTy;
import com.huydh54.myapplication.R;

import java.util.ArrayList;

public class CongTyMoiFragment extends Fragment {

    ListView lvCongTy;

    ArrayList<CongTy> dsCongTy;
    CongTyAdapter congTyAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cong_ty_moi, container, false);

        lvCongTy = view.findViewById(R.id.lv_CongTyMoi);

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
        congTyAdapter = new CongTyAdapter(view.getContext(), dsCongTy);
        lvCongTy.setAdapter(congTyAdapter);

        return view;
    }
}