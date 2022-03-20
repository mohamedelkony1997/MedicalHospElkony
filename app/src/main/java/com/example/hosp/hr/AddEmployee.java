package com.example.hosp.hr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.hosp.R;

public class AddEmployee extends AppCompatActivity {
AutoCompleteTextView autoCompleteTextView;
ArrayAdapter<String> stringArrayAdapter;
String[]items={"Male","female"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        autoCompleteTextView=findViewById(R.id.gender_inputlayout_edittext);
stringArrayAdapter=new ArrayAdapter<String>(this,R.layout.listitemgender,items);

           autoCompleteTextView.setAdapter(stringArrayAdapter);
    }
}