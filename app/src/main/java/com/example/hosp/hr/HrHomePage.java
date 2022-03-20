package com.example.hosp.hr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hosp.AttendenceAndLeaving;
import com.example.hosp.NotificationReceptionist;
import com.example.hosp.R;
import com.example.hosp.Receptionist_homepage;
import com.example.hosp.Reports;
import com.example.hosp.Tasks;

public class HrHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr_home_page);
    }

    public void onemployeehr(View view) {
    }
    public void ontasks(View view) {
        Intent intent2=new Intent(HrHomePage.this, Tasks.class);
        startActivity(intent2);
    }

    public void onreports(View view) {
        Intent intent2=new Intent(HrHomePage.this, Reports.class);
        startActivity(intent2);
    }

    public void notificationteceptionist(View view) {
        Intent intent2=new Intent(HrHomePage.this, NotificationReceptionist.class);
        startActivity(intent2);
    }

    public void onattendenceandleaving(View view) {
        Intent intent2=new Intent(HrHomePage.this, AttendenceAndLeaving.class);
        startActivity(intent2);
    }
}