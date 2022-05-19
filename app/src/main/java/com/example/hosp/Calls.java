package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.hosp.hosiptal.Apis;
import com.example.hosp.hosiptal.RetorfitClient;
import com.example.hosp.hosiptal.models.ErrorResponse;
import com.example.hosp.hosiptal.models.displaycalls.DataItemDisplayCalls;
import com.example.hosp.hosiptal.models.displaycalls.DisplayCallsRequest;
import com.example.hosp.hosiptal.models.displaycalls.DisplayCallsResponse;
import com.example.hosp.hosiptal.models.login.LoginRequest;
import com.example.hosp.hosiptal.models.login.LoginResponse;
import com.example.hosp.hr.AddEmployee;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Calls extends AppCompatActivity {
RecyclerView callsrecycler;
List<DataItemDisplayCalls>callslist;
public static String ACESSTOKEN="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNTYxODAyOTAwZjBhMTAyZTc3ZjAwODA4ZDVmZDRlMTRlZTQ0NDI4Zjk3MTcwMmE0OWFjN2YxZDJhYzYyMzliYjljNzI5MWJmOTkyNWNhNDciLCJpYXQiOjE2NDk2NzU0MjUuMzM3NjcsIm5iZiI6MTY0OTY3NTQyNS4zMzc2NzQsImV4cCI6MTY4MTIxMTQyNS4zMTYwODcsInN1YiI6IjcyIiwic2NvcGVzIjpbXX0.Wwu42dAyPgFblUW3LteWbZ4F1RDK5pLIRBIBqsQvI6-F0JuRvV8e27H0tgOB88OvUXfLdwoTaNycn7HPXmvUzRT6HSugrSF4QmwMQCBthibHvc3vdVICmYE5k7Qyobt8o6Hm_jV243xiv78DVCvljtb-Mvs4_f6565EbxEahruZK46aSFT72WMx77QiJl-R5wnoy9Mqi5O9O4wK_by_qq6x11VafXZwFZtIMirYuhWK_Zx5_kfuN-EhDlYKskmjCjOYmMp87gxZ91c1NoGVc0g9M01iGqnq9nAcwWSjw9k4OjbFFJtA9GSccqPWAPaRyCmvZoh-o3vg7fX-eo89if0fLDmdGFtLGzX24cycIqTIlzGGR0kkS6XLnbzHw4qPDPZvvmkNA8b_F04s_791iDE5RJ2Qo8NYep993iFYzSiVhT_B0i1wfgyDswZ3dO4X0NHS8daUX8H-rrvra_3LWzD9DY6GXhUs1yYcfoBHp9h7juQjTUFmj47V0tK_8EQB_fbztlNR17eHAYdm5mJfidx705ZXWtisb9jH_o3eoOt3fExRZW3UXyUz7cjROVPDvR0jFz4yxp8u8s4bsGaSwDRqbM-xiVCVI9USCI_o2N0bLxs2gJHJMMNM3dr9sXYLwQgLfUzatcKGoelylDrNdX6Asc5zsTt6y5rftBLXsq7I";
    TextInputEditText data;
    DatePickerDialog datePickerDialog;
    String datastr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calls);
        callsrecycler = findViewById(R.id.callsrecyclerview);






    }
    public void calender_click(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(Calls.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                     data = findViewById(R.id.data_edittext);
                       datastr=(year)+""+"-"+(month + 1) +""+"-"+(dayOfMonth)+"";
                        data.setText(datastr);
                        displaycalls();

                    }
                }, mYear, mMonth, mDay);

        datePickerDialog.show();

    }
    void displaycalls(){
    String token="Bearer " +ACESSTOKEN;
        String  getdate1=data.getText().toString();
        RetorfitClient.getClient().displaycalls(getdate1,token).enqueue(new Callback<DisplayCallsResponse>() {
            @Override
            public void onResponse(Call<DisplayCallsResponse> call, Response<DisplayCallsResponse> response) {

 if(response.body().issucess()){
     handlesucessresponse(response);

 }else {

     handleerrorresponse(response);
 }
            }

            @Override
            public void onFailure(Call<DisplayCallsResponse> call, Throwable t) {
                Toast.makeText(Calls.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void handleerrorresponse(Response<DisplayCallsResponse> response) {
        try {
            String errormessagaderesponse = response.errorBody().string();
            Toast.makeText(Calls.this,errormessagaderesponse, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handlesucessresponse(Response<DisplayCallsResponse>response) {
        if ( response.isSuccessful()){
            Toast.makeText(Calls.this, "show data", Toast.LENGTH_SHORT).show();
            callslist=response.body().getData();
            if(callslist.isEmpty()){
                Toast.makeText(this, "no calls with this date", Toast.LENGTH_SHORT).show();
                CallsAdapter callsAdapter = new CallsAdapter(callslist);
                callsAdapter.notifyDataSetChanged();
                callsrecycler.setAdapter(callsAdapter);

            }else {
                CallsAdapter callsAdapter = new CallsAdapter(callslist);
                callsAdapter.notifyDataSetChanged();
                callsrecycler.setAdapter(callsAdapter);


            }
        }else {
            String messagebody=response.message();
            Toast.makeText(Calls.this, messagebody, Toast.LENGTH_LONG).show();
        }
    }



    public void add_click(View view) {
        Intent intent=new Intent(Calls.this,CreateCall.class);
        startActivity(intent);
    }
}