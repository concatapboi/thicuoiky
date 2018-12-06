package com.example.hien.thicuoiky.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "sinhvien")
public class SinhVien {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "hoten")
    private String hoten;
    @ColumnInfo(name = "dtb")
    private double dtb;


    public SinhVien() {
    }

    public SinhVien(long id, String hoten, double dtb) {
        this.id = id;
        this.hoten = hoten;
        this.dtb = dtb;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getDtb() {
        return dtb;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", hoten='" + hoten + '\'' +
                ", dtb=" + dtb +
                '}';
    }
}
