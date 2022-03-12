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

public class ReportsAdapter extends RecyclerView.Adapter<ReportsAdapter.viewholder>  {
List<Reportsclass>names;
private final  taskitemrecyclerinterface taskitemrecyclerinterface;
Context context;

    public ReportsAdapter(List<Reportsclass> names, com.example.hosp.taskitemrecyclerinterface taskitemrecyclerinterface, Context context) {
        this.names = names;
        this.taskitemrecyclerinterface = taskitemrecyclerinterface;
        this.context = context;
    }

    @NonNull
    @NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.report_items,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ReportsAdapter.viewholder holder, int position) {
    Reportsclass contact=names.get(position);
    holder.reportsname.setText(contact.getReportsname());
    holder.reportsdata.setText(contact.getReportdata());
    }

    @Override
    public int getItemCount() {
       if(names==null) return 0;
       return names.size();
    }



    class viewholder extends RecyclerView.ViewHolder{
        TextView reportsname,reportsdata,reportsstatusttext;

        public viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            reportsname=itemView.findViewById(R.id.reports_name);
            reportsdata=itemView.findViewById(R.id.datareport_text);

            reportsstatusttext=itemView.findViewById(R.id.statusreports);



        }
    }
}
