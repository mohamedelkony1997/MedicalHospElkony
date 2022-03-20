package com.example.hosp.doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.R;
import com.example.hosp.Tasksclass;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MedicalAdapter extends RecyclerView.Adapter<MedicalAdapter.viewholder>  {
List<MedicalClass>names;


    public MedicalAdapter(List<MedicalClass> names ) {
        this.names = names;

    }

    @NonNull
    @NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.medical_items,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MedicalAdapter.viewholder holder, int position) {
   MedicalClass medicalClass=names.get(position);
    holder.medicalbtnname.setText(medicalClass.getNamebtn());
    }

    @Override
    public int getItemCount() {
       if(names==null) return 0;
       return names.size();
    }



    class viewholder extends RecyclerView.ViewHolder{
        Button medicalbtnname;

        public viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            medicalbtnname=itemView.findViewById(R.id.medicalnamebtn);



        }
    }
}
