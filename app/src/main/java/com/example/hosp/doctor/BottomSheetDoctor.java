package com.example.hosp.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hosp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.zip.Inflater;

public class BottomSheetDoctor extends BottomSheetDialogFragment {
    public BottomSheetDoctor() {

    }
Button mrecord,mmeasurment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.medical_dailog,container,false);
        mrecord=view.findViewById(R.id.medicalrecord);
        mmeasurment=view.findViewById(R.id.medicalmeasurment);
        mrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MedicalRecord.class);
                startActivity(intent);
            }
        });
        mmeasurment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MedicalMeasurment.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
