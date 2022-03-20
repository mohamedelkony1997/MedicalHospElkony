package com.example.hosp.doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.R;

import java.util.List;

public class CasesAdapter extends RecyclerView.Adapter<CasesAdapter.viewholder>{
List<Casesclass>names;
    private final  casesitemrecyclerinterface casesitemrecyclerinterface;
    Context context;
    public CasesAdapter(List<Casesclass> names, com.example.hosp.doctor.casesitemrecyclerinterface casesitemrecyclerinterface, Context context) {
        this.names = names;
        this.casesitemrecyclerinterface = casesitemrecyclerinterface;
        this.context = context;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cases_items,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull CasesAdapter.viewholder holder, int position) {
        Casesclass contact=names.get(position);
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(casesitemrecyclerinterface!=null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            casesitemrecyclerinterface.onitemclick(pos);
                        }

                    }
                }
            });


        }
    }
}
