package com.example.hien.thicuoiky;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.example.hien.thicuoiky.db.AppDatabase;
import com.example.hien.thicuoiky.db.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnThem, btnSua, btnXoa;
    ListView list;
    EditText txtMSSV, txtHT, txtDTB;
    AppDatabase db;
    ArrayAdapter<SinhVien> adap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        list = findViewById(R.id.lv);
        txtMSSV = findViewById(R.id.txtMSSV);
        txtHT = findViewById(R.id.txtHT);
        txtDTB = findViewById(R.id.txtDTB);
        db = AppDatabase.getInstance(this);
        adap = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList<SinhVien>());
        list.setAdapter(adap);
        loadDSSVTask();
    }

    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = txtHT.getText().toString();
                double dtb =Double.parseDouble(txtDTB.getText().toString());
                SinhVien sv = new SinhVien(0,hoten,dtb);
                themSVTask(sv);
            }
        });
    }

    void loadDSSVTask() {
       new AsyncTask<Void, Void, List<SinhVien>>(){
           @Override
           protected List<SinhVien> doInBackground(Void... voids) {
               return db.sinhVienDAO().getAllSV();
           }

           @Override
           protected void onPostExecute(List<SinhVien> sinhViens) {
               super.onPostExecute(sinhViens);
               adap.clear();
               if(sinhViens!=null){
                   adap.addAll(sinhViens);
               }
           }
       }.execute();
    }
    void themSVTask(final SinhVien sv){
        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                return db.sinhVienDAO().insert(sv);
            }

            @Override
            protected void onPostExecute(Long aLong) {
                super.onPostExecute(aLong);
                sv.setId(aLong);
                adap.add(sv);
            }
        }.execute();
    }
}
