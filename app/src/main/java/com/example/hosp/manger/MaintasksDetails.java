package com.example.hosp.manger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hosp.CreateReports;
import com.example.hosp.R;
import com.example.hosp.Reports;

public class MaintasksDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintasks_details);
    }

    public void onfinishtask(View view) {
        Intent intent = new Intent(MaintasksDetails.this, MangerHomePage.class);
        startActivity(intent);
    }
}