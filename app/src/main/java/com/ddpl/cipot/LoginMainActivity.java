package com.ddpl.cipot;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginMainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String login = "", fontPath = "font/DidactGothic-Regular.ttf";
    private EditText edt_noInduk, edt_tanggal;
    private String ID = "", date;
    private Button btn_login;
    private TextView txtPAUD, txtAlamat, txtSelamat;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    if (ID.equals("1")) {
                        login = "Siswa";
                        Intent login = new Intent(LoginMainActivity.this, SiswaHomeActivity.class);
                        login.putExtra(SiswaHomeActivity.Nama, ID);
                        login.putExtra(SiswaHomeActivity.upDate, date);
                        startActivity(login);
                    }
                    if (ID.equals("2")) {
                        login = "Guru";
                        Intent login = new Intent(LoginMainActivity.this, GuruHomeActivity.class);
                        login.putExtra(GuruHomeActivity.Nama, ID);
                        login.putExtra(GuruHomeActivity.upDate, date);
                        startActivity(login);
                    }
                }
            }
        };

        edt_noInduk = (EditText)findViewById(R.id.nomor_induk);
        edt_tanggal = (EditText)findViewById(R.id.tanggal_lahir);
        txtPAUD = (TextView) findViewById(R.id.txt_PusatPAUD);
        txtAlamat = (TextView) findViewById(R.id.txt_AlamatPAUD);
        txtSelamat = (TextView) findViewById(R.id.txt_SelamatDatang);

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        setFont();
    }

    private void setFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        txtPAUD.setTypeface(tf);
        txtAlamat.setTypeface(tf);
        txtSelamat.setTypeface(tf);
        edt_noInduk.setTypeface(tf);
        edt_tanggal.setTypeface(tf);
        btn_login.setTypeface(tf);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_login){
            loginFirebase();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void loginFirebase() {
        ID = edt_noInduk.getText().toString().trim();
        date = edt_tanggal.getText().toString().trim();
        boolean isEmptyFields = false;
        if (TextUtils.isEmpty(ID)) {
            isEmptyFields = true;
            edt_noInduk.setError("Masukkan nomor identitas");
        }
        if (TextUtils.isEmpty(date)) {
            isEmptyFields = true;
            edt_tanggal.setError("Masukkan tanggal lahir");
        }
        if (!isEmptyFields) {
            mAuth.signInWithEmailAndPassword(ID + "@a.com", date).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(LoginMainActivity.this, "Profil tidak ditemukan, mohon cek kembali nomor identitas dan tanggal lahir", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    public void loginLama() {
        boolean isEmptyFields = false;
        ID = edt_noInduk.getText().toString().trim();
        date = edt_tanggal.getText().toString().trim();
        if (TextUtils.isEmpty(ID)) {
            isEmptyFields = true;
            edt_noInduk.setError("Masukkan nomor identitas");
        }
        if (TextUtils.isEmpty(date)) {
            isEmptyFields = true;
            edt_tanggal.setError("Masukkan tanggal lahir");
        }
        if (!isEmptyFields) {
            if (ID.equals(date)) {
                Intent login = new Intent(this, SiswaHomeActivity.class);
                login.putExtra(SiswaHomeActivity.Nama, ID);
                login.putExtra(SiswaHomeActivity.upDate, date);
                startActivity(login);
            } else {
                Toast.makeText(this, "Profil tidak ditemukan, mohon cek kembali nomor identitas dan tanggal lahir", Toast.LENGTH_LONG).show();
            }
        }
    }
}
