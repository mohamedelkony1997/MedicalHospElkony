package com.example.hosp.hr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.hosp.Calls;
import com.example.hosp.Login;
import com.example.hosp.R;
import com.example.hosp.hosiptal.RetorfitClient;
import com.example.hosp.hosiptal.models.ErrorResponse;
import com.example.hosp.hosiptal.models.login.LoginResponse;
import com.example.hosp.hosiptal.models.register.RegisterRequest;
import com.example.hosp.hosiptal.models.register.RegisterResponse;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEmployee extends AppCompatActivity {
AutoCompleteTextView gender ,specilist,status;
MaterialButton adduser;
    TextInputEditText firstName,lastname,dataofbirth,phone,email,address,password;
ArrayAdapter<String> stringArrayAdapter,stringArrayAdapter2,stringArrayAdapter3;
    DatePickerDialog datePickerDialog;
    String firstNamestr,lastnamestr,dataofbirthstr,phonestr,emailstr,addressstr,passwordstr ,genderstr ,speciliststr,statusstr;
String[]items={"Male","female"};
    String[]items2={"Doctor","Specialist","Nurse","Analysis","Hr","manger"};
    String[]items3={"Single","Married"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        adduser=findViewById(R.id.adduser);
        gender = findViewById(R.id.gender_inputlayout_edittext);
        specilist = findViewById(R.id.specialist_inputlayout_edittext);
        status = findViewById(R.id.status_edittext);
        firstName=findViewById(R.id.firstname_edittext);
        lastname=findViewById(R.id.lastname_edittext);
        dataofbirth= findViewById(R.id.dataofbirth_edittext);
        phone=findViewById(R.id.phone_edittext);
        email=findViewById(R.id.email_edittext);
        address =findViewById(R.id.location_edittext);
        password=findViewById(R.id.password_edittext);

        stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.listitemgender, items);

        gender.setAdapter(stringArrayAdapter);
        stringArrayAdapter2 = new ArrayAdapter<String>(this, R.layout.listitemspecialist, items2);

        specilist.setAdapter(stringArrayAdapter2);
        stringArrayAdapter3 = new ArrayAdapter<String>(this, R.layout.listitemstatus, items3);

        status.setAdapter(stringArrayAdapter3);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            register();
            }
        });
    }

    public void oncalender(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(AddEmployee.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // set day of month , month and year value in the edit text


                        String datastr=(year) +" " + "-" + (month + 1) +" " + "-" +(dayOfMonth)   +" ";
                        dataofbirth.setText(datastr);


                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }
    void register(){
        firstNamestr=firstName.getText().toString();
        lastnamestr=lastname.getText().toString();
        dataofbirthstr=dataofbirth.getText().toString();
        phonestr=phone.getText().toString();
        emailstr=email.getText().toString();
        addressstr=address.getText().toString();
        passwordstr=password.getText().toString();
        genderstr=gender.getText().toString();
        speciliststr=specilist.getText().toString();
        statusstr=status.getText().toString();
        RegisterRequest registerRequest=new RegisterRequest(emailstr,passwordstr,firstNamestr,lastnamestr,genderstr,speciliststr,dataofbirthstr,
                statusstr,addressstr,phonestr,"doctor");

        RetorfitClient.getClient().register(registerRequest).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                System.out.println( response.code());
                if (response.isSuccessful()) {
                    handlesucessresponse(response);
                } else {
                    handleerrorresponse(response);

                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(AddEmployee.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }
    private void handleerrorresponse(Response<RegisterResponse> response) {
        try {
            String errormessagaderesponse = response.errorBody().string();

            Gson gson=new Gson();
            ErrorResponse errormessagaderesponseobject=gson.fromJson(errormessagaderesponse, ErrorResponse.class);
            String errormessage=errormessagaderesponseobject.getMessage();
            Toast.makeText(AddEmployee.this,errormessage, Toast.LENGTH_LONG).show();
        } catch ( IOException exception) {
            exception.printStackTrace();
        }

    }

    private void handlesucessresponse(Response<RegisterResponse> response) {
        if ( response.body().issucess()){
            Toast.makeText(this, "created", Toast.LENGTH_LONG).show();

        }else {
            String messagebody=response.body().getMessage();
            Toast.makeText(AddEmployee.this, messagebody, Toast.LENGTH_LONG).show();
        }
    }

}