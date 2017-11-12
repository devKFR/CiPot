package com.ddpl.cipot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SiswaProfilActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_siswa);

        Button btnkembali = (Button) findViewById(R.id.btn_kembaliProfil);
        btnkembali.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_kembaliProfil) {
            Intent back = new Intent(this, SiswaHomeActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(back, 0);
        }
    }
}
