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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by user on 10/11/2017.
 */

public class IndikatorKemampuanDetailActivity extends AppCompatActivity implements View.OnClickListener, SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    public static String hold;
    public static ArrayList<String> key = new ArrayList<>();

    private Context context = this;
    private SearchView search;
    private IndikatorExpandableAdapter indikatorExpandableAdapter;
    private ExpandableListView expListView;
    private ArrayList<IndikatorLv1> indikatorLv1List = new ArrayList<>();
    private ArrayList<IndikatorLv2> indikatorLv2List = new ArrayList<>();
    private ArrayList<IndikatorLv2> indikatorLv2141 = new ArrayList<>();
    private ArrayList<IndikatorLv2> indikatorLv2212 = new ArrayList<>();
    private ArrayList<IndikatorLv2> indikatorLv2325 = new ArrayList<>();
    private DatabaseReference indikatorLv1DB, indikatorLv2DB;

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
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_kembaliIndikatorDetail) {
            if (LoginMainActivity.login.equals("Siswa")) {
                Intent back = new Intent(this, SiswaHomeActivity.class);
                back.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(back, 0);
            } else {
                Intent back = new Intent(this, GuruHomeActivity.class);
                back.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(back, 0);
            }
        }
    }

    private void expandAll() {
        int count = indikatorExpandableAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            expListView.expandGroup(i);
        }
    }

    private void displayList() {
        indikatorLv1DB = FirebaseDatabase.getInstance().getReference().child("Indikator");
        indikatorLv2DB = FirebaseDatabase.getInstance().getReference().child("Subindikator");
        indikatorLv1DB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                IndikatorLv1 indikatorLv1;
                indikatorLv2DB.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        IndikatorLv2 indikatorLv2;
                        for (DataSnapshot indikator2 : dataSnapshot.getChildren()) {
                            key.add(indikator2.getKey());
                            indikatorLv2 = indikator2.getValue(IndikatorLv2.class);
                            indikatorLv2.setId(indikator2.getValue(IndikatorLv2.class).getId());
                            String id = indikator2.getValue(IndikatorLv2.class).getId().substring(0, 5);
                            if (id.equalsIgnoreCase("1.4.1")) {
                                indikatorLv2141.add(indikatorLv2);
                            }
                            if (id.equalsIgnoreCase("2.1.2")) {
                                indikatorLv2212.add(indikatorLv2);
                            }
                            if (id.equalsIgnoreCase("3.2.5")) {
                                indikatorLv2325.add(indikatorLv2);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                for (DataSnapshot indikator1 : dataSnapshot.getChildren()) {
                    indikatorLv1 = indikator1.getValue(IndikatorLv1.class);
                    indikatorLv1.setId(indikator1.getValue(IndikatorLv1.class).getId());
                    indikatorLv1.setNama(indikator1.getValue(IndikatorLv1.class).getNama());
                    String id = indikator1.getValue(IndikatorLv1.class).getId().substring(0, 5);
                    if (id.equalsIgnoreCase("1.4.1")) {
                        indikatorLv1.setLv2List(indikatorLv2141);
                    }
                    if (id.equalsIgnoreCase("2.1.2")) {
                        indikatorLv1.setLv2List(indikatorLv2212);
                    }
                    if (id.equalsIgnoreCase("3.2.5")) {
                        indikatorLv1.setLv2List(indikatorLv2325);
                    }
                    indikatorLv1List.add(indikatorLv1);
                }
                sendToArrayList();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void sendToArrayList() {
        expListView = (ExpandableListView) findViewById(R.id.el_kemampuan);
        // create the adapter by passing your ArrayList data
        indikatorExpandableAdapter = new IndikatorExpandableAdapter(context, indikatorLv1List);
        // attach the adapter to the list
        expListView.setAdapter(indikatorExpandableAdapter);
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
        expandAll();
        return false;
    }
}
