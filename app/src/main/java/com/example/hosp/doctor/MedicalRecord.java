package com.example.hosp.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hosp.CreateReports;
import com.example.hosp.R;
import com.example.hosp.Reports;

public class MedicalRecord extends AppCompatActivity {
Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_record);


    }
    public void onsendtofragment(View view) {
        Intent intent=new Intent(MedicalRecord.this, ShowMedicalRecord.class);

        startActivity(intent);

    }



}