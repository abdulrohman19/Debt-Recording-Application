package com.example.projectfix;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CatatanModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String judul;
    private String jumlahhutang;
    private String tanggal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJumlahhutang() {
        return jumlahhutang;
    }

    public void setJumlahhutang(String jumlahhutang) {
        this.jumlahhutang = jumlahhutang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
