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

    boolean isState0() {
        return state0;
    }

    void setState0(boolean state0) {
        this.state0 = state0;
    }

    boolean isState1() {
        return state1;
    }

    void setState1(boolean state1) {
        this.state1 = state1;
    }

    boolean isState2() {
        return state2;
    }

    void setState2(boolean state2) {
        this.state2 = state2;
    }

    boolean isState3() {
        return state3;
    }

    void setState3(boolean state3) {
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
