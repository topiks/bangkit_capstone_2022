package com.tahufikprojects.richest.main;

import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tahufikprojects.richest.R;
import com.tahufikprojects.richest.utils.Preferences;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import android.content.Intent;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<SawahModel> list;
    Preferences preferences;

    public MyAdapter(Context context, ArrayList<SawahModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_sawah_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SawahModel sawahModel = list.get(position);
        holder.btnSawah.setText(sawahModel.getNama());
        holder.tanggalMulai2.setText(sawahModel.getTanggalMulai());

        preferences = new Preferences(context);


        String pos;
        pos = String.valueOf(position);

        holder.btnSawah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences.setValues("nama_sawah_sekarang", sawahModel.getNama());
//                Log.d("inf", preferences.getValues("nama_sawah_sekarang"));
                startActivity(context);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView namaSawah, tanggalMulai, tanggalMulai2;
        Button btnSawah;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            btnSawah = itemView.findViewById(R.id.btn_list_sawah);
            tanggalMulai2 = itemView.findViewById(R.id.text_mulai_2);
        }
    }

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, HalamanUtamaActivity.class));
    }

}
