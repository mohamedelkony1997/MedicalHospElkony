package com.example.hosp.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hosp.CallsAdapter;
import com.example.hosp.R;

public class CallsDoctors extends AppCompatActivity {
    RecyclerView doctorscallsrecycler;
    DoctorsCallsAdapter doctorsCallsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calls_doctors);
        doctorscallsrecycler=findViewById(R.id.callsdoctorsrecyclerview);
    }
}