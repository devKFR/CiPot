package com.ddpl.cipot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeGuruActivity extends AppCompatActivity implements View.OnClickListener {

    public static String Nama, upDate;
    private Button btnLogout;
    private TextView tvNama, tvTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_guru);

        tvNama = (TextView) findViewById(R.id.nama_guru);
        tvTanggal = (TextView) findViewById(R.id.update);
        btnLogout = (Button) findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(this);

        String nama = getIntent().getStringExtra(Nama);
        String update = getIntent().getStringExtra(upDate);

        tvNama.setText("Nama Guru :" + nama);
        tvTanggal.setText("Update Terakhir :" + update);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent back = new Intent(this, MainActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(back, 0);
        }
    }
}
