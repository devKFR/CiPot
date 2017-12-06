package com.ddpl.cipot;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class GuruHomeActivity extends AppCompatActivity implements View.OnClickListener {

    public static String Nama = "", upDate;
    private Button btnLogout;
    private TextView tvNama;
    private TextView tvTanggal;
    private TextView txtHalamanUtama;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_guru);

        tvNama = (TextView) findViewById(R.id.tv_namaGuru);
        tvTanggal = (TextView) findViewById(R.id.tv_updateGuru);
        txtHalamanUtama = (TextView) findViewById(R.id.txt_halamanUtamaGuru);
        btnLogout = (Button) findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(this);

        tvNama.setText("Eva");
        tvTanggal.setText("Update Terakhir : " + getIntent().getStringExtra(upDate));

        RecyclerView rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);
        rvCategory.setNestedScrollingEnabled(false);
        rvCategory.setFocusable(false);

        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        final SiswaCardAdapter cardViewAdapter = new SiswaCardAdapter(this);
        rvCategory.setAdapter(cardViewAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelected(cardViewAdapter, position);
            }
        });

        setFont();
    }

    private void setFont() {
        String fontPath = LoginMainActivity.fontPath;
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        tvNama.setTypeface(tf);
        tvTanggal.setTypeface(tf);
        txtHalamanUtama.setTypeface(tf);
        btnLogout.setTypeface(tf);
    }


    private void showSelected(SiswaCardAdapter adapter, int position) {
        Toast.makeText(this, "Kamu memilih " + adapter.text[position], Toast.LENGTH_SHORT).show();
        Intent updateData = new Intent(GuruHomeActivity.this, IndikatorKemampuanDetailActivity.class);
        //updateData.putExtra(UpdateDataSiswaActivity.namaSiswaUpdate, adapter.text[position]);
        startActivity(updateData);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent back = new Intent(this, LoginMainActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(back, 0);
        }
    }
}
