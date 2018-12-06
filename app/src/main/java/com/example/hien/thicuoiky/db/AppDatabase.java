package com.example.hien.thicuoiky.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.hien.thicuoiky.db.dao.SinhVienDAO;
import com.example.hien.thicuoiky.db.entity.SinhVien;

@Database(entities = {SinhVien.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    static String DB_NAME = "dlsv.sqlite";
    private static AppDatabase instance;
    public static AppDatabase getInstance(Context con){
        if(instance==null){
            instance = Room.databaseBuilder(con,AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    };
    public abstract SinhVienDAO sinhVienDAO();
}
