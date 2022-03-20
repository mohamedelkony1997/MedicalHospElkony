package com.example.hosp.manger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hosp.AttendenceAndLeaving;
import com.example.hosp.Calls;
import com.example.hosp.NotificationReceptionist;
import com.example.hosp.R;
import com.example.hosp.Reports;
import com.example.hosp.Tasks;
import com.example.hosp.analysis.AnalysisEmployeeHomePage;

public class MangerHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manger_home_page);
    }
    public void oncases(View view) {

        Intent intent=new Intent(MangerHomePage.this, CasesManger.class);
        startActivity(intent);
    }



    public void ontasks(View view) {
        Intent intent2=new Intent(MangerHomePage.this, MainTasks.class);
        startActivity(intent2);
    }

    public void onreports(View view) {
        Intent intent2=new Intent(MangerHomePage.this, Reports.class);
        startActivity(intent2);
    }

    public void notificationteceptionist(View view) {
        Intent intent2=new Intent(MangerHomePage.this, NotificationReceptionist.class);
        startActivity(intent2);
    }

    public void onattendenceandleaving(View view) {
        Intent intent2=new Intent(MangerHomePage.this, AttendenceAndLeaving.class);
        startActivity(intent2);
    }

    public void onemployee(View view) {
        Intent intent2=new Intent(MangerHomePage.this,   AttendenceAndLeaving .class);
        startActivity(intent2);
    }
}