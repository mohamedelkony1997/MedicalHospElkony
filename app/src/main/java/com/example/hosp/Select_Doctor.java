package com.example.hosp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hosp.hosiptal.RetorfitClient;
import com.example.hosp.hosiptal.models.selectdoctors.DataSelectDoctorsItems;
import com.example.hosp.hosiptal.models.selectdoctors.SelectDoctorsResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Select_Doctor extends AppCompatActivity implements receptionistAdapter.OnSelectDoctor  {
    public static String ACESSTOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNTYxODAyOTAwZjBhMTAyZTc3ZjAwODA4ZDVmZDRlMTRlZTQ0NDI4Zjk3MTcwMmE0OWFjN2YxZDJhYzYyMzliYjljNzI5MWJmOTkyNWNhNDciLCJpYXQiOjE2NDk2NzU0MjUuMzM3NjcsIm5iZiI6MTY0OTY3NTQyNS4zMzc2NzQsImV4cCI6MTY4MTIxMTQyNS4zMTYwODcsInN1YiI6IjcyIiwic2NvcGVzIjpbXX0.Wwu42dAyPgFblUW3LteWbZ4F1RDK5pLIRBIBqsQvI6-F0JuRvV8e27H0tgOB88OvUXfLdwoTaNycn7HPXmvUzRT6HSugrSF4QmwMQCBthibHvc3vdVICmYE5k7Qyobt8o6Hm_jV243xiv78DVCvljtb-Mvs4_f6565EbxEahruZK46aSFT72WMx77QiJl-R5wnoy9Mqi5O9O4wK_by_qq6x11VafXZwFZtIMirYuhWK_Zx5_kfuN-EhDlYKskmjCjOYmMp87gxZ91c1NoGVc0g9M01iGqnq9nAcwWSjw9k4OjbFFJtA9GSccqPWAPaRyCmvZoh-o3vg7fX-eo89if0fLDmdGFtLGzX24cycIqTIlzGGR0kkS6XLnbzHw4qPDPZvvmkNA8b_F04s_791iDE5RJ2Qo8NYep993iFYzSiVhT_B0i1wfgyDswZ3dO4X0NHS8daUX8H-rrvra_3LWzD9DY6GXhUs1yYcfoBHp9h7juQjTUFmj47V0tK_8EQB_fbztlNR17eHAYdm5mJfidx705ZXWtisb9jH_o3eoOt3fExRZW3UXyUz7cjROVPDvR0jFz4yxp8u8s4bsGaSwDRqbM-xiVCVI9USCI_o2N0bLxs2gJHJMMNM3dr9sXYLwQgLfUzatcKGoelylDrNdX6Asc5zsTt6y5rftBLXsq7I";
    List<DataSelectDoctorsItems> doctorsItems;
    RecyclerView doctorsreRecyclerView;
    receptionistAdapter doctorsAdapter;
    String selectname, selectid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doctor);
        doctorsreRecyclerView = findViewById(R.id.recycler_doctor);


        showdoctors();
    }


    void showdoctors() {
        String token = "Bearer " + ACESSTOKEN;
        String type = "doctor";
        RetorfitClient.getClient().selectdoctors(type, token).enqueue(new Callback<SelectDoctorsResponse>() {
            @Override
            public void onResponse(Call<SelectDoctorsResponse> call, Response<SelectDoctorsResponse> response) {
                if (response.isSuccessful()) {
                    handlesucessresponse(response);

                } else {

                    handleerrorresponse(response);
                }
            }

            @Override
            public void onFailure(Call<SelectDoctorsResponse> call, Throwable t) {
                Toast.makeText(Select_Doctor.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void handleerrorresponse(Response<SelectDoctorsResponse> response) {
        try {
            String errormessagaderesponse = response.errorBody().string();
            Toast.makeText(Select_Doctor.this, errormessagaderesponse, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handlesucessresponse(Response<SelectDoctorsResponse> response) {
        if (response.isSuccessful()) {
            Toast.makeText(Select_Doctor.this, "show doctors", Toast.LENGTH_SHORT).show();
            doctorsItems = response.body().getData();

            doctorsAdapter = new receptionistAdapter(doctorsItems ,this);

            doctorsAdapter.notifyDataSetChanged();
            doctorsreRecyclerView.setAdapter(doctorsAdapter);


        } else {
            String messagebody = response.message();
            Toast.makeText(Select_Doctor.this, messagebody, Toast.LENGTH_LONG).show();
        }
    }







    @Override
    public void onselectdoctor(Intent intent) {
        selectname =intent.getStringExtra("namedoc");
        selectid= intent.getStringExtra("iddoc");
    }
    public void backtothehome(View view) {
  Intent intent=new Intent();
  intent.putExtra("doctorname",selectname);
  intent.putExtra("doctorid",selectid);
  setResult(RESULT_OK,intent);
  finish();
    }
}
