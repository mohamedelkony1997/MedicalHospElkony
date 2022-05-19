package com.example.hosp.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hosp.AttendenceAndLeaving;
import com.example.hosp.Calls;
import com.example.hosp.NotificationReceptionist;
import com.example.hosp.R;
import com.example.hosp.Receptionist_homepage;
import com.example.hosp.Reports;
import com.example.hosp.Tasks;

public class DoctorHomePage extends AppCompatActivity {
TextView doctorname,doctorspecilaist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home_page);
        doctorname=findViewById(R.id.doctorname_text);
        doctorspecilaist=findViewById(R.id.specialtype_text);
        SharedPreferences sharedPreferences=getSharedPreferences("DOCTORPREFS",MODE_PRIVATE);
        String showfirstname=sharedPreferences.getString("DRhomepagefirst",null);
        String showlastname=sharedPreferences.getString("DRhomepagelast",null);
        String specialist=sharedPreferences.getString("DRhomepagespecilaist",null);
        if(showfirstname!= null || showlastname!=null || specialist!=null) {
            doctorname.setText(showfirstname + " ");
            doctorname.append(showlastname);
            doctorspecilaist.setText("specialist , " + specialist);
        }


    }
    public void oncallsdoctors(View view) {

        Intent intent=new Intent(DoctorHomePage.this, CallsDoctors.class);
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