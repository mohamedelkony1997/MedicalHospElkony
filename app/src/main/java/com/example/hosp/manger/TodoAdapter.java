package com.example.hosp.manger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.CallsClass;
import com.example.hosp.R;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.viewholder>{
List<Todoclass>names;

    public TodoAdapter(List<Todoclass> names) {
        this.names = names;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemmangeradd,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull TodoAdapter.viewholder holder, int position) {
        Todoclass contact=names.get(position);
    holder.taskname.setText(contact.getTaskname());

    }

    @Override
    public int getItemCount() {
       if(names==null) return 0;
       return names.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView taskname;

        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            taskname=itemView.findViewById(R.id.todo);



        }
    }
}
