package com.ddpl.cipot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_noInduk, edt_tanggal;
    private String ID, date;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_noInduk = (EditText)findViewById(R.id.nomor_induk);
        edt_tanggal = (EditText)findViewById(R.id.tanggal_lahir);

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_login){
            boolean isEmptyFields = false;
            ID = edt_noInduk.getText().toString().trim();
            date = edt_tanggal.getText().toString().trim();
            if(TextUtils.isEmpty(ID)){
                isEmptyFields=true;
                edt_noInduk.setError("Masukkan nomor identitas");
            }
            if(TextUtils.isEmpty(date)){
                isEmptyFields=true;
                edt_tanggal.setError("Masukkan tanggal lahir");
            }
            if (!isEmptyFields) {
                if(ID.equals(date)){
                    int IDmod = Integer.parseInt(ID)*3;
                    Intent login = new Intent(this, HomeSiswaActivity.class);
                    login.putExtra(HomeSiswaActivity.Nama, IDmod);
                    login.putExtra(HomeSiswaActivity.upDate, date);
                    startActivity(login);
                }
                else{
                    Toast.makeText(this, "Profil tidak ditemukan, mohon cek kembali nomor identitas dan tanggal lahir", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
