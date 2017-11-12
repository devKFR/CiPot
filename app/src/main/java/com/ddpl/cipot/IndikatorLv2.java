package com.ddpl.cipot;

/**
 * Created by user on 10/11/2017.
 */

public class IndikatorLv2 {
    private String ID = "", nama = "";

    public IndikatorLv2(String ID, String nama) {
        this.ID = ID;
        this.nama = nama;
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
}
