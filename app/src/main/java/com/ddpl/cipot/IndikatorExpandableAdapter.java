package com.ddpl.cipot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class IndikatorExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<IndikatorLv1> indikatorLv1List, originalList;

    IndikatorExpandableAdapter(Context context, ArrayList<IndikatorLv1> indikatorLv1List) {
        this.context = context;
        this.indikatorLv1List = new ArrayList<>();
        this.indikatorLv1List.addAll(indikatorLv1List);
        this.originalList = new ArrayList<>();
        this.originalList.addAll(indikatorLv1List);
    }

    @Override
    public int getGroupCount() {
        return indikatorLv1List.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<IndikatorLv2> indikatorLv2List = indikatorLv1List.get(groupPosition).getLv2List();
        return indikatorLv2List.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return indikatorLv1List.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<IndikatorLv2> indikatorLv2List = indikatorLv1List.get(groupPosition).getLv2List();
        return indikatorLv2List.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String fontPath = LoginMainActivity.fontPath;
        Typeface tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        IndikatorLv1 indikatorLv1 = (IndikatorLv1) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (layoutInflater != null) {
                convertView = layoutInflater.inflate(R.layout.expandable_header, null);
            }
        }

        TextView heading = (TextView) (convertView != null ? convertView.findViewById(R.id.tv_namaHeader) : null);
        TextView headingID = (TextView) (convertView != null ? convertView.findViewById(R.id.tv_idHeader) : null);
        if (heading != null) {
            heading.setTypeface(tf, Typeface.BOLD);
        }
        if (headingID != null) {
            headingID.setTypeface(tf, Typeface.BOLD);
        }
        if (heading != null) {
            heading.setText(indikatorLv1.getNama().trim());
        }
        if (headingID != null) {
            headingID.setText(indikatorLv1.getId().trim());
        }

        return convertView;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final DatabaseReference indikatorLv2DB = FirebaseDatabase.getInstance().getReference().child("Subindikator");
        String fontPath = LoginMainActivity.fontPath;
        Typeface tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        final IndikatorLv2 indikatorLv2 = (IndikatorLv2) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater != null ? layoutInflater.inflate(R.layout.expandable_child, null) : null;
        }

        TextView txtListChild = (TextView) (convertView != null ? convertView.findViewById(R.id.tv_detailChild) : null);
        TextView idChild = (TextView) (convertView != null ? convertView.findViewById(R.id.tv_idChild) : null);
        if (txtListChild != null) {
            txtListChild.setText(indikatorLv2.getNama().trim());
        }
        if (idChild != null) {
            idChild.setText(indikatorLv2.getId().trim());
        }

        final Button btnSimpan = (Button) (convertView != null ? convertView.findViewById(R.id.btn_simpan) : null);
        final ToggleButton toggleButton0 = (ToggleButton) (convertView != null ? convertView.findViewById(R.id.toggle0) : null);
        final ToggleButton toggleButton1 = (ToggleButton) (convertView != null ? convertView.findViewById(R.id.toggle1) : null);
        final ToggleButton toggleButton2 = (ToggleButton) (convertView != null ? convertView.findViewById(R.id.toggle2) : null);
        final ToggleButton toggleButton3 = (ToggleButton) (convertView != null ? convertView.findViewById(R.id.toggle3) : null);
        final TextView tvToogle0 = (TextView) (convertView != null ? convertView.findViewById(R.id.tv_toggle0) : null);
        final TextView tvToogle1 = (TextView) (convertView != null ? convertView.findViewById(R.id.tv_toggle1) : null);
        final TextView tvToogle2 = (TextView) (convertView != null ? convertView.findViewById(R.id.tv_toggle2) : null);
        final TextView tvToogle3 = (TextView) (convertView != null ? convertView.findViewById(R.id.tv_toggle3) : null);
        if (tvToogle0 != null) {
            tvToogle0.setTypeface(tf);
        }
        if (tvToogle1 != null) {
            tvToogle1.setTypeface(tf);
        }
        if (tvToogle2 != null) {
            tvToogle2.setTypeface(tf);
        }
        if (tvToogle3 != null) {
            tvToogle3.setTypeface(tf);
        }

        if (toggleButton0 != null) {
            toggleButton0.setChecked(indikatorLv2.isState0());
        }
        if (toggleButton1 != null) {
            toggleButton1.setChecked(indikatorLv2.isState1());
        }
        if (toggleButton2 != null) {
            toggleButton2.setChecked(indikatorLv2.isState2());
        }
        if (toggleButton3 != null) {
            toggleButton3.setChecked(indikatorLv2.isState3());
        }

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        final String date = dateFormat.format(new Date());
        toggleButton0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvToogle0.setText(date);
                } else {
                    tvToogle0.setText("-");
                }
            }
        });
        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvToogle1.setText(date);
                } else {
                    tvToogle1.setText("-");
                }
            }
        });
        toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvToogle2.setText(date);
                } else {
                    tvToogle2.setText("-");
                }
            }
        });
        toggleButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvToogle3.setText(date);
                } else {
                    tvToogle3.setText("-");
                }
            }
        });

        if (toggleButton0.isChecked()) tvToogle0.setText(date);
        if (toggleButton1.isChecked()) tvToogle1.setText(date);
        if (toggleButton2.isChecked()) tvToogle2.setText(date);
        if (toggleButton3.isChecked()) tvToogle3.setText(date);

        if (LoginMainActivity.login.equals("Siswa")) {
            toggleButton0.setClickable(false);
            toggleButton1.setClickable(false);
            toggleButton2.setClickable(false);
            toggleButton3.setClickable(false);
            btnSimpan.setVisibility(View.GONE);
        }

        final int posisi = groupPosition * 2 + childPosition;

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println("key = "+indikatorLv2DB.getKey());
                indikatorLv2.setState0(toggleButton0.isChecked());
                indikatorLv2DB.child(IndikatorKemampuanDetailActivity.key.get(posisi)).child("state0").setValue(toggleButton0.isChecked());
                indikatorLv2.setState1(toggleButton1.isChecked());
                indikatorLv2DB.child(IndikatorKemampuanDetailActivity.key.get(posisi)).child("state1").setValue(toggleButton1.isChecked());
                indikatorLv2.setState2(toggleButton2.isChecked());
                indikatorLv2DB.child(IndikatorKemampuanDetailActivity.key.get(posisi)).child("state2").setValue(toggleButton2.isChecked());
                indikatorLv2.setState3(toggleButton3.isChecked());
                indikatorLv2DB.child(IndikatorKemampuanDetailActivity.key.get(posisi)).child("state3").setValue(toggleButton3.isChecked());
                //Toast.makeText(context, indikatorLv2.isState0() + "" + indikatorLv2.isState1()
                //        + "" + indikatorLv2.isState2() + "" + indikatorLv2.isState3(), Toast.LENGTH_SHORT).show();

            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    void filterData(String query) {
        query = query.toLowerCase();
        Log.v("MyListAdapter", String.valueOf(indikatorLv1List.size()));
        indikatorLv1List.clear();

        if (query.isEmpty()) {
            indikatorLv1List.addAll(originalList);
        } else {
            for (IndikatorLv1 indikatorLv1 : originalList) {
                ArrayList<IndikatorLv2> indikatorLv2List = indikatorLv1.getLv2List();
                ArrayList<IndikatorLv2> newList = new ArrayList<>();
                for (IndikatorLv2 indikatorLv2 : indikatorLv2List) {
                    if (indikatorLv2.getId().toLowerCase().contains(query) || indikatorLv2.getNama().toLowerCase().contains(query)) {
                        newList.add(indikatorLv2);
                    }
                }
                if (newList.size() > 0) {
                    IndikatorLv1 nIndikatorLv1 = new IndikatorLv1(indikatorLv1.getId(), indikatorLv1.getNama(), newList);
                    indikatorLv1List.add(nIndikatorLv1);
                }
            }
        }

        Log.v("MyListAdapter", String.valueOf(indikatorLv1List.size()));
        notifyDataSetChanged();
    }
}
