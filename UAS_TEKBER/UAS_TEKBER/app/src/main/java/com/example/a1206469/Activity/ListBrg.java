package com.example.a1206469.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1206469.API.APIRequestData;
import com.example.a1206469.API.RetroServer;
import com.example.a1206469.Adapter.AdapterData;
import com.example.a1206469.Model.ModelData;
import com.example.a1206469.Model.ResponseModel;
import com.example.a1206469.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBrg extends AppCompatActivity {
    private RecyclerView rv_data;
    private TextView total,jml_data;
    Button btnin;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;

    private List<ModelData> listdata = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_brg);
        rv_data = findViewById(R.id.rv_data);
        total = findViewById(R.id.total);
        jml_data = findViewById(R.id.jml_data);
        btnin = findViewById(R.id.btninput);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rv_data.setLayoutManager(lmData);
        retrieveData();
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListBrg.this, TambahData.class));
            }
        });
    }
    public void retrieveData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardRetrieveData();
        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                int total_brg = response.body().getTotal();
                int dt_count = response.body().getJumlah_data();
                total.setText("Total Harga Rp."+String.valueOf(total_brg));
                jml_data.setText("Jumlah: "+String.valueOf(dt_count));
                if(kode==1){
                    rv_data.setVisibility(View.VISIBLE);
                    Toast.makeText(ListBrg.this, "Kode: "+kode+"| pesan: "+pesan, Toast.LENGTH_SHORT).show();
                    listdata = response.body().getData();
                    adData = new AdapterData(ListBrg.this,listdata);
                    rv_data.setAdapter(adData);
                    adData.notifyDataSetChanged();
                }else{
                    rv_data.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(ListBrg.this, "gagal terhubung ke server"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}