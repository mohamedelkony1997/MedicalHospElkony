package com.example.hosp.manger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.hosp.Calls;
import com.example.hosp.CreateReports;
import com.example.hosp.R;
import com.example.hosp.Reports;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainTasks extends AppCompatActivity implements maintaskitemrecyclerinterface {
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tasks);
    }
    public void calender_click(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(MainTasks.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        TextInputEditText data = findViewById(R.id.tasks_edittext);

                        String datastr=(dayOfMonth)+" " + "/" + (month + 1) +" " + "/" + (year) +" ";
                        data.setText(datastr);


                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }


    public void add_click(View view) {
        Intent intent = new Intent(MainTasks.this, AddTaskManger.class);
        startActivity(intent);
    }

    @Override
    public void onitemclick(int position) {

    }
}