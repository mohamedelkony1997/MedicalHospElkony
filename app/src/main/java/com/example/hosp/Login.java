package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hosp.analysis.AnalysisEmployeeHomePage;
import com.example.hosp.analysis.RequestsDetails;
import com.example.hosp.doctor.DoctorHomePage;
import com.example.hosp.hr.Employee;
import com.example.hosp.manger.CasesDetialsMAnger;
import com.example.hosp.manger.CasesManger;
import com.example.hosp.manger.MainTasks;
import com.example.hosp.manger.MaintasksDetails;
import com.example.hosp.manger.MangerHomePage;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login_btn(View view) {
        Intent intent=new Intent(Login.this, Employee.class);
        startActivity(intent);
    }
}