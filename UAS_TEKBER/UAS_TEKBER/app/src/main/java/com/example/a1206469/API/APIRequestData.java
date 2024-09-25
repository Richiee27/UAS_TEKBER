package com.example.a1206469.API;

import com.example.a1206469.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> ardCreateData(
            @Field("kd_brg") String kd_brg,
            @Field("nama_brg") String nama_brg,
            @Field("jumlah") String jumlah,
            @Field("harga") String harga
    );
    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> ardDeleteData(
            @Field("kd_brg") String kd_brg
    );
    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> ardUpdate(
            @Field("kd_brg") String kd_brg,
            @Field("nama_brg") String nama_brg,
            @Field("jumlah") String jumlah,
            @Field("harga") String harga
    );
}
