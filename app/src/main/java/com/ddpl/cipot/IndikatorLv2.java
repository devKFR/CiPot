package com.ddpl.cipot;

/**
 * Created by user on 10/11/2017.
 */

public class IndikatorLv2 {
    private String ID = "", nama = "";
    private boolean state0, state1, state2, state3;

    public IndikatorLv2(String ID, String nama) {
        this.ID = ID;
        this.nama = nama;
    }

    public boolean isState1() {
        return state1;
    }

    public void setState1(boolean state1) {
        this.state1 = state1;
    }

    public boolean isState2() {
        return state2;
    }

    public void setState2(boolean state2) {
        this.state2 = state2;
    }

    public boolean isState3() {
        return state3;
    }

    public void setState3(boolean state3) {
        this.state3 = state3;
    }

    public boolean isState0() {
        return state0;
    }

    public void setState0(boolean state0) {
        this.state0 = state0;
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
