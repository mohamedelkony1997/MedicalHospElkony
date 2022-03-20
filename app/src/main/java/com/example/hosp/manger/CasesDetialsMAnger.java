package com.example.hosp.manger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.hosp.R;

public class CasesDetialsMAnger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_detials_manger);
    }

    public void onmedicalmeasurment(View view) {
        replacefragment(new MedacalMeasurmentMangerFragment());
    }



    public void onmedicalrecord(View view) {
        replacefragment(new MedicalRecorMangerFragment());
    }

    public void oncasefragment(View view) {
        replacefragment(new CaseFragmentManger());
    }
    private void replacefragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framfragment,fragment);
        fragmentTransaction.commit();
    }
}