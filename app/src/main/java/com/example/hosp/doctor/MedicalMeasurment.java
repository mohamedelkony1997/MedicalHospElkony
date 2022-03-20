package com.example.hosp.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hosp.R;

public class MedicalMeasurment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_measurment);
    }

    public void sonendtomeasurmentRecod(View view) {
        Intent intent=new Intent(MedicalMeasurment.this, ShowMeasurmentrecord.class);

        startActivity(intent);
    }
}