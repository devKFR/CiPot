package com.ddpl.cipot;

import java.util.Date;

public class Siswa {
    private String agama, alamat, jKelamin, namaAyah, namaIbu, namaLengkap, namaPanggilan, noAkta, pekerjaanAyah, pekerjaanIbu, tempatLahir;
    private int anakKe, jumlahSaudara;
    private Date tglLahir;

    public Siswa() {

    }

    public Siswa(String agama, String alamat, String jKelamin, String namaAyah,
                 String namaIbu, String namaLengkap, String namaPanggilan, String noAkta,
                 String pekerjaanAyah, String pekerjaanIbu, String tempatLahir, int anakKe, int jumlahSaudara, Date tglLahir) {
        this.agama = agama;
        this.alamat = alamat;
        this.jKelamin = jKelamin;
        this.namaAyah = namaAyah;
        this.namaIbu = namaIbu;
        this.namaLengkap = namaLengkap;
        this.namaPanggilan = namaPanggilan;
        this.noAkta = noAkta;
        this.pekerjaanAyah = pekerjaanAyah;
        this.pekerjaanIbu = pekerjaanIbu;
        this.tempatLahir = tempatLahir;
        this.anakKe = anakKe;
        this.jumlahSaudara = jumlahSaudara;
        this.tglLahir = tglLahir;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getjKelamin() {
        return jKelamin;
    }

    public void setjKelamin(String jKelamin) {
        this.jKelamin = jKelamin;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNamaPanggilan() {
        return namaPanggilan;
    }

    public void setNamaPanggilan(String namaPanggilan) {
        this.namaPanggilan = namaPanggilan;
    }

    public String getNoAkta() {
        return noAkta;
    }

    public void setNoAkta(String noAkta) {
        this.noAkta = noAkta;
    }

    public String getPekerjaanAyah() {
        return pekerjaanAyah;
    }

    public void setPekerjaanAyah(String pekerjaanAyah) {
        this.pekerjaanAyah = pekerjaanAyah;
    }

    public String getPekerjaanIbu() {
        return pekerjaanIbu;
    }

    public void setPekerjaanIbu(String pekerjaanIbu) {
        this.pekerjaanIbu = pekerjaanIbu;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public int getAnakKe() {
        return anakKe;
    }

    public void setAnakKe(int anakKe) {
        this.anakKe = anakKe;
    }

    public int getJumlahSaudara() {
        return jumlahSaudara;
    }

    public void setJumlahSaudara(int jumlahSaudara) {
        this.jumlahSaudara = jumlahSaudara;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }
}
