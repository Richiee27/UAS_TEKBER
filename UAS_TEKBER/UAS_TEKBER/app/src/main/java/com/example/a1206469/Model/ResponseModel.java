package com.example.a1206469.Model;

import java.util.List;

public class ResponseModel {
    private int kode,total,jumlah_data;
    private String pesan;
    private List <ModelData> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getJumlah_data() {
        return jumlah_data;
    }

    public void setJumlah_data(int jumlah_data) {
        this.jumlah_data = jumlah_data;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<ModelData> getData() {
        return data;
    }

    public void setData(List<ModelData> data) {
        this.data = data;
    }
}
