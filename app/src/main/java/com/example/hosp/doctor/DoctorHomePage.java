package com.example.hosp.doctor;

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

public class DoctorHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home_page);

    }
    public void oncallsdoctors(View view) {

        Intent intent=new Intent(DoctorHomePage.this, CaseDetials.class);
        startActivity(intent);
    }



    public void ontasksdoctors(View view) {
        Intent intent2=new Intent(DoctorHomePage.this, Tasks.class);
        startActivity(intent2);
    }

    public void onreportsdoctors(View view) {
        Intent intent2=new Intent(DoctorHomePage.this, Reports.class);
        startActivity(intent2);
    }

    public void notificationteceptionist(View view) {
        Intent intent2=new Intent(DoctorHomePage.this, NotificationReceptionist.class);
        startActivity(intent2);
    }

    public void onattendenceandleavingdocttors(View view) {
        Intent intent2=new Intent(DoctorHomePage.this, AttendenceAndLeaving.class);
        startActivity(intent2);
    }

    public void oncasesdoctors(View view) {
        Intent intent2=new Intent(DoctorHomePage.this, Cases.class);
        startActivity(intent2);
    }
}