package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hosp.analysis.AnalysisEmployeeHomePage;
import com.example.hosp.analysis.RequestsDetails;
import com.example.hosp.doctor.DoctorHomePage;
import com.example.hosp.hosiptal.RetorfitClient;

import com.example.hosp.hosiptal.models.ErrorResponse;
import com.example.hosp.hosiptal.models.login.LoginData;
import com.example.hosp.hosiptal.models.login.LoginRequest;
import com.example.hosp.hosiptal.models.login.LoginResponse;
import com.example.hosp.hosiptal.models.register.RegisterRequest;
import com.example.hosp.hr.AddEmployee;
import com.example.hosp.hr.Employee;
import com.example.hosp.hr.HrHomePage;
import com.example.hosp.hr.Profile;
import com.example.hosp.manger.CasesDetialsMAnger;
import com.example.hosp.manger.CasesManger;
import com.example.hosp.manger.MainTasks;
import com.example.hosp.manger.MaintasksDetails;
import com.example.hosp.manger.MangerHomePage;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
TextInputEditText email,password;
    String emailstr,passwordstr;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email_edittext);
        password=findViewById(R.id.password_edittext);

    }

    public void login_btn(View view) {
            login();
    }
    void  login() {
        emailstr = email.getText().toString();
        passwordstr = password.getText().toString();

            LoginRequest loginRequest = new LoginRequest(emailstr, passwordstr, "sdfsfsdfsdfsdfsfs");
            RetorfitClient.getClient().login(loginRequest).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        handlesucessresponse(response);
                    } else {
                        handleerrorresponse(response);

                    }

                }


                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(Login.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }


    private void handleerrorresponse(Response<LoginResponse> response) {
        try {
            String errormessagaderesponse = response.errorBody().string();

            Gson gson=new Gson();
            ErrorResponse errormessagaderesponseobject=gson.fromJson(errormessagaderesponse, ErrorResponse.class);
            String errormessage=errormessagaderesponseobject.getMessage();
            Toast.makeText(Login.this,errormessage, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handlesucessresponse(Response<LoginResponse> response) {
        if ( response.body().issucess()){
            Toast.makeText(this, "it is exists", Toast.LENGTH_SHORT).show();
            type = response.body().getLoginData().getType();


            if (type.equals("doctor")) {
                String doctorFirstname = response.body().getLoginData().getFirstName();
                String doctorLastname = response.body().getLoginData().getLastName();
                String specialistdoctor = response.body().getLoginData().getSpecialist();

                SharedPreferences sharedPreferences = getSharedPreferences("DOCTORPREFS", MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("DRhomepagefirst", doctorFirstname);
                editor.putString("DRhomepagelast", doctorLastname);
                editor.putString("DRhomepagespecilaist", specialistdoctor);
                editor.commit();
                editor.apply();
                Intent intent = new Intent(Login.this, DoctorHomePage.class);
                startActivity(intent);
            } else if (type.equals("hr")) {

                Intent intent = new Intent(Login.this, HrHomePage.class);
                startActivity(intent);

            } else if (type.equals("receptionist")) {

                String receptionistFirstname = response.body().getLoginData().getFirstName();
                String receptionistLastname = response.body().getLoginData().getLastName();
                String receptionistdoctor = response.body().getLoginData().getSpecialist();
                String receptionistgender=response.body().getLoginData().getGender();
                String birth=response.body().getLoginData().getBirthday();
                String address=response.body().getLoginData().getAddress();
                String status=response.body().getLoginData().getStatus();
                String email=response.body().getLoginData().getEmail();
                String phone=response.body().getLoginData().getMobile();
                SharedPreferences sharedPreferences = getSharedPreferences("RECEPTIONISTPREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("REChomepagefirst", receptionistFirstname);
                editor.putString("REChomepagelast", receptionistLastname);
                editor.putString("REChomepagespecilaist", receptionistdoctor);
                editor.putString("REChomepagegender", receptionistgender);
                editor.putString("REChomepagebirth", birth);
                editor.putString("REChomepageaddress", address);
                editor.putString("REChomepagestatus", status);
                editor.putString("REChomepageemail", email);
                editor.putString("REChomepagephone", phone);
                editor.apply();

                Intent intent = new Intent(Login.this, Receptionist_homepage.class);
                startActivity(intent);

            } else if (type.equals("Analysis")) {
                Intent intent = new Intent(Login.this, AnalysisEmployeeHomePage.class);
                startActivity(intent);

            } else if (type.equals("manger")) {
                Intent intent = new Intent(Login.this, MangerHomePage.class);
                startActivity(intent);

            }else if(type.equals("")) {
                Toast.makeText(Login.this, "no user found", Toast.LENGTH_SHORT).show();
                return;

            }


        }else {
            String messagebody=response.body().getMessage();
            Toast.makeText(Login.this, messagebody, Toast.LENGTH_LONG).show();
            return;
        }

    }
    }
