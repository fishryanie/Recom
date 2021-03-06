package com.huydh54.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.huydh54.myapplication.Adapter.TruongQuanLyAdapter;
import com.huydh54.myapplication.DAO.NguoiDungDAO;
import com.huydh54.myapplication.Model.ChucNang;
import com.huydh54.myapplication.Model.ChucNangEdit;
import com.huydh54.myapplication.Model.NguoiDung;
import com.huydh54.myapplication.Override.MyListView;
import com.huydh54.myapplication.R;
import com.huydh54.myapplication.Tool.MatKhau;
import com.huydh54.myapplication.Tool.ThongBao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.function.Function;

public class ChiTietNguoiDungActivity extends AppCompatActivity {

    Toolbar tbChiTietNguoiDung;
    ImageView imgAvatar;
    TextView txtHoTen, txtLuotReview, txtTanThanh, txtPhanDoi;
    Button btnUpdate, btnRemove, btnResetPass;
    EditText edtTaiKhoan, edtLoaiTaiKhoan, edtHoTen, edtTenHienThi, edtGioiTinh, edtChucVu, edtEmail, edtSoDienThoai;

    boolean check = false;
    NguoiDungDAO nguoiDungDAO;
    int maNguoiDung;
    NguoiDung nguoiDung;
    ThongBao thongBao;
    MatKhau matKhau;

    String loaiTaiKhoan;
    String gioiTinh;
    int imgID;
    boolean capNhat = false;

    ArrayList<NguoiDung> listDetailUser = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_nguoi_dung);
//        nhanThongTin();
        anhXa();
//        setAvatar();
//        setThongSo();
//        setThongTin();
        setToolbar();
//        setButton();

        getDetailData();


    }

//    private void setThongTin() {
//        //Set lo???i t??i kho???n
//        if (nguoiDung.getLoaiTaiKhoan() == 0) loaiTaiKhoan = "C?? b???n";
//        else if (nguoiDung.getLoaiTaiKhoan() == 1) loaiTaiKhoan = "Nh??n vi??n";
//        else loaiTaiKhoan = "Admin";
//
//        edtTaiKhoan.setText(nguoiDung.getTaiKhoan());
//        edtLoaiTaiKhoan.setText(loaiTaiKhoan);
//        edtHoTen.setText(nguoiDung.getHoTen());
//        edtTenHienThi.setText(nguoiDung.getTenHienThi());
//        edtGioiTinh.setText(nguoiDung.isGioiTinh() ? "Name" : "N???");
//        edtChucVu.setText(nguoiDung.getChucVu());
//        edtEmail.setText(nguoiDung.getEmail());
//        edtSoDienThoai.setText(nguoiDung.getSoDienThoai());
//    }

    public void getDetailData(){
        int maNguoiDung = getIntent().getIntExtra("maNguoiDung",0);
        Toast.makeText(getApplicationContext(),maNguoiDung+"",Toast.LENGTH_SHORT).show();
        String URL = "http://192.168.1.3:8000/user/detail/" + maNguoiDung;
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                    try {
                        Toast.makeText(getApplicationContext(), "ok" , Toast.LENGTH_SHORT).show();
                        edtTaiKhoan.setText(response.getString("taiKhoan"));
                        edtLoaiTaiKhoan.setText( response.getInt("loaiNguoiDung") == 0 ? "C?? b???n" : response.getInt("loaiNguoiDung") == 1 ? "Nh??n Vi??n" : "Admin");
                        txtHoTen.setText(response.getString("tenNguoiDung"));

                        // S??t avata
                        setAvata(response.getString("hinhAnh"),response.getInt("gioiTinh"));

                        edtHoTen.setText(response.getString("tenNguoiDung"));
                        edtTenHienThi.setText( response.getString("tenHienThi"));
                        edtChucVu.setText(response.getString("chucVu"));

                        edtGioiTinh.setText(response.getInt("gioiTinh") == 0 ? "Nam": "N???");

                        edtEmail.setText(response.getString("email"));
                        edtSoDienThoai.setText(response.getString("soDienThoai"));
                    } catch (JSONException e) {e.printStackTrace();}
                }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "onErrorResponse" + error.getMessage() , Toast.LENGTH_SHORT).show();
                Log.d("tag", "onErrorResponse" + error.getMessage());
            }
        });
        queue.add(jsonObjectRequest);
    }

    private void setAvata(String hinhAnh, int gioiTinh){
        try {
            if (hinhAnh.isEmpty()){
                if(gioiTinh == 0) imgAvatar.setImageResource(R.drawable.load_avatar_macdinh_nam);
                else imgAvatar.setImageResource(R.drawable.load_avatar_macdinh_nu);
            }
            else Glide.with(getApplicationContext()).load(hinhAnh).into(imgAvatar);
        }catch (Exception e){
            if(gioiTinh == 0) imgAvatar.setImageResource(R.drawable.load_avatar_macdinh_nam);
            else imgAvatar.setImageResource(R.drawable.load_avatar_macdinh_nu);
        }
    }


    private void anhXa() {
        tbChiTietNguoiDung = findViewById(R.id.tb_ChiTietNguoiDung);
        imgAvatar = findViewById(R.id.img_Avatar);
        txtHoTen = findViewById(R.id.txt_HoTenTop);
        txtLuotReview = findViewById(R.id.txt_LuotReview);
        txtTanThanh = findViewById(R.id.txt_TanThanh);
        txtPhanDoi = findViewById(R.id.txt_PhanDoi);
        btnUpdate = findViewById(R.id.btn_Update);
        btnRemove = findViewById(R.id.btn_Remove);
        btnResetPass = findViewById(R.id.btn_ResetPass);

        edtTaiKhoan = findViewById(R.id.edt_NDTaiKhoan);
        edtLoaiTaiKhoan = findViewById(R.id.edt_NDLoaiTaiKhoan);
        edtHoTen = findViewById(R.id.edt_NDHoTen);
        edtTenHienThi = findViewById(R.id.edt_NDTenHienThi);
        edtGioiTinh = findViewById(R.id.edt_NDGioiTinh);
        edtChucVu = findViewById(R.id.edt_NDChucVu);
        edtEmail = findViewById(R.id.edt_NDEmail);
        edtSoDienThoai = findViewById(R.id.edt_NDSoDienThoai);

//        nguoiDungDAO = new NguoiDungDAO(ChiTietNguoiDungActivity.this);
//        nguoiDung = nguoiDungDAO.getById(maNguoiDung);
//        thongBao = new ThongBao(ChiTietNguoiDungActivity.this);
//        matKhau = new MatKhau();
    }

    private void setToolbar() {
        setSupportActionBar(tbChiTietNguoiDung);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        tbChiTietNguoiDung.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                thoat();
//            }
//        });
//        if (nguoiDungDAO.getStatus(maNguoiDung) == 2) {
//            check = true;
//        }
    }

    private void thoat() {
        if (kiemTra()) {
//            dialogXacNhan(1);
        } else {
            if (capNhat) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        }
    }
    private void hoanThanh() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chitietnguoidung, menu);
        if (check == true) {
            menu.getItem(0).setIcon(R.drawable.ic_save_fill);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.luu:
                if (!check) {
                    item.setIcon(R.drawable.ic_save_fill);
                    check = true;
                    nguoiDungDAO.setStatusById(maNguoiDung, 2);
                    thongBao.dialogThongBao("???? l??u ng?????i d??ng v??o danh s??ch y??u th??ch!");
                } else {
                    item.setIcon(R.drawable.ic_save_line);
                    check = false;
                    nguoiDungDAO.setStatusById(maNguoiDung, 1);
                    thongBao.dialogThongBao("???? x??a ng?????i d??ng kh???i danh s??ch y??u th??ch!");
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    private void setAvatar() {
////        imgID = ChiTietNguoiDungActivity.this.getResources().getIdentifier(
////                nguoiDung.getHinhAnh(),
////                "drawable",
////                ChiTietNguoiDungActivity.this.getPackageName()
////        );
////        try {
////            imgAvatar.setImageResource(imgID);
////        }catch (Exception e){
////            if (nguoiDung.isGioiTinh()){
////                imgAvatar.setImageResource(R.drawable.load_avatar_macdinh_nam);
////            } else {
////                imgAvatar.setImageResource(R.drawable.load_avatar_macdinh_nu);
////            }
////        }
////        if(imgAvatar.getDrawable() == null){
////            if (nguoiDung.isGioiTinh()){
////                imgAvatar.setImageResource(R.drawable.load_avatar_macdinh_nam);
////            } else {
////                imgAvatar.setImageResource(R.drawable.load_avatar_macdinh_nu);
////            }
////        }
//    }

    private void setThongSo() {
        txtHoTen.setText(nguoiDung.getHoTen());
        txtLuotReview.setText(nguoiDung.getLuotReview()+"");
        txtTanThanh.setText(nguoiDung.getTongTanThanh()+"");
        txtPhanDoi.setText(nguoiDung.getTongPhanDoi()+"");
    }



//    private void setButton() {
//        btnRemove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialogXacNhan(0);
//            }
//        });
//
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!kiemTra()) {
//                    thongBao.dialogThongBao("D??? li???u kh??ng thay ?????i!");
//                } else {
//                    dialogXacNhan(2);
//                }
//            }
//        });
//
//        btnResetPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialogXacNhan(3);
//            }
//        });
//    }

//    private void dialogXacNhan(int truongHop) {
//        Dialog dialog = new Dialog(ChiTietNguoiDungActivity.this);
//        dialog.setContentView(R.layout.dialog_xoa);
//        dialog.show();
//
//        TextView tieuDeXoa = dialog.findViewById(R.id.txt_TieuDeXoa);
//        TextView noiDungXoa = dialog.findViewById(R.id.txt_NoiDungXoa);
//        Button xacNhan = dialog.findViewById(R.id.btn_XacNhanXoa);
//        Button huy = dialog.findViewById(R.id.btn_HuyXoa);
//        ImageView thoat = dialog.findViewById(R.id.img_ThoatXoa);
//
//        if (truongHop == 0) {
//            noiDungXoa.setText("B???n ch???c ch???n mu???n x??a ng?????i d??ng n??y?");
//        }
//        if (truongHop == 1) {
//            noiDungXoa.setText("C?? thay ?????i ch??a ???????c l??u. B???n v???n mu???n tho??t?");
//            tieuDeXoa.setText("X??c nh???n tho??t");
//            xacNhan.setText("Tho??t");
//        }
//        if (truongHop == 2) {
//            noiDungXoa.setText("B???n mu???n c???p nh???t ng?????i d??ng n??y?");
//            tieuDeXoa.setText("X??c nh???n c???p nh???t");
//            xacNhan.setText("????ng");
//        }
//
//        if (truongHop == 3) {
//            noiDungXoa.setText("B???n mu???n ?????t l???i m???t kh???u cho ng?????i d??ng n??y?");
//            tieuDeXoa.setText("X??c nh???n c???p nh???t");
//            xacNhan.setText("????ng");
//        }
//
//        xacNhan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//                if (truongHop == 0) {
//                    nguoiDungDAO.setStatusById(maNguoiDung, 0);
//                    hoanThanh();
//                }
//                if (truongHop == 1) {
//                    Intent intent = new Intent();
//                    setResult(RESULT_CANCELED, intent);
//                    finish();
//                }
//                if (truongHop == 2) {
////                    capNhat();
//                }
//                if (truongHop == 3) {
//                    resetPass();
//                }
//            }
//        });
//
//        huy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ChiTietNguoiDungActivity.this, "Thao t??c b??? h???y!", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
//
//        thoat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//    }

    public void onBackPressed() {
        thoat();
    }

    public boolean kiemTra() {
        boolean coThayDoi = false;
        if (!edtTaiKhoan.getText().toString().equals(nguoiDung.getTaiKhoan()) ||
                !edtLoaiTaiKhoan.getText().toString().equals(loaiTaiKhoan) ||
                !edtHoTen.getText().toString().equals(nguoiDung.getHoTen()) ||
                !edtTenHienThi.getText().toString().equals(nguoiDung.getTenHienThi()) ||
                !edtGioiTinh.getText().toString().equals(gioiTinh) ||
                !edtChucVu.getText().toString().equals(nguoiDung.getChucVu()) ||
                !edtEmail.getText().toString().equals(nguoiDung.getEmail()) ||
                !edtSoDienThoai.getText().toString().equals(nguoiDung.getSoDienThoai())){
            coThayDoi = true;
        }
        return coThayDoi;
    }

//    private void capNhat() {
//        int loaiTaiKhoanCN;
//        boolean gioiTinhCN;
//        if (edtLoaiTaiKhoan.getText().toString().equals("C?? b???n")) {
//            loaiTaiKhoanCN = 0;
//            loaiTaiKhoan = "C?? b???n";
//        } else if (edtLoaiTaiKhoan.getText().toString().equals("Nh??n vi??n")) {
//            loaiTaiKhoanCN = 1;
//            loaiTaiKhoan = "Nh??n vi??n";
//        } else {
//            loaiTaiKhoanCN = 2;
//            loaiTaiKhoan = "Admin";
//        }
//
//        if (edtGioiTinh.getText().toString().equals("Nam")) {
//            gioiTinhCN = true;
//            gioiTinh = "Nam";
//        } else {
//            gioiTinhCN = false;
//            gioiTinh = "N???";
//
//        }
//        nguoiDungDAO.update(
//                maNguoiDung,
//                edtTaiKhoan.getText().toString(),
//                nguoiDung.getMatKhau(),
//                loaiTaiKhoanCN,
//                nguoiDung.getHinhAnh(),
//                edtHoTen.getText().toString(),
//                gioiTinhCN,
//                edtChucVu.getText().toString(),
//                edtEmail.getText().toString(),
//                edtSoDienThoai.getText().toString(),
//                edtTenHienThi.getText().toString()
//        );
//        capNhat = true;
//        nguoiDung = nguoiDungDAO.getById(maNguoiDung);
//        txtHoTen.setText(nguoiDung.getHoTen());
//    }

//    private void resetPass() {
//        String newPass = matKhau.taoMatKhau();
//        nguoiDungDAO.updatePassword(maNguoiDung, newPass);
//        thongBao.dialogThongBao("?????t l???i m???t kh???u th??nh c??ng. M???t kh???u m???i l?? " + newPass);
//    }
}