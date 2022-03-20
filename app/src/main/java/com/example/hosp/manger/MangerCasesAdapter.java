package com.example.hosp.manger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.R;
import com.example.hosp.doctor.Casesclass;

import java.util.List;

public class MangerCasesAdapter extends RecyclerView.Adapter<MangerCasesAdapter.viewholder>{
List<MangerCasesclass>names;
    private final com.example.hosp.doctor.casesitemrecyclerinterface casesitemrecyclerinterface;
    Context context;
    public MangerCasesAdapter(List<MangerCasesclass> names, com.example.hosp.doctor.casesitemrecyclerinterface casesitemrecyclerinterface, Context context) {
        this.names = names;
        this.casesitemrecyclerinterface = casesitemrecyclerinterface;
        this.context = context;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cases_itemsmanger,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull MangerCasesAdapter.viewholder holder, int position) {
        MangerCasesclass contact=names.get(position);
    holder.casesname.setText(contact.getName());
    holder.casesdata.setText(contact.getData());
    }

    @Override
    public int getItemCount() {
       if(names==null) return 0;
       return names.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView casesname,casesdata;
        Button accept,busy;
        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            casesname=itemView.findViewById(R.id.cases_name);
            casesdata=itemView.findViewById(R.id.datacases_text);



        }
    }
}
