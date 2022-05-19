package com.example.hosp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hosp.hosiptal.RetorfitClient;
import com.example.hosp.hosiptal.models.CreateCall.CreateCallRequest;
import com.example.hosp.hosiptal.models.CreateCall.CreateCallResponse;
import com.example.hosp.hosiptal.models.displaycalls.DisplayCallsResponse;
import com.example.hosp.hosiptal.models.register.RegisterResponse;
import com.example.hosp.hr.AddEmployee;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateCall extends AppCompatActivity {
    public static String ACESSTOKEN="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNTYxODAyOTAwZjBhMTAyZTc3ZjAwODA4ZDVmZDRlMTRlZTQ0NDI4Zjk3MTcwMmE0OWFjN2YxZDJhYzYyMzliYjljNzI5MWJmOTkyNWNhNDciLCJpYXQiOjE2NDk2NzU0MjUuMzM3NjcsIm5iZiI6MTY0OTY3NTQyNS4zMzc2NzQsImV4cCI6MTY4MTIxMTQyNS4zMTYwODcsInN1YiI6IjcyIiwic2NvcGVzIjpbXX0.Wwu42dAyPgFblUW3LteWbZ4F1RDK5pLIRBIBqsQvI6-F0JuRvV8e27H0tgOB88OvUXfLdwoTaNycn7HPXmvUzRT6HSugrSF4QmwMQCBthibHvc3vdVICmYE5k7Qyobt8o6Hm_jV243xiv78DVCvljtb-Mvs4_f6565EbxEahruZK46aSFT72WMx77QiJl-R5wnoy9Mqi5O9O4wK_by_qq6x11VafXZwFZtIMirYuhWK_Zx5_kfuN-EhDlYKskmjCjOYmMp87gxZ91c1NoGVc0g9M01iGqnq9nAcwWSjw9k4OjbFFJtA9GSccqPWAPaRyCmvZoh-o3vg7fX-eo89if0fLDmdGFtLGzX24cycIqTIlzGGR0kkS6XLnbzHw4qPDPZvvmkNA8b_F04s_791iDE5RJ2Qo8NYep993iFYzSiVhT_B0i1wfgyDswZ3dO4X0NHS8daUX8H-rrvra_3LWzD9DY6GXhUs1yYcfoBHp9h7juQjTUFmj47V0tK_8EQB_fbztlNR17eHAYdm5mJfidx705ZXWtisb9jH_o3eoOt3fExRZW3UXyUz7cjROVPDvR0jFz4yxp8u8s4bsGaSwDRqbM-xiVCVI9USCI_o2N0bLxs2gJHJMMNM3dr9sXYLwQgLfUzatcKGoelylDrNdX6Asc5zsTt6y5rftBLXsq7I";
TextInputEditText patientName,age,phone,description,doctorname;
String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_call);
        patientName=findViewById(R.id.patient_name_edittext);
        age=findViewById(R.id.age_edittext);
        phone=findViewById(R.id.phonenum_edittext);
        description=findViewById(R.id.description_edittext);
        doctorname=findViewById(R.id.selectdoctor_edittext);


    }


    public void selectdoctor(View view) {
        startActivityForResult(new Intent(getApplicationContext(),Select_Doctor.class),999);
    }

    public void send_call(View view) {
        createcall();
        Intent intent=new Intent(CreateCall.this,CallDone.class);
        startActivity(intent);
    }
    public void createcall(){
        String token="Bearer " +ACESSTOKEN;

   String patientnamestr=patientName.getText().toString();
   String agestr=age.getText().toString();
   String phonestr=phone.getText().toString();
   String decriptionstr=description.getText().toString();
   if(patientnamestr.isEmpty()&&agestr.isEmpty()&&phonestr.isEmpty()&&decriptionstr.isEmpty()){
       Toast.makeText(this, "you must fill all fields", Toast.LENGTH_LONG).show();
   }else{



       CreateCallRequest createCallRequest=new CreateCallRequest(patientnamestr,agestr,phonestr,decriptionstr,id);
       RetorfitClient.getClient().createcalls(createCallRequest,token).enqueue(new Callback<CreateCallResponse>() {
           @Override
           public void onResponse(Call<CreateCallResponse> call, Response<CreateCallResponse> response) {
               if(response.isSuccessful()){
         handlesucessresponse(response);
               }else {
                   handleerrorresponse(response);
               }

           }

           @Override
           public void onFailure(Call<CreateCallResponse> call, Throwable t) {
               Toast.makeText(CreateCall.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
           }
       });


   }

    }

    private void handlesucessresponse(Response<CreateCallResponse> response) {
        if ( response.isSuccessful()){
            Toast.makeText(this, "created call done", Toast.LENGTH_LONG).show();
            finish();

        }else {
            String messagebody=response.body().getMessage();
            Toast.makeText(CreateCall.this, messagebody, Toast.LENGTH_LONG).show();
        }
    }


    private void handleerrorresponse(Response<CreateCallResponse> response) {
        try {
            String errormessagaderesponse = response.errorBody().string();
            Toast.makeText(CreateCall.this,errormessagaderesponse, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==999&&resultCode==RESULT_OK){
            doctorname.setText(data.getStringExtra("doctorname"));
            id=data.getStringExtra("doctorid");


        }
    }
}