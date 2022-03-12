package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Select_Doctor extends AppCompatActivity {
RecyclerView doctorsreRecyclerView;
receptionistAdapter doctorsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doctor);
        doctorsreRecyclerView=findViewById(R.id.recycler_doctor);
    }

    public void selectdoctor_btn(View view) {
        Intent intent=new Intent(Select_Doctor.this,CreateCall.class);
        startActivity(intent);
    }
}