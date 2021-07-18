package com.huydh54.myapplication.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.huydh54.myapplication.Adapter.NganhAdapter;
import com.huydh54.myapplication.Model.Nganh;
import com.huydh54.myapplication.R;

import java.util.ArrayList;

public class NganhNgheFragment extends Fragment {

    ListView lvNganh;

    ArrayList<Nganh> dsNganh;
    ArrayList<Integer> soCTList;
    NganhAdapter nganhAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nganh_nghe, container, false);

        lvNganh = view.findViewById(R.id.lv_XemNganh);

        dsNganh = new ArrayList<>();
        dsNganh.add(new Nganh(0, "load_nganh_banle", "Bán lẻ", Color.parseColor("#FFF44336")));
        dsNganh.add(new Nganh(0, "load_nganh_baohiem", "Bảo hiểm", Color.parseColor("#FFE91E63")));
        dsNganh.add(new Nganh(0, "load_nganh_bds", "Bất động sản", Color.parseColor("#FF9C27B0")));
        dsNganh.add(new Nganh(0, "load_nganh_cskh", "Chăm sóc khách hàng", Color.parseColor("#FF673AB7")));
        dsNganh.add(new Nganh(0, "load_nganh_giaoduc", "Giáo dục đào tạo", Color.parseColor("#FF3F51B5")));
        dsNganh.add(new Nganh(0, "load_nganh_it", "Công nghệ thông tin", Color.parseColor("#FF2196F3")));

        soCTList = new ArrayList<>();
        soCTList.add(15);
        soCTList.add(24);
        soCTList.add(33);
        soCTList.add(18);
        soCTList.add(42);
        soCTList.add(31);

        nganhAdapter = new NganhAdapter(view.getContext(), dsNganh, soCTList);
        lvNganh.setAdapter(nganhAdapter);

        return view;
    }
}