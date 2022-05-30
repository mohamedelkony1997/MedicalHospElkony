package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hosp.hosiptal.RetorfitClient;
import com.example.hosp.hosiptal.models.displaycalls.DisplayCallsResponse;
import com.example.hosp.hosiptal.models.logout.LogoutResponse;
import com.example.hosp.hosiptal.models.showcall.ShowCallData;
import com.example.hosp.hosiptal.models.showcall.ShowCallResponse;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class casesdetails_rec extends AppCompatActivity {
TextView name,age,phone,data,status,casedes;
Button logout;
    String id;
    String token;
    public static String ACESSTOKEN="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNTYxODAyOTAwZjBhMTAyZTc3ZjAwODA4ZDVmZDRlMTRlZTQ0NDI4Zjk3MTcwMmE0OWFjN2YxZDJhYzYyMzliYjljNzI5MWJmOTkyNWNhNDciLCJpYXQiOjE2NDk2NzU0MjUuMzM3NjcsIm5iZiI6MTY0OTY3NTQyNS4zMzc2NzQsImV4cCI6MTY4MTIxMTQyNS4zMTYwODcsInN1YiI6IjcyIiwic2NvcGVzIjpbXX0.Wwu42dAyPgFblUW3LteWbZ4F1RDK5pLIRBIBqsQvI6-F0JuRvV8e27H0tgOB88OvUXfLdwoTaNycn7HPXmvUzRT6HSugrSF4QmwMQCBthibHvc3vdVICmYE5k7Qyobt8o6Hm_jV243xiv78DVCvljtb-Mvs4_f6565EbxEahruZK46aSFT72WMx77QiJl-R5wnoy9Mqi5O9O4wK_by_qq6x11VafXZwFZtIMirYuhWK_Zx5_kfuN-EhDlYKskmjCjOYmMp87gxZ91c1NoGVc0g9M01iGqnq9nAcwWSjw9k4OjbFFJtA9GSccqPWAPaRyCmvZoh-o3vg7fX-eo89if0fLDmdGFtLGzX24cycIqTIlzGGR0kkS6XLnbzHw4qPDPZvvmkNA8b_F04s_791iDE5RJ2Qo8NYep993iFYzSiVhT_B0i1wfgyDswZ3dO4X0NHS8daUX8H-rrvra_3LWzD9DY6GXhUs1yYcfoBHp9h7juQjTUFmj47V0tK_8EQB_fbztlNR17eHAYdm5mJfidx705ZXWtisb9jH_o3eoOt3fExRZW3UXyUz7cjROVPDvR0jFz4yxp8u8s4bsGaSwDRqbM-xiVCVI9USCI_o2N0bLxs2gJHJMMNM3dr9sXYLwQgLfUzatcKGoelylDrNdX6Asc5zsTt6y5rftBLXsq7I";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casesdetails_rec);
        name=findViewById(R.id.name_text);
        age=findViewById(R.id.age_text);
        phone=findViewById(R.id.phone_text);
        data=findViewById(R.id.data_text);

        status=findViewById(R.id.patientstatus_text);
        casedes=findViewById(R.id.casedescription_text);
        logout=findViewById(R.id.endcase);


showcall();
    }
    void showcall(){

     token="Bearer " +ACESSTOKEN;
        Intent intent=getIntent();
   id=intent.getStringExtra("callid");

        RetorfitClient.getClient().showcall(id,token).enqueue(new Callback<ShowCallResponse>() {
            @Override
            public void onResponse(Call<ShowCallResponse> call, Response<ShowCallResponse> response) {
                if(response.isSuccessful()){
                    handlesucessresponse(response);

                }else {

                    handleerrorresponse(response);
                }
            }

            @Override
            public void onFailure(Call<ShowCallResponse> call, Throwable t) {
                Toast.makeText(casesdetails_rec.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void handleerrorresponse(Response<ShowCallResponse> response) {
        try {
            String errormessagaderesponse = response.errorBody().string();
            Toast.makeText(casesdetails_rec.this,errormessagaderesponse, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressLint("ResourceAsColor")
    private void handlesucessresponse(Response<ShowCallResponse>response) {
        if ( response.isSuccessful()){
            Toast.makeText(casesdetails_rec.this, "show data", Toast.LENGTH_SHORT).show();
            ShowCallData showCallData=response.body().getData();
            System.out.println(showCallData.getPatientName());
            name.setText(showCallData.getPatientName());
            age.setText(showCallData.getAge());
            phone.setText(showCallData.getPhone());
            if(showCallData.getStatus().equals("pending_doctor")){
                status.setText("pending_doctor");

                status.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.process, 0);
                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RetorfitClient.getClient().logout(id,token).enqueue(new Callback<LogoutResponse>() {
                            @Override
                            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                               if(response.isSuccessful()){
                                   Toast.makeText(casesdetails_rec.this, "logout done", Toast.LENGTH_SHORT).show();
                               }else{
                                   Toast.makeText(casesdetails_rec.this, "error log out", Toast.LENGTH_SHORT).show();
                               }
                            }

                            @Override
                            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                                Toast.makeText(casesdetails_rec.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }else{
                status.setText("accept_doctor");
                status.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.checkbox_mark, 0);
                logout.setEnabled(false);
               logout.setBackgroundColor(logout.getContext().getResources().getColor(R.color.gray));;
            }
            casedes.setText(showCallData.getDescription());
            data.setText(showCallData.getCreatedAt());

        }else {
            String messagebody=response.message();
            Toast.makeText(casesdetails_rec.this, messagebody, Toast.LENGTH_LONG).show();
        }
    }

}