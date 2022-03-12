package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ProtoType_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_proto_type);


    }

    public void doc_btn(View view) {
        Intent intent=new Intent(ProtoType_Activity.this,Loading_Activity.class);
        startActivity(intent);
    }

    public void recep_btn(View view) {
        Intent intent=new Intent(ProtoType_Activity.this,Loading_Activity.class);
        startActivity(intent);
    }

    public void employee_btn(View view) {
        Intent intent=new Intent(ProtoType_Activity.this,Loading_Activity.class);
        startActivity(intent);
    }

    public void manger_btn(View view) {
        Intent intent=new Intent(ProtoType_Activity.this,Loading_Activity.class);
        startActivity(intent);
    }

    public void hr_btn(View view) {
        Intent intent=new Intent(ProtoType_Activity.this,Loading_Activity.class);
        startActivity(intent);
    }

    public void nurse_btn(View view) {
        Intent intent=new Intent(ProtoType_Activity.this,Loading_Activity.class);
        startActivity(intent);
    }
}