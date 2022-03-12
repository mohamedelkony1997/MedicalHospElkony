package com.example.hosp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class receptionistAdapter extends RecyclerView.Adapter<receptionistAdapter.viewholder>{
List<Doctorsclass>docprofiles;

    public receptionistAdapter(List<Doctorsclass> docprofiles) {
        this.docprofiles = docprofiles;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorsitems,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull receptionistAdapter.viewholder holder, int position) {
    Doctorsclass contact=docprofiles.get(position);
    holder.doctorname.setText(contact.getDoctorname());
    holder.doctorspecilize.setText(contact.doctorsSpecialties);
    }

    @Override
    public int getItemCount() {
       if(docprofiles==null) return 0;
       return docprofiles.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView doctorname,doctorspecilize;

        RadioButton doctorstatusbtn;
        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            doctorname=itemView.findViewById(R.id.doctor_name);
            doctorspecilize=itemView.findViewById(R.id.specializedoctors_text);

            doctorstatusbtn=itemView.findViewById(R.id.statusdoctors_radio_btn);


        }
    }
}
