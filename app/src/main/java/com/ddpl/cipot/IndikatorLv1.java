package com.ddpl.cipot;

import java.util.ArrayList;

/**
 * Created by user on 10/11/2017.
 */

public class IndikatorLv1 {
    private String ID = "", nama = "";
    private ArrayList<IndikatorLv2> lv2List = new ArrayList<>();

    public IndikatorLv1(String ID, String nama, ArrayList<IndikatorLv2> lv2List) {
        this.ID = ID;
        this.nama = nama;
        this.lv2List = lv2List;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<IndikatorLv2> getLv2List() {
        return lv2List;
    }

    public void setLv2List(ArrayList<IndikatorLv2> lv2List) {
        this.lv2List = lv2List;
    }


}
