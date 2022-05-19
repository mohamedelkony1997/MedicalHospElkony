package com.example.hosp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.hosiptal.models.selectdoctors.DataSelectDoctorsItems;

import java.util.List;

public class receptionistAdapter extends RecyclerView.Adapter<receptionistAdapter.viewholder>{
List<DataSelectDoctorsItems>docprofiles;
OnSelectDoctor onSelectDoctor;
Context context;
    public receptionistAdapter(List<DataSelectDoctorsItems> docprofiles,Context context) {
        this.docprofiles = docprofiles;
        try {
            this.onSelectDoctor = ((OnSelectDoctor)context);
        }catch (ClassCastException classCastException){
            throw new ClassCastException();
        }

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
        DataSelectDoctorsItems doctors=docprofiles.get(position);
        holder.doctorname.setText(doctors.getFirstName());
        holder.doctorspecilize.setText("Specialist - "+doctors.getType());
        holder.profile.setImageResource(R.drawable.docavatar);

holder.doctorstatusbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
    intent.putExtra("namedoc",doctors.getFirstName());
    String  id=doctors.getId()+" ";
    intent.putExtra("iddoc",id);
onSelectDoctor.onselectdoctor(intent);

    }
});


    }

    @Override
    public int getItemCount() {
       if(docprofiles==null) return 0;
       return docprofiles.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView doctorname,doctorspecilize;
        RadioButton doctorstatusbtn;
        ImageView profile;
        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            doctorname=itemView.findViewById(R.id.doctor_name);
            doctorspecilize=itemView.findViewById(R.id.specializedoctors_text);
  profile=itemView.findViewById(R.id.profile_doctor_image);
            doctorstatusbtn=itemView.findViewById(R.id.statusdoctors_radio_btn);


        }
    }
    public interface OnSelectDoctor{
        void onselectdoctor( Intent intent);

    }



}
