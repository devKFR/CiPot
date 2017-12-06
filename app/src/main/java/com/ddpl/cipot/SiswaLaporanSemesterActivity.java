package com.ddpl.cipot;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SiswaLaporanSemesterActivity extends AppCompatActivity {

    private String[] semester = {
            "Semester I", "Semester II", "Semester III", "Semester IV"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_semester);

        final TextView tvTahun = (TextView) findViewById(R.id.tv_tahunSemester);
        final TextView tvBerat = (TextView) findViewById(R.id.tv_beratBadan);
        final TextView tvTinggi = (TextView) findViewById(R.id.tv_tinggiBadan);

        Spinner spSemester = (Spinner) findViewById(R.id.sp_semester);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, semester);

        spSemester.setAdapter(adapter);

        spSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String semester = adapter.getItem(position);
                Toast.makeText(SiswaLaporanSemesterActivity.this, "Selected " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                tvTahun.setText(semester);
                tvBerat.setText("Berat Badan Pada " + semester);
                tvTinggi.setText("Tinggi Badan Pada " + semester);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
