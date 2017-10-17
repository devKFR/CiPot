package com.ddpl.cipot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeSiswaActivity extends AppCompatActivity implements View.OnClickListener{

    public static String Nama, upDate;
    private TextView tvNama, tvTanggal;
    private Button btnProfil, btnIndikator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_siswa);

        tvNama = (TextView)findViewById(R.id.nama_siswa);
        tvTanggal = (TextView)findViewById(R.id.update);
        btnProfil = (Button)findViewById(R.id.btn_profilSiswa);
        btnProfil.setOnClickListener(this);
        btnIndikator = (Button)findViewById(R.id.btn_indikatorSiswa);
        btnIndikator.setOnClickListener(this);

        String nama = getIntent().getStringExtra(Nama);
        String update = getIntent().getStringExtra(upDate);

        tvNama.setText("Nama Siswa :"+nama);
        tvTanggal.setText("Update Terakhir :"+update);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_profilSiswa:
                Intent profil = new Intent(this, ProfilSiswaActivity.class);
                startActivity(profil);
                break;
            case R.id.btn_indikatorSiswa:
                Intent indikator = new Intent(this, IndikatorKemampuanActivity.class);
                startActivity(indikator);
                break;
        }

    }
}
