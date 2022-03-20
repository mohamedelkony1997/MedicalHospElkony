package com.example.hosp.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hosp.R;
import com.example.hosp.ReportsAdapter;

public class Cases extends AppCompatActivity implements  casesitemrecyclerinterface {
    RecyclerView casesRecyclerView;
    CasesAdapter casesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases);
        casesRecyclerView=findViewById(R.id.casesdoctorsrecyclerview);
    }

    @Override
    public void onitemclick(int position) {

    }
}