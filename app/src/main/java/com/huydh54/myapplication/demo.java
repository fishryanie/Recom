package com.huydh54.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.huydh54.myapplication.Adapter.Adapter;
import com.huydh54.myapplication.Model.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class demo extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Model> list = new ArrayList<>();
    Adapter adapter;
    String Json_URL = "https://movie0706.cybersoft.edu.vn/api/quanlyphim/laydanhsachphim?maNhom=GP01";
    String url = "http://192.168.1.8:3000/user/getAll";
    String url_acb = "http://192.168.1.8:3000/user/getAll";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        extractData(url);
    }
    public void extractData(String url){
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url_acb, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(getApplicationContext(), "ok" , Toast.LENGTH_SHORT).show();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Model model = new Model();
                        model.setTitle(jsonObject.getString("tenNguoiDung").toString());
                        model.setDetail(jsonObject.getString("taiKhoan").toString());
//                        model.setImage(jsonObject.getString("hinhAnh").toString());

                        list.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false));
                adapter = new Adapter(getApplicationContext(), list);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse" + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);
    }
}