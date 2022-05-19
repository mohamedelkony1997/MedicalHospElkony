package com.example.hosp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.hosiptal.RetorfitClient;
import com.example.hosp.hosiptal.models.ErrorResponse;
import com.example.hosp.hosiptal.models.displaycalls.DataItemDisplayCalls;
import com.example.hosp.hosiptal.models.displaycalls.DisplayCallsRequest;
import com.example.hosp.hosiptal.models.displaycalls.DisplayCallsResponse;
import com.example.hosp.hosiptal.models.login.LoginResponse;
import com.example.hosp.hosiptal.models.register.RegisterRequest;
import com.example.hosp.hosiptal.models.register.RegisterResponse;
import com.example.hosp.hr.AddEmployee;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallsAdapter extends RecyclerView.Adapter<CallsAdapter.viewholder> {
    List<DataItemDisplayCalls> calls;

    public CallsAdapter(List<DataItemDisplayCalls> calls) {
        this.calls = calls;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.call_items, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull CallsAdapter.viewholder holder, int position) {

        DataItemDisplayCalls callsClass = calls.get(position);
        holder.callsname.setText(callsClass.getPatientName());
        holder.callsdata.setText(callsClass.getCreatedAt());
        if (callsClass.getStatus().equals("pending_doctor")){
            holder.callsstatus.setImageResource(R.drawable.process);
        }else{
            holder.callsstatus.setImageResource(R.drawable.checkbox_mark);
        }

    }

    @Override
    public int getItemCount() {
        if (calls == null) return 0;
        return calls.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        TextView callsname, callsdata;
        ImageView callsstatus;


        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            callsname = itemView.findViewById(R.id.doctorcalls_name);
            callsdata = itemView.findViewById(R.id.datacalls_text);
            callsstatus = itemView.findViewById(R.id.statuscalls_image);


        }


    }
}