package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CallDone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_done);
    }

    public void backtothehome(View view) {
        Intent intent=new Intent(CallDone.this, Receptionist_homepage.class);
        startActivity(intent);
    }
}