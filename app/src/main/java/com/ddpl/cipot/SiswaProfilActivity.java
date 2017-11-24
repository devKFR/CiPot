package com.ddpl.cipot;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SiswaProfilActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_IdentitasSiswa, txt_NomorAkta, tv_nomorAkta, txt_NamaLengkap, tv_namaLengkap,
            txt_NamaPanggilan, tv_namaPanggilan, txt_TempatLahir, tv_tempatLahir,
            txt_TanggalLahir, tv_tanggalLahir, txt_JenisKelamin, tv_jenisKelamin,
            txt_Agama, tv_agama, txt_AnakKe, tv_anakKe, txt_JumlahSaudara, tv_jumlahSaudara,
            txt_IdentitasOrangtua, txt_NamaAyah, tv_namaAyah, txt_NamaIbu, tv_namaIbu,
            txt_PekerjaanAyah, tv_pekerjaanAyah, txt_PekerjaanIbu, tv_pekerjaanIbu,
            txt_Alamat, tv_alamat;
    Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_siswa);

        btnKembali = (Button) findViewById(R.id.btn_kembaliProfil);
        btnKembali.setOnClickListener(this);

        txt_Agama = (TextView) findViewById(R.id.txt_Agama);
        tv_agama = (TextView) findViewById(R.id.tv_agama);
        txt_Alamat = (TextView) findViewById(R.id.txt_Alamat);
        tv_alamat = (TextView) findViewById(R.id.tv_alamat);
        txt_AnakKe = (TextView) findViewById(R.id.txt_AnakKe);
        tv_anakKe = (TextView) findViewById(R.id.tv_anakKe);
        txt_IdentitasOrangtua = (TextView) findViewById(R.id.txt_IdentitasOrangtua);
        txt_IdentitasSiswa = (TextView) findViewById(R.id.txt_IdentitasSiswa);
        txt_JenisKelamin = (TextView) findViewById(R.id.txt_JenisKelamin);
        tv_jenisKelamin = (TextView) findViewById(R.id.tv_jenisKelamin);
        txt_JumlahSaudara = (TextView) findViewById(R.id.txt_JumlahSaudara);
        tv_jumlahSaudara = (TextView) findViewById(R.id.tv_jumlahSaudara);
        txt_NamaAyah = (TextView) findViewById(R.id.txt_NamaAyah);
        tv_namaAyah = (TextView) findViewById(R.id.tv_namaAyah);
        txt_NamaIbu = (TextView) findViewById(R.id.txt_NamaIbu);
        tv_namaIbu = (TextView) findViewById(R.id.tv_namaIbu);
        txt_NamaLengkap = (TextView) findViewById(R.id.txt_NamaLengkap);
        tv_namaLengkap = (TextView) findViewById(R.id.tv_namaLengkap);
        txt_NamaPanggilan = (TextView) findViewById(R.id.txt_NamaPanggilan);
        tv_namaPanggilan = (TextView) findViewById(R.id.tv_namaPanggilan);
        txt_NomorAkta = (TextView) findViewById(R.id.txt_NomorAkta);
        tv_nomorAkta = (TextView) findViewById(R.id.tv_nomorAkta);
        txt_PekerjaanAyah = (TextView) findViewById(R.id.txt_PekerjaanAyah);
        tv_pekerjaanAyah = (TextView) findViewById(R.id.tv_pekerjaanAyah);
        txt_PekerjaanIbu = (TextView) findViewById(R.id.txt_PekerjaanIbu);
        tv_pekerjaanIbu = (TextView) findViewById(R.id.tv_pekerjaanIbu);
        txt_TanggalLahir = (TextView) findViewById(R.id.txt_TanggalLahir);
        tv_tanggalLahir = (TextView) findViewById(R.id.tv_tanggalLahir);
        txt_TempatLahir = (TextView) findViewById(R.id.txt_TempatLahir);
        tv_tempatLahir = (TextView) findViewById(R.id.tv_tempatLahir);

        setFont();
    }

    private void setFont() {
        String fontPath = LoginMainActivity.fontPath;
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        btnKembali.setTypeface(tf);
        txt_Agama.setTypeface(tf, Typeface.BOLD);
        tv_agama.setTypeface(tf);
        txt_Alamat.setTypeface(tf, Typeface.BOLD);
        tv_alamat.setTypeface(tf);
        txt_AnakKe.setTypeface(tf, Typeface.BOLD);
        tv_anakKe.setTypeface(tf);
        txt_IdentitasOrangtua.setTypeface(tf, Typeface.BOLD);
        txt_IdentitasSiswa.setTypeface(tf, Typeface.BOLD);
        txt_JenisKelamin.setTypeface(tf, Typeface.BOLD);
        tv_jenisKelamin.setTypeface(tf);
        txt_JumlahSaudara.setTypeface(tf, Typeface.BOLD);
        tv_jumlahSaudara.setTypeface(tf);
        txt_NamaAyah.setTypeface(tf, Typeface.BOLD);
        tv_namaAyah.setTypeface(tf);
        txt_NamaIbu.setTypeface(tf, Typeface.BOLD);
        tv_namaIbu.setTypeface(tf);
        txt_NamaLengkap.setTypeface(tf, Typeface.BOLD);
        tv_namaLengkap.setTypeface(tf);
        txt_NamaPanggilan.setTypeface(tf, Typeface.BOLD);
        tv_namaPanggilan.setTypeface(tf);
        txt_NomorAkta.setTypeface(tf, Typeface.BOLD);
        tv_nomorAkta.setTypeface(tf);
        txt_PekerjaanAyah.setTypeface(tf, Typeface.BOLD);
        tv_pekerjaanAyah.setTypeface(tf);
        txt_PekerjaanIbu.setTypeface(tf, Typeface.BOLD);
        tv_pekerjaanIbu.setTypeface(tf);
        txt_TanggalLahir.setTypeface(tf, Typeface.BOLD);
        tv_tanggalLahir.setTypeface(tf);
        txt_TempatLahir.setTypeface(tf, Typeface.BOLD);
        tv_tempatLahir.setTypeface(tf);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_kembaliProfil) {
            Intent back = new Intent(this, SiswaHomeActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(back, 0);
        }
    }
}
