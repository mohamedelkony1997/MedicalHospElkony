package com.example.hosp.doctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.CallsClass;
import com.example.hosp.R;

import java.util.List;

public class DoctorsCallsAdapter extends RecyclerView.Adapter<DoctorsCallsAdapter.viewholder>{
List<DoctorsCallsClass>names;

    public DoctorsCallsAdapter(List<DoctorsCallsClass> names) {
        this.names = names;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorscall_items,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull DoctorsCallsAdapter.viewholder holder, int position) {
    DoctorsCallsClass contact=names.get(position);
    holder.callsname.setText(contact.getCallaname());
    holder.callsdata.setText(contact.getCallsdata());
    }

    @Override
    public int getItemCount() {
       if(names==null) return 0;
       return names.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView callsname,callsdata;
        Button accept,busy;
        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            callsname=itemView.findViewById(R.id.doctorcalls_name);
            callsdata=itemView.findViewById(R.id.datacalls_text);



        }
    }
}
