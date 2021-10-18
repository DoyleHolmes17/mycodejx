package com.farid.myapplication;

public class Barang {

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Barang(String nama, String kategori) {
        this.nama = nama;
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return nama;
    }

    String nama;
    String kategori;
}
