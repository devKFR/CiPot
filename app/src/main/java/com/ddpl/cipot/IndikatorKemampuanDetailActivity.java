package com.ddpl.cipot;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 10/11/2017.
 */

public class IndikatorKemampuanDetailActivity extends AppCompatActivity implements View.OnClickListener, SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    public static String hold;

    private SearchView search;
    private IndikatorExpandableAdapter indikatorExpandableAdapter;
    private ExpandableListView expListView;
    private ArrayList<IndikatorLv1> indikatorLv1List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indikator_kemampuan_detail);

        Button btnkembali = (Button) findViewById(R.id.btn_kembaliIndikatorDetail);
        btnkembali.setOnClickListener(this);

        TextView judul = (TextView) findViewById(R.id.tv_kemampuanJudul);
        judul.setText(getIntent().getStringExtra(hold));

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search = (SearchView) findViewById(R.id.search_indikator);
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);

        displayList();

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "a", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_kembaliIndikatorDetail) {
            Intent back = new Intent(this, IndikatorKemampuanActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(back, 0);
        }
    }

    private void expandAll() {
        int count = indikatorExpandableAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            expListView.expandGroup(i);
        }
    }

    private void displayList() {
        // display the list
        loadData();
        // get reference to the ExpandableListView
        expListView = (ExpandableListView) findViewById(R.id.el_kemampuan);
        // create the adapter by passing your ArrayList data
        indikatorExpandableAdapter = new IndikatorExpandableAdapter(this, indikatorLv1List);
        // attach the adapter to the list
        expListView.setAdapter(indikatorExpandableAdapter);

    }

    private void loadData() {
        IndikatorLv1 indikatorLv1;
        IndikatorLv2 indikatorLv2;

        ArrayList<IndikatorLv2> indikatorLv2List = new ArrayList<>();
        indikatorLv2 = new IndikatorLv2("3.1.1.1", "Menyebutkan rasa asin dan manis di " + getIntent().getStringExtra(hold));
        indikatorLv2List.add(indikatorLv2);
        indikatorLv2 = new IndikatorLv2("3.1.1.1", "Menyebutkan rasa lainnya di " + getIntent().getStringExtra(hold));
        indikatorLv2List.add(indikatorLv2);

        indikatorLv1 = new IndikatorLv1("3.1.1", "Membedakan Rasa di " + getIntent().getStringExtra(hold), indikatorLv2List);
        indikatorLv1List.add(indikatorLv1);

        indikatorLv2List = new ArrayList<>();
        indikatorLv2 = new IndikatorLv2("3.1.1.1", "Berpaling dari bau tidak sedap di " + getIntent().getStringExtra(hold));
        indikatorLv2List.add(indikatorLv2);
        indikatorLv2 = new IndikatorLv2("3.1.1.1", "Berusaha menghindari bau tidak sedap di " + getIntent().getStringExtra(hold));
        indikatorLv2List.add(indikatorLv2);

        indikatorLv1 = new IndikatorLv1("3.1.2", "Merespon Bau di " + getIntent().getStringExtra(hold), indikatorLv2List);
        indikatorLv1List.add(indikatorLv1);

        indikatorLv2List = new ArrayList<>();
        indikatorLv2 = new IndikatorLv2("3.1.1.1", "Menyebut bau wangi di " + getIntent().getStringExtra(hold));
        indikatorLv2List.add(indikatorLv2);
        indikatorLv2 = new IndikatorLv2("3.1.1.1", "Menyebut nama benda yang bau di " + getIntent().getStringExtra(hold));
        indikatorLv2List.add(indikatorLv2);

        indikatorLv1 = new IndikatorLv1("3.1.3", "Membedakan Bau di " + getIntent().getStringExtra(hold), indikatorLv2List);
        indikatorLv1List.add(indikatorLv1);
    }

    @Override
    public boolean onClose() {
        indikatorExpandableAdapter.filterData("");
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        indikatorExpandableAdapter.filterData(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        indikatorExpandableAdapter.filterData(newText);
        return false;
    }
}
