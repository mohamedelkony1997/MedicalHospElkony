package com.example.hosp.doctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MeasurmentAdapter extends RecyclerView.Adapter<MeasurmentAdapter.viewholder>  {
List<MeasurmentClass>names;


    public MeasurmentAdapter(List<MeasurmentClass> names ) {
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
    public void onBindViewHolder(@NonNull @NotNull MeasurmentAdapter.viewholder holder, int position) {
        MeasurmentClass medicalClass=names.get(position);
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
            medicalbtnname=itemView.findViewById(R.id.mesurmentnamebtn);



        }
    }
}
