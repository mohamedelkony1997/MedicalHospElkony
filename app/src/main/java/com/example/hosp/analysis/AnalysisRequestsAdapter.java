package com.example.hosp.analysis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosp.R;

import java.util.List;

public class AnalysisRequestsAdapter extends RecyclerView.Adapter<AnalysisRequestsAdapter.viewholder>{
List<AnalysisRequestsClass>names;
    private final requestsitemrecyclerinterface requestsitemrecyclerinterface;
    Context context;

    public AnalysisRequestsAdapter(List<AnalysisRequestsClass> names, com.example.hosp.analysis.requestsitemrecyclerinterface requestsitemrecyclerinterface, Context context) {
        this.names = names;
        this.requestsitemrecyclerinterface = requestsitemrecyclerinterface;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull


    @Override
    public viewholder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorscall_items,parent,false);
return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull AnalysisRequestsAdapter.viewholder holder, int position) { AnalysisRequestsClass contact=names.get(position);
    holder.casename.setText(contact.getCaseaname());
    holder.data.setText(contact.getData());
        holder.doctorname.setText(contact.getDoctoename());
    }

    @Override
    public int getItemCount() {
       if(names==null) return 0;
       return names.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView casename,data,doctorname;
        Button accept,busy;
        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            casename=itemView.findViewById(R.id.analysisrequests_name);
            data=itemView.findViewById(R.id.datacalls_text);
            doctorname=itemView.findViewById(R.id.doctoranalysisrequests_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(requestsitemrecyclerinterface!=null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            requestsitemrecyclerinterface.onitemclick(pos);
                        }

                    }
                }
            });

        }
    }
}
