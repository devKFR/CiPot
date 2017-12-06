package com.ddpl.cipot;

import java.util.ArrayList;

public class IndikatorLv1 {
    private String id = "", nama = "";
    private ArrayList<IndikatorLv2> lv2List = new ArrayList<>();

    public IndikatorLv1() {
    }

    IndikatorLv1(String id, String nama, ArrayList<IndikatorLv2> lv2List) {
        this.id = id;
        this.nama = nama;
        this.lv2List = lv2List;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    ArrayList<IndikatorLv2> getLv2List() {
        return lv2List;
    }

    void setLv2List(ArrayList<IndikatorLv2> lv2List) {
        this.lv2List = lv2List;
    }


}
