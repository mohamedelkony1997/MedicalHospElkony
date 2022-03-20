package com.example.hosp.analysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hosp.R;
import com.example.hosp.Receptionist_homepage;
import com.example.hosp.Tasks;

public class RequestsDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests_details);
    }

    public void onaddrecord(View view) {
        Intent intent2=new Intent(RequestsDetails.this, AddRecord.class);
        startActivity(intent2);

    }
}