package com.ddpl.cipot;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SiswaHomeActivity extends AppCompatActivity implements View.OnClickListener {

    public static String Nama = "", upDate;
    private TextView tvNama, tvTanggal, tvHome;
    private Button btnProfil, btnIndikator, btnLaporan, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_siswa);

        tvNama = (TextView) findViewById(R.id.tv_namaSiswaUpdate);
        tvTanggal = (TextView) findViewById(R.id.tv_updateTerakhirSiswa);
        tvHome = (TextView) findViewById(R.id.txt_HalamanHome);
        btnProfil = (Button)findViewById(R.id.btn_profilSiswa);
        btnProfil.setOnClickListener(this);
        btnIndikator = (Button)findViewById(R.id.btn_indikatorSiswa);
        btnIndikator.setOnClickListener(this);
        btnLaporan = (Button) findViewById(R.id.btn_laporanSiswa);
        btnLaporan.setOnClickListener(this);
        btnLogout = (Button) findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(this);

        String nama = getIntent().getStringExtra(Nama);
        String update = getIntent().getStringExtra(upDate);
        tvNama.setText(nama);
        tvTanggal.setText("Update Terakhir :"+update);

        setFont();
    }

    private void setFont() {
        String fontPath = LoginMainActivity.fontPath;
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        tvNama.setTypeface(tf);
        tvTanggal.setTypeface(tf);
        tvHome.setTypeface(tf);
        btnProfil.setTypeface(tf);
        btnIndikator.setTypeface(tf);
        btnLaporan.setTypeface(tf);
        btnLogout.setTypeface(tf);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_profilSiswa:
                Intent profil = new Intent(this, SiswaProfilActivity.class);
                startActivity(profil);
                break;
            case R.id.btn_indikatorSiswa:
                Intent indikator = new Intent(this, IndikatorKemampuanActivity.class);
                startActivity(indikator);
                break;
            case R.id.btn_laporanSiswa:
                Intent laporan = new Intent(this, SiswaLaporanSemesterActivity.class);
                startActivity(laporan);
                break;
            case R.id.btn_logout:
                FirebaseAuth.getInstance().signOut();
                Intent back = new Intent(this, LoginMainActivity.class);
                back.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(back, 0);
                break;
        }

    }
}
