package com.example.hosp.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hosp.CreateCall;
import com.example.hosp.R;
import com.example.hosp.Select_Doctor;

public class SelectNurse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_nurse);
    }



    public void selectnurse_btn(View view) {
        Intent intent=new Intent(SelectNurse.this, CaseDetials.class);
        startActivity(intent);
    }
}