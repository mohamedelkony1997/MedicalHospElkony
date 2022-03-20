package com.example.hosp.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hosp.CreateReports;
import com.example.hosp.R;
import com.example.hosp.Reports;

public class CaseDetials extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_detials);
    }


    public void onaddnurse(View view) {
        Intent intent = new Intent(CaseDetials.this, SelectNurse.class);
        startActivity(intent);
    }

    public void onrequest(View view) {
        BottomSheetDoctor bottomSheetDoctor=new BottomSheetDoctor();
        bottomSheetDoctor.show(getSupportFragmentManager(),"TAG");
    }


    public void onendcase(View view) {
        Intent intent = new Intent(CaseDetials.this, DoctorHomePage.class);
        startActivity(intent);
    }
}

