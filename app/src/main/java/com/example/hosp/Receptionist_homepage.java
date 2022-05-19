package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Receptionist_homepage extends AppCompatActivity {
    TextView receptionistname,receptionistspecilaist;
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist_homepage);
        receptionistname=findViewById(R.id.doctorname_text1);
        receptionistspecilaist=findViewById(R.id.specialtype_text1);
        profile=findViewById(R.id.profile_rec_image);
        SharedPreferences sharedPreferences=getSharedPreferences("RECEPTIONISTPREFS",MODE_PRIVATE);
        String showfirstname2=sharedPreferences.getString("REChomepagefirst",null);
        String showlastname2=sharedPreferences.getString("REChomepagelast",null);
        String specialist2=sharedPreferences.getString("REChomepagespecilaist",null);
        String gender=sharedPreferences.getString("REChomepagegender",null);
        if(showfirstname2!= null && showlastname2!=null && specialist2!=null&&gender!=null) {
            receptionistname.setText(showfirstname2+" ");
            receptionistname.append(showlastname2);
            receptionistspecilaist.setText("specialist , "+ specialist2);
            if(gender.equals("male")){
                profile.setImageResource(R.drawable.maleavatar);
            }else{
                profile.setImageResource(R.drawable.femaleava);
            }

        }
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