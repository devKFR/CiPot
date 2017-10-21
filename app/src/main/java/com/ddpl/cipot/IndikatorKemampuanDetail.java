package com.ddpl.cipot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IndikatorKemampuanDetail extends AppCompatActivity {

    public static String hold;

    IndikatorExpandableAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indikator_kemampuan_detail);

        TextView judul = (TextView) findViewById(R.id.tv_kemampuanJudul);
        judul.setText(getIntent().getStringExtra(hold));

        expListView = (ExpandableListView) findViewById(R.id.el_kemampuan);
        prepareListData();
        listAdapter = new IndikatorExpandableAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Membedakan Rasa di " + getIntent().getStringExtra(hold));
        listDataHeader.add("Merespon Bau di " + getIntent().getStringExtra(hold));
        listDataHeader.add("Membedakan Bau di " + getIntent().getStringExtra(hold));

        // Adding child data
        List<String> membedakanRasa = new ArrayList<String>();
        membedakanRasa.add("Menyebutkan rasa asin dan manis di " + getIntent().getStringExtra(hold));
        membedakanRasa.add("Menyebutkan rasa lainnya di " + getIntent().getStringExtra(hold));

        List<String> meresponBau = new ArrayList<String>();
        meresponBau.add("Berpaling dari bau tidak sedap di " + getIntent().getStringExtra(hold));
        meresponBau.add("Berusaha menghindari bau tidak sedap di " + getIntent().getStringExtra(hold));

        List<String> membedakanBau = new ArrayList<String>();
        membedakanBau.add("Menyebut bau wangi di " + getIntent().getStringExtra(hold));
        membedakanBau.add("Menyebut nama benda yang bau di " + getIntent().getStringExtra(hold));

        listDataChild.put(listDataHeader.get(0), membedakanRasa); // Header, Child data
        listDataChild.put(listDataHeader.get(1), meresponBau);
        listDataChild.put(listDataHeader.get(2), membedakanBau);
    }
}
