package com.example.hosp.doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.R;
import com.example.hosp.Tasksclass;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NurseAdapter extends RecyclerView.Adapter<NurseAdapter.viewholder>  {
List<Nurseclass>names;



    public NurseAdapter(List<Nurseclass> names) {
        this.names = names;

    }

    @NonNull
    @NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.nursesitems,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NurseAdapter.viewholder holder, int position) {
   Nurseclass contact=names.get(position);
    holder.nursename.setText(contact.getNursename());

    }

    @Override
    public int getItemCount() {
       if(names==null) return 0;
       return names.size();
    }



    class viewholder extends RecyclerView.ViewHolder{
        TextView nursename;
        ImageView statusimage;
        public viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            nursename=itemView.findViewById(R.id.nurse_name);

            statusimage=itemView.findViewById(R.id.profile_nurse_image);



        }
    }
}
