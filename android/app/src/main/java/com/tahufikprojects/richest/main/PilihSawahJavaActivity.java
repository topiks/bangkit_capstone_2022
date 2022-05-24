package com.tahufikprojects.richest.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.tahufikprojects.richest.R;
import com.tahufikprojects.richest.opening.OnBoardingActivity;
import com.tahufikprojects.richest.utils.Preferences;

import java.util.ArrayList;

public class PilihSawahJavaActivity extends AppCompatActivity{

    LinearLayoutManager mLinearLayoutManager;
    Preferences preferences;

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MyAdapter myAdapter;
    ArrayList<SawahModel> list;

    Button btn_pilih_sawah;
    Button btn_logout;
    FloatingActionButton tambah_data;
    TextView nama_user, jumlah_data;

    int jumlahDataSawah = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_sawah_java);

        preferences = new Preferences(this);
        recyclerView = findViewById(R.id.coba_list);
        databaseReference = FirebaseDatabase.getInstance().getReference("Sawah").child(preferences.getValues("username"));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

        btn_logout = findViewById(R.id.titik_tiga_btn);
        nama_user = findViewById(R.id.name_user_general);
        jumlah_data = findViewById(R.id.belum_ada_data);

        if(preferences.getValues("username").equals("")) {
            finishAffinity();

            Intent intent = new Intent(this, OnBoardingActivity.class);
            startActivity(intent);
        }
        else
            nama_user.setText(preferences.getValues("nama"));

        tambah_data = findViewById(R.id.fab_btn_tambah);
        tambah_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(PilihSawahJavaActivity.this, TambahSawahActivity.class));
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), btn_logout);
                popupMenu.getMenuInflater().inflate(R.menu.popup_logout, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId())
                        {
                            case R.id.menu_logout:
                                preferences.setValues("onboarding", "");
                                preferences.setValues("status", "");
                                preferences.setValues("nama", "");
                                preferences.setValues("email", "");
                                preferences.setValues("username", "");

                                finishAffinity();
                                return true;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    SawahModel sawahModel = dataSnapshot.getValue(SawahModel.class);
                    list.add(sawahModel);
                    jumlahDataSawah = list.size();
                    jumlah_data.setVisibility(View.INVISIBLE);
                }

                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



}