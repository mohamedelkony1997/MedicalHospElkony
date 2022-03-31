package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.hosp.hr.AddEmployee;

public class SplashHosp extends AppCompatActivity {
Button getstarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.spalsh_hosp);
        getstarted=findViewById(R.id.start);
        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SplashHosp.this, Loading_Activity.class);
                startActivity(intent);

            }
        });



    }
}