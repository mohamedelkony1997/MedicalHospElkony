package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AttendenceAndLeaving extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence_and_leaving);
    }

    public void attendance_btn(View view) {
        Intent intent2=new Intent(AttendenceAndLeaving.this, ReceptionistAttendanceFingerPrint.class);
        startActivity(intent2);
    }

    public void leaving_btn(View view) {
        Intent intent2=new Intent(AttendenceAndLeaving.this, ReceptionistLeavingFingerPrintA.class);
        startActivity(intent2);
    }
}