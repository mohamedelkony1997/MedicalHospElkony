package com.example.hosp.analysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hosp.AttendenceAndLeaving;
import com.example.hosp.Calls;
import com.example.hosp.NotificationReceptionist;
import com.example.hosp.R;
import com.example.hosp.Receptionist_homepage;
import com.example.hosp.Reports;
import com.example.hosp.Tasks;

public class AnalysisEmployeeHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_employee_home_page);
    }
    public void oncases(View view) {

        Intent intent=new Intent(AnalysisEmployeeHomePage.this, Requests.class);
        startActivity(intent);
    }



    public void ontasks(View view) {
        Intent intent2=new Intent(AnalysisEmployeeHomePage.this, Tasks.class);
        startActivity(intent2);
    }

    public void onreports(View view) {
        Intent intent2=new Intent(AnalysisEmployeeHomePage.this, Reports.class);
        startActivity(intent2);
    }

    public void notificationteceptionist(View view) {
        Intent intent2=new Intent(AnalysisEmployeeHomePage.this, NotificationReceptionist.class);
        startActivity(intent2);
    }

    public void onattendenceandleaving(View view) {
        Intent intent2=new Intent(AnalysisEmployeeHomePage.this, AttendenceAndLeaving.class);
        startActivity(intent2);
    }
}