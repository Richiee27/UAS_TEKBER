package com.example.a1206469.Activity;

import androidx.appcompat.app.AppCompatActivity;

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

public class TambahData extends AppCompatActivity {
    private EditText editkd,editnama,editjml,edithrg;
    private Button btnsave;
    private String kd_brg,nama_brg,jumlah,harga;
//    private int jumlah,harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        editkd = findViewById(R.id.editkd);
        editnama = findViewById(R.id.editnama);
        editjml = findViewById(R.id.editjml);
        edithrg = findViewById(R.id.edithrg);
        btnsave = findViewById(R.id.btntambah);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kd_brg = editkd.getText().toString();
                nama_brg = editnama.getText().toString();
                jumlah = editjml.getText().toString();
                harga = edithrg.getText().toString();

                if(kd_brg.trim().equals("")){
                    editkd.setError("Silakan Isi Kode Barang");
                }else if(nama_brg.trim().equals("")){
                    editnama.setError("Silakan Isi Nama Barang");
                }else if(jumlah.trim().equals("")){
                    editjml.setError("Silakan Isi Jumlah Barang");
                }else if(harga.trim().equals("")){
                    edithrg.setError("Silakan Isi Harga Barang");
                }else{
                    createData();
                }

            }
            public void createData(){
                APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
                Call<ResponseModel> simpanData = ardData.ardCreateData(kd_brg,nama_brg,jumlah,harga);
                simpanData.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        int kode = response.body().getKode();
                        String pesan = response.body().getPesan();
                        Toast.makeText(TambahData.this, "kode: "+kode+"| pesan: "+pesan, Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
//                        Toast.makeText(TambahData.this, "Gagal Menghubungi Server: "+t.getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(TambahData.this,ListBrg.class));
                    }
                });
            }

        });



    }
}