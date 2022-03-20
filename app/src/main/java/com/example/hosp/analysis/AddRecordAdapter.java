package com.example.hosp.analysis;

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

public class AddRecordAdapter extends RecyclerView.Adapter<AddRecordAdapter.viewholder>{
List<AddrecordClass>names;


    public AddRecordAdapter(List<AddrecordClass> names) {
        this.names = names;

    }

    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.analysis_items,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull AddRecordAdapter.viewholder holder, int position) { AddrecordClass contact=names.get(position);
    holder.casename.setText(contact.getCaseaname());

    }

    @Override
    public int getItemCount() {
       if(names==null) return 0;
       return names.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView casename;

        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            casename=itemView.findViewById(R.id.analysisrequests_name);



        }
    }
}
