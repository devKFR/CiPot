package com.ddpl.cipot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateDataSiswaActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvCategory;
    private Button btnTambahLaporan, btnKembali;
    private TextView tvNama, tvTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_siswa);

        btnKembali = (Button) findViewById(R.id.btn_kembaliUpdateDataSiswa);
        btnKembali.setOnClickListener(this);

        rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        final IndikatorCardAdapter cardViewAdapter = new IndikatorCardAdapter();
        rvCategory.setAdapter(cardViewAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelected(cardViewAdapter, position);
                /*Intent detailIndikator = new Intent(IndikatorKemampuanActivity.this, IndikatorKemampuanDetailActivity.class);
                detailIndikator.putExtra(IndikatorKemampuanDetailActivity.hold, cardViewAdapter.text[position]);
                startActivity(detailIndikator);*/
            }
        });
    }

    private void showSelected(IndikatorCardAdapter adapter, int position) {
        Toast.makeText(this, "Kamu memilih " + adapter.text[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_kembaliUpdateDataSiswa) {
            Intent back = new Intent(this, GuruHomeActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(back, 0);
        }
    }
}
