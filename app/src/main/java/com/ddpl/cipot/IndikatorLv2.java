package com.ddpl.cipot;

public class IndikatorLv2 {


    private String id = "", nama = "";
    private boolean state0, state1, state2, state3;

    public IndikatorLv2() {
    }

    public IndikatorLv2(String id, String nama, boolean state0, boolean state1, boolean state2, boolean state3) {
        this.id = id;
        this.nama = nama;
        this.state0 = state0;
        this.state1 = state1;
        this.state2 = state2;
        this.state3 = state3;
    }

    public boolean getState0() {
        return state0;
    }

    public void setState0(boolean state0) {
        this.state0 = state0;
    }

    public boolean getState1() {
        return state1;
    }

    public void setState1(boolean state1) {
        this.state1 = state1;
    }

    public boolean getState2() {
        return state2;
    }

    public void setState2(boolean state2) {
        this.state2 = state2;
    }

    public boolean getState3() {
        return state3;
    }

    public void setState3(boolean state3) {
        this.state3 = state3;
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
}
