package com.example.hosp.manger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hosp.R;
import com.example.hosp.doctor.CasesAdapter;

public class CasesManger extends AppCompatActivity implements mangercasesitemrecyclerinterface {
    RecyclerView casesRecyclerView;
    CasesAdapter casesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_manger);
    }

    @Override
    public void onitemclick(int position) {

    }
}