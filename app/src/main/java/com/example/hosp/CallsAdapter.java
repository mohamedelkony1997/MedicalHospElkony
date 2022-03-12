package com.example.hosp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CallsAdapter extends RecyclerView.Adapter<CallsAdapter.viewholder>{
List<CallsClass>names;

    public CallsAdapter(List<CallsClass> names) {
        this.names = names;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.call_items,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull CallsAdapter.viewholder holder, int position) {
    CallsClass contact=names.get(position);
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
        ImageView callsstatus;
        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            callsname=itemView.findViewById(R.id.doctorcalls_name);
            callsdata=itemView.findViewById(R.id.datacalls_text);
            callsstatus=itemView.findViewById(R.id.statuscalls_image);


        }
    }
}
