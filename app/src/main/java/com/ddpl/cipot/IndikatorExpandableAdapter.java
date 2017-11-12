package com.ddpl.cipot;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 10/11/2017.
 */

public class IndikatorExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<IndikatorLv1> indikatorLv1List, originalList;

    public IndikatorExpandableAdapter(Context context, ArrayList<IndikatorLv1> indikatorLv1List) {
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

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        IndikatorLv1 indikatorLv1 = (IndikatorLv1) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_header, null);
        }

        TextView heading = (TextView) convertView.findViewById(R.id.tv_namaHeader);
        heading.setTypeface(null, Typeface.BOLD);
        heading.setText(indikatorLv1.getNama().trim());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        IndikatorLv2 indikatorLv2 = (IndikatorLv2) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_child, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.tv_detailChild);
        txtListChild.setText(indikatorLv2.getNama().trim());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query) {
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
                    if (indikatorLv2.getID().toLowerCase().contains(query) || indikatorLv2.getNama().toLowerCase().contains(query)) {
                        newList.add(indikatorLv2);
                    }
                }
                if (newList.size() > 0) {
                    IndikatorLv1 nIndikatorLv1 = new IndikatorLv1(indikatorLv1.getID(), indikatorLv1.getNama(), newList);
                    indikatorLv1List.add(nIndikatorLv1);
                }
            }
        }

        Log.v("MyListAdapter", String.valueOf(indikatorLv1List.size()));
        notifyDataSetChanged();
    }
}
