package com.example.hosp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.viewholder>  {
List<Tasksclass>names;
private final  taskitemrecyclerinterface taskitemrecyclerinterface;
Context context;

    public TasksAdapter(List<Tasksclass> names, com.example.hosp.taskitemrecyclerinterface taskitemrecyclerinterface, Context context) {
        this.names = names;
        this.taskitemrecyclerinterface = taskitemrecyclerinterface;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.task_items,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull TasksAdapter.viewholder holder, int position) {
    Tasksclass contact=names.get(position);
    holder.tasksname.setText(contact.getTaskname());
    holder.tasksdata.setText(contact.getTaskdata());
    }

    @Override
    public int getItemCount() {
       if(names==null) return 0;
       return names.size();
    }



    class viewholder extends RecyclerView.ViewHolder{
        TextView tasksname,tasksdata,tasksstatusttext;
        ImageView statusimage;
        public viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            tasksname=itemView.findViewById(R.id.task_name);
            tasksdata=itemView.findViewById(R.id.datatask_text);
            statusimage=itemView.findViewById(R.id.imagetaskcalender);
            tasksstatusttext=itemView.findViewById(R.id.tasksstatus);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(taskitemrecyclerinterface!=null){
                         int pos=getAdapterPosition();
                         if(pos!=RecyclerView.NO_POSITION){
                             taskitemrecyclerinterface.onitemclick(pos);
                         }

                    }
                }
            });


        }
    }
}
