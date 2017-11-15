package com.ddpl.cipot;

/**
 * Created by user on 10/11/2017.
 */

public class IndikatorLv2 {
    private String ID = "", nama = "";
    private boolean state = false;

    public IndikatorLv2(String ID, String nama) {
        this.ID = ID;
        this.nama = nama;
        this.state = false;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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
