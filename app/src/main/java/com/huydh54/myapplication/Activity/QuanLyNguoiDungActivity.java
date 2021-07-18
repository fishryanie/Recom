package com.huydh54.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.huydh54.myapplication.Action.Action;
import com.huydh54.myapplication.Action.Action_User;
import com.huydh54.myapplication.Adapter.Adapter;
import com.huydh54.myapplication.Adapter.QuanLyNguoiDungAdapter;
import com.huydh54.myapplication.DAO.NguoiDungDAO;
import com.huydh54.myapplication.Model.Model;
import com.huydh54.myapplication.Model.NguoiDung;
import com.huydh54.myapplication.R;
import com.huydh54.myapplication.Tool.KiemTra;
import com.huydh54.myapplication.Tool.MatKhau;
import com.huydh54.myapplication.Tool.ThongBao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuanLyNguoiDungActivity extends AppCompatActivity {

    Toolbar tbNguoiDung;
    ListView lvNguoiDung;
    TextView txtTitle;

    ArrayList<NguoiDung> listUser_GetAll = new ArrayList<>();
    ArrayList<NguoiDung> listUser_Favorite = new ArrayList<>();
    ArrayList<NguoiDung> listUser_Trash = new ArrayList<>();


    ThongBao thongBao = new ThongBao(QuanLyNguoiDungActivity.this);

    private int loaiDanhSach;

    RadioButton rdoNam;
    RadioButton rdoNu;

    String URL_getall = "http://192.168.1.3:8000/user/getall";
    String URL_getTrash = "http://192.168.1.3:8000/user/getTrash";
    String URL_getFavorite = "http://192.168.1.3:8000/user/getFavorite";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_nguoi_dung);

        anhXa();

        setToolbar();

        RenderListUser(URL_getall);
        RenDerListFavorite(URL_getFavorite);
        RenDerListTrash(URL_getTrash);

        detailClick();

    }

    // ====================   Get all user by API server  ===============================>
    private void RenderListUser(String URL){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        listUser_GetAll.add(
                                new NguoiDung(
                                        jsonObject.getInt("maNguoiDung"),
                                        jsonObject.getString("taiKhoan"),
                                        jsonObject.getString("matKhau"), 1,
                                        jsonObject.getString("hinhAnh"),
                                        jsonObject.getString("tenNguoiDung"),
//                                        true ? jsonObject.getInt("gioiTinh") == 0 : false,
                                        true,
                                        jsonObject.getString("chucVu"),
                                        jsonObject.getString("email"),
                                        jsonObject.getString("soDienThoai"),
                                        jsonObject.getString("tenHienThi"),
                                        jsonObject.getInt("trangThai")
                                )
                        );
                    } catch (JSONException e) {e.printStackTrace();}
                }
                loadList(listUser_GetAll);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse" + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);

    }


    // ====================   Get all user favorite by API server  ======================>
    private void RenDerListFavorite(String URL) {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        listUser_Favorite.add(
                                new NguoiDung(
                                        jsonObject.getInt("maNguoiDung"),
                                        jsonObject.getString("taiKhoan"),
                                        jsonObject.getString("matKhau"), 1,
                                        jsonObject.getString("hinhAnh"),
                                        jsonObject.getString("tenNguoiDung"),
                                        true ? jsonObject.getInt("gioiTinh") == 0 : false,
                                        jsonObject.getString("chucVu"),
                                        jsonObject.getString("email"),
                                        jsonObject.getString("soDienThoai"),
                                        jsonObject.getString("tenHienThi"),
                                        jsonObject.getInt("trangThai")
                                )
                        );
                    } catch (JSONException e) {e.printStackTrace();}
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse" + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }


    // ====================   Get all user trash by API server  =========================>
    public void RenDerListTrash(String URL) {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL , null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        listUser_Trash.add(
                                new NguoiDung(
                                        jsonObject.getInt("maNguoiDung"),
                                        jsonObject.getString("taiKhoan"),
                                        jsonObject.getString("matKhau"), 1,
                                        jsonObject.getString("hinhAnh"),
                                        jsonObject.getString("tenNguoiDung"),
                                        true ? jsonObject.getInt("gioiTinh") == 0 : false,
                                        jsonObject.getString("chucVu"),
                                        jsonObject.getString("email"),
                                        jsonObject.getString("soDienThoai"),
                                        jsonObject.getString("tenHienThi"),
                                        jsonObject.getInt("trangThai")
                                )
                        );
                    } catch (JSONException e) {e.printStackTrace();}
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse" + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }


    // ====================   Load danh sách  ===========================================>
    private void loadList(ArrayList arrayList) {
        QuanLyNguoiDungAdapter nguoiDungAdapter = new QuanLyNguoiDungAdapter(QuanLyNguoiDungActivity.this, arrayList);
        lvNguoiDung.setAdapter(nguoiDungAdapter);
    }


    // ========================   Click item  ===========================================>
    private void detailClick(){
        lvNguoiDung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(loaiDanhSach == 0){
                    PopupMenu popupMenu = new PopupMenu(QuanLyNguoiDungActivity.this, view.findViewById(R.id.txt_TenND));
                    popupMenu.inflate(R.menu.menu_thungrac);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            return menuItemClicked(item);
                        }
                    });
                    popupMenu.show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), ChiTietNguoiDungActivity.class);
                    intent.putExtra("maNguoiDung", listUser_GetAll.get(position).getMaNguoiDung());
                    startActivity(intent);
                }
                ;
            }
        });
    }


    // =========================   Ánh xạ  ==============================================>
    private void anhXa() {
        tbNguoiDung = findViewById(R.id.tb_QuanLyNguoiDung);
        lvNguoiDung = findViewById(R.id.lv_NguoiDung);
        txtTitle = findViewById(R.id.txt_Title);
        loaiDanhSach = 1;
    }

    // =========================  Tool bar  ==============================================>
    private void setToolbar() {
        setSupportActionBar(tbNguoiDung);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbNguoiDung.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_quanly, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.them:
//                them();
                return true;
            case R.id.danhsachtong:
                txtTitle.setText("Danh sách người dùng");
                loadList(listUser_GetAll);
                loaiDanhSach = 2;
                return true;
            case R.id.yeuthich:
                txtTitle.setText("Yêu thích");
                loadList(listUser_Favorite);
                loaiDanhSach = 1;
                return true;
            case R.id.thungrac:
                txtTitle.setText("Thùng rác");
                loadList(listUser_Trash);
                loaiDanhSach = 0;
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

//    private void them() {
//        Dialog dialog = new Dialog(QuanLyNguoiDungActivity.this);
//        dialog.setContentView(R.layout.dialog_themnguoidung);
//        dialog.show();
//
//        ImageView imgThoat = dialog.findViewById(R.id.img_Thoat);
//        EditText edtTaiKhoan = dialog.findViewById(R.id.edt_TaiKhoan);
//        TextView txtMatKhau = dialog.findViewById(R.id.txt_MatKhau);
//        EditText edtHoTen = dialog.findViewById(R.id.edt_HoTen);
//        rdoNam = dialog.findViewById(R.id.rdo_Nam);
//        rdoNu = dialog.findViewById(R.id.rdo_Nu);
//        EditText edtChucVu = dialog.findViewById(R.id.edt_ChucVu);
//        EditText edtEmail = dialog.findViewById(R.id.edt_Email);
//        EditText edtSoDienThoai = dialog.findViewById(R.id.edt_SoDienThoai);
//        Button btnThemMoi = dialog.findViewById(R.id.btn_ThemMoi);
//
//        rdoNam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                setColorRadioButton();
//            }
//        });
//        rdoNu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                setColorRadioButton();
//            }
//        });
//
//        MatKhau matKhau = new MatKhau();
//        KiemTra kiemTra = new KiemTra(QuanLyNguoiDungActivity.this);
//
//        String matKhauTuDong = matKhau.taoMatKhau() + "";
//        txtMatKhau.setText(matKhauTuDong);
//
//        imgThoat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//
//        btnThemMoi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!kiemTra.kiemTraRong(edtTaiKhoan, edtHoTen, edtChucVu, edtEmail, edtSoDienThoai)) {
//                    thongBao.dialogThongBao("Vui lòng nhập đủ thông tin!");
//                } else if (!kiemTra.kiemTraTenTaiKhoan(edtTaiKhoan.getText().toString())) {
//                    thongBao.dialogThongBao("Tên tài khoản đã tồn tại!");
//                } else if (!kiemTra.dinhDangEmail(edtEmail.getText().toString())) {
//                    thongBao.dialogThongBao("Email không đúng định dạng!");
//                } else if (!kiemTra.kiemTraEmail(edtEmail.getText().toString())) {
//                    thongBao.dialogThongBao("Email đã được đăng ký!");
//                } else if (edtSoDienThoai.getText().toString().length()<10) {
//                    thongBao.dialogThongBao("Số điện thoại phải gồm 10 hoặc 11 số!");
//                } else if (!kiemTra.kiemTraSDT(edtSoDienThoai.getText().toString())) {
//                    thongBao.dialogThongBao("Số điện thoại đã được đăng ký!");
//                } else {
//                    boolean gioiTinh;
//                    if(rdoNam.isChecked()){
//                        gioiTinh = true;
//                    }else {
//                        gioiTinh = false;
//                    }
//                    nguoiDungDAO.insert(
//                            edtTaiKhoan.getText().toString(),
//                            txtMatKhau.getText().toString(),
//                            0,
//                            "",
//                            edtHoTen.getText().toString(),
//                            gioiTinh,
//                            edtChucVu.getText().toString(),
//                            edtEmail.getText().toString(),
//                            edtSoDienThoai.getText().toString(),
//                            edtHoTen.getText().toString()
//                    );
//                    thongBao.dialogThongBao("Thêm mới khách mượn thành công! Mật khẩu là " + txtMatKhau.getText().toString());
//
//                    danhSachTong();
//                    dialog.dismiss();
//                }
//            }
//        });
//    }


//    private void setColorRadioButton() {
//        if(rdoNam.isChecked()){
//            rdoNam.setTextColor(Color.parseColor("#EFEFEF"));
//            rdoNu.setTextColor(Color.parseColor("#3186CF"));
//        }else{
//            rdoNu.setTextColor(Color.parseColor("#EFEFEF"));
//            rdoNam.setTextColor(Color.parseColor("#3186CF"));
//        }
//    }
//

    private boolean menuItemClicked(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.restore: khoiPhuc(); break;
            case R.id.delete: xoaVinhVien(); break;
            default: Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show(); break;
        } return true;
    }

    private void khoiPhuc() {

    }

    private void xoaVinhVien() {

    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 001 && resultCode==RESULT_OK){
//            dsNguoiDung = nguoiDungDAO.getAll();
////            loadList();
//            thongBao.dialogThongBao("Danh sách người dùng đã được cập nhật!");
//        }
//    }
}