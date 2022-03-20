package com.example.hosp.hr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.R;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.viewholder>{
List<Employeeclass>docprofiles;
    private final employeeitemrecyclerinterface employeeitemrecyclerinterface;
    Context context;
    public EmployeeAdapter(List<Employeeclass> docprofiles, com.example.hosp.hr.employeeitemrecyclerinterface employeeitemrecyclerinterface, Context context) {
        this.docprofiles = docprofiles;
        this.employeeitemrecyclerinterface = employeeitemrecyclerinterface;
        this.context = context;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorsitems,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull EmployeeAdapter.viewholder holder, int position) {
        Employeeclass contact=docprofiles.get(position);
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(employeeitemrecyclerinterface!=null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            employeeitemrecyclerinterface.onitemclick(pos);
                        }

                    }
                }
            });

        }
    }
}
