package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_call);
    }


    public void selectdoctor(View view) {
        Intent intent=new Intent(CreateCall.this,Select_Doctor.class);
        startActivity(intent);
    }

    public void send_call(View view) {
        Intent intent=new Intent(CreateCall.this,CallDone.class);
        startActivity(intent);
    }
}