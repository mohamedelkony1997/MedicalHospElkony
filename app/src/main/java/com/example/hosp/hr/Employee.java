package com.example.hosp.hr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hosp.Login;
import com.example.hosp.R;

public class Employee extends AppCompatActivity implements employeeitemrecyclerinterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
    }

    public void onaddemployee_btn(View view) {
        Intent intent=new Intent(Employee.this, AddEmployee.class);
        startActivity(intent);
    }

    @Override
    public void onitemclick(int position) {

    }
}