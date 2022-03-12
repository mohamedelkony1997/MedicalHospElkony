package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Receptionist_homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist_homepage);
    }

    public void oncalls(View view) {

            Intent intent=new Intent(Receptionist_homepage.this,Calls.class);
            startActivity(intent);
    }



    public void ontasks(View view) {
        Intent intent2=new Intent(Receptionist_homepage.this, Tasks.class);
        startActivity(intent2);
    }

    public void onreports(View view) {
        Intent intent2=new Intent(Receptionist_homepage.this, Reports.class);
        startActivity(intent2);
    }

    public void notificationteceptionist(View view) {
        Intent intent2=new Intent(Receptionist_homepage.this, NotificationReceptionist.class);
        startActivity(intent2);
    }

    public void onattendenceandleaving(View view) {
        Intent intent2=new Intent(Receptionist_homepage.this, AttendenceAndLeaving.class);
        startActivity(intent2);
    }
}