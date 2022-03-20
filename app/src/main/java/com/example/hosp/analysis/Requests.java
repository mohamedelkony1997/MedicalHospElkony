package com.example.hosp.analysis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hosp.R;

public class Requests extends AppCompatActivity implements requestsitemrecyclerinterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
    }

    @Override
    public void onitemclick(int position) {

    }
}