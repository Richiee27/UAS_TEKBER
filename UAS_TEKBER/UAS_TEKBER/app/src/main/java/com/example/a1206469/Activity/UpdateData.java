package com.example.a1206469.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1206469.API.APIRequestData;
import com.example.a1206469.API.RetroServer;
import com.example.a1206469.Model.ResponseModel;
import com.example.a1206469.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateData extends AppCompatActivity implements View.OnClickListener {
    EditText Ekd,Enama,Eharga,Ejml;
    Button btnhapus,btnupdate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getIntent().getExtras();
        setContentView(R.layout.activity_update_data);
        Ekd = findViewById(R.id.editkd);
        Enama = findViewById(R.id.editnama);
        Eharga = findViewById(R.id.edithrg);
        Ejml = findViewById(R.id.editjml);
        btnhapus = findViewById(R.id.btnhps);
        btnupdate = findViewById(R.id.btnupdate);
        Ekd.setText(bundle.getString("kode_brg"));
        Ekd.setEnabled(false);
        Enama.setText(bundle.getString("nama_brg"));
        Eharga.setText(bundle.getString("harga"));
        Ejml.setText(bundle.getString("jumlah"));
        btnhapus.setOnClickListener(this);
        btnupdate.setOnClickListener(this);

        }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnhps:
                Bundle bundle=getIntent().getExtras();
                APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
                Call<ResponseModel> hapusData = ardData.ardDeleteData(bundle.getString("kode_brg"));
                hapusData.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        int kode = response.body().getKode();
                        String pesan = response.body().getPesan();
                        Toast.makeText(UpdateData.this, "kode: "+kode+"| pesan: "+pesan, Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
//                        Toast.makeText(UpdateData.this, "Gagal Menghubungi Server: "+t.getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UpdateData.this,ListBrg.class));
                    }
                });
                break;
            case R.id.btnupdate:
                APIRequestData ardUpdate = RetroServer.konekRetrofit().create(APIRequestData.class);
                Call<ResponseModel> updateData = ardUpdate.ardUpdate(Ekd.getText().toString(),Enama.getText().toString(),
                        Ejml.getText().toString(),Eharga.getText().toString());
                updateData.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        int kode = response.body().getKode();
                        String pesan = response.body().getPesan();
                        Toast.makeText(UpdateData.this, "kode: "+kode+"| pesan: "+pesan, Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        startActivity(new Intent(UpdateData.this,ListBrg.class));
                    }
                });
                break;


        }
    }
}