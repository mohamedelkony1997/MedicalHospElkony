package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class Reports extends AppCompatActivity implements  reportitemrecyclerinterface {
    DatePickerDialog datePickerDialog;
    RecyclerView reportsRecyclerView;
    ReportsAdapter reportsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        reportsRecyclerView=findViewById(R.id.Reportsrecyclerview);
    }

    public void add_click(View view) {
        Intent intent = new Intent(Reports.this, CreateReports.class);
        startActivity(intent);
    }

    public void calender_click(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(Reports.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        TextInputEditText data = findViewById(R.id.data_edittext);

                        String datastr=(dayOfMonth)+" " + "/" + (month + 1) +" " + "/" + (year) +" ";
                        data.setText(datastr);
                        System.out.println(datastr);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

    @Override
    public void onitemclick(int position) {

    }
}