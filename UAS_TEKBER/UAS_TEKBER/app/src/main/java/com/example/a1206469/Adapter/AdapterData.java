package com.example.a1206469.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1206469.Model.ModelData;
import com.example.a1206469.R;
import com.example.a1206469.Activity.UpdateData;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<ModelData> listdata;
    private String kdBrg;

    public AdapterData(Context ctx, List<ModelData> listdata) {
        this.ctx = ctx;
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.format_tampilan_brg,parent,
                false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        ModelData dm = listdata.get(position);
        holder.kd.setText(dm.getKd_brg());
        holder.nama.setText(dm.getNama_brg());
        holder.jml.setText(String.valueOf(dm.getJumlah()));
        holder.daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UpdateData.class);
                intent.putExtra("kode_brg",dm.getKd_brg());
                intent.putExtra("nama_brg",dm.getNama_brg());
                intent.putExtra("jumlah",String.valueOf(dm.getJumlah()));
                intent.putExtra("harga",String.valueOf(dm.getHarga()));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView kd,nama,jml;
        LinearLayout daftar;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            kd = itemView.findViewById(R.id.kd);
            nama = itemView.findViewById(R.id.nama);
            jml = itemView.findViewById(R.id.jml);
            daftar = itemView.findViewById(R.id.daftar);

        }
    }
}
