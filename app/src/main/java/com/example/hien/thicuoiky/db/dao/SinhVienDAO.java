package com.example.hien.thicuoiky.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.hien.thicuoiky.db.entity.SinhVien;

import java.util.List;

@Dao
public interface SinhVienDAO {
    @Insert
    long insert(SinhVien sv);
    @Update
    void update(SinhVien sv);
    @Delete
    void delete(SinhVien sv);
    @Query("select * from sinhvien")
    List<SinhVien> getAllSV();
}
