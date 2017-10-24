package com.ddpl.cipot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IndikatorKemampuanActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvCategory;
    private TextView tvJudul;
    private Button btnKembali;
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indikator_kemampuan);

        tvJudul = (TextView) findViewById(R.id.tv_indikatorJudul);
        btnKembali = (Button) findViewById(R.id.btn_kembaliIndikator);
        btnKembali.setOnClickListener(this);

        rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        final IndikatorAdapter cardViewAdapter = new IndikatorAdapter();
        rvCategory.setAdapter(cardViewAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelected(cardViewAdapter, position);
                Intent detailIndikator = new Intent(IndikatorKemampuanActivity.this, IndikatorKemampuanDetail.class);
                detailIndikator.putExtra(IndikatorKemampuanDetail.hold, cardViewAdapter.text[position]);
                startActivity(detailIndikator);
            }
        });
    }

    private void showSelected(IndikatorAdapter adapter, int position) {
        Toast.makeText(this, "Kamu memilih " + adapter.text[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_kembaliIndikator) {
            Intent back = new Intent(this, HomeSiswaActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(back, 0);
        }
    }
}
