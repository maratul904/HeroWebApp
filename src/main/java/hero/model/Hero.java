package com.hero.model;

public class Hero {
    private int id;
    private String nama;
    private String kategori;
    private String gender;

    public Hero() {
        // Constructor kosong untuk keperluan form atau ORM (opsional)
    }

    public Hero(int id, String nama, String kategori, String gender) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.gender = gender;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public String getGender() {
        return gender;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}