package com.example.hosp.hr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hosp.R;

public class Profile extends AppCompatActivity {
TextView name,specialist,gender,address,status,birthday,email,phone;
ImageView profile;
String rec="Specialist ,";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile=findViewById(R.id.profile_image);
        name=findViewById(R.id.profilename);
        specialist=findViewById(R.id.profilespecialist);
        gender=findViewById(R.id.profilegender);
        birthday=findViewById(R.id.profiledataofbirth);
        address=findViewById(R.id.profileaddress);
        status=findViewById(R.id.profilestatus);
        email=findViewById(R.id.profileemail);
        phone=findViewById(R.id.profilephone);
        Intent intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        specialist.setText(rec);
        specialist.append(intent.getStringExtra(  "specilaist"));
        gender.setText(intent.getStringExtra("gender"));
        if(intent.getStringExtra("gender").equals("female")){
          profile.setImageResource(R.drawable.femaleava);
        }else
        {
            profile.setImageResource(R.drawable.maleavatar);
        }
        address.setText(intent.getStringExtra("address"));
        status.setText(intent.getStringExtra("status"));
        birthday.setText(intent.getStringExtra("birthday"));
        email.setText(intent.getStringExtra("email"));
        phone.setText(intent.getStringExtra("phone"));




    }

    public void onadduser(View view) {
        Intent intent=new Intent(Profile.this, AddEmployee.class);
        startActivity(intent);
    }
}