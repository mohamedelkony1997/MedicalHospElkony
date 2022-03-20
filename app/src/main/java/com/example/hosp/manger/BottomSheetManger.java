package com.example.hosp.manger;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hosp.R;
import com.example.hosp.doctor.MedicalMeasurment;
import com.example.hosp.doctor.MedicalRecord;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;

public class BottomSheetManger extends BottomSheetDialogFragment {
    public BottomSheetManger() {

    }
Button add;
    TextInputEditText todo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.manger_dailog, container, false);
        add=view.findViewById(R.id.addtodo);
        todo=view.findViewById(R.id.description_edittext);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         String todostr=todo.getText().toString();
         Intent intent=new Intent(getContext(),AddTaskManger.class);
         intent.putExtra("todo",todostr);
         startActivity(intent);



            }
        });
        return view;

    }
}
