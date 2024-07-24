package com.example.shristi2k24;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class Participant_adapter extends RecyclerView.Adapter<Participant_adapter.ViewHolder> {
    List<List> arr=new ArrayList<>();
    String activity;
    String event,dept;
    Context context;
    String key;
    public Participant_adapter(Context context, List<List> arr,String activity,String event,String dept,String key){
        this.arr=arr;
        this.event=event;
        this.key=key;
        this.dept=dept;
        this.context=context;
        this.activity=activity;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_participant_design, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       if(key.equals("")) {
           holder.name.setText(arr.get(position).get(0).toString());
           String name = arr.get(position).get(0).toString();
           String college = arr.get(position).get(1).toString();
           String phone = arr.get(position).get(2).toString();
           String timevalue = arr.get(position).get(3).toString();
           String score = "score";
           String time = "time";
           String scorevalue = arr.get(position).get(4).toString();
           holder.college.setText(college);
           if(timevalue.equals("1")) {
               holder.timevalue.setText(timevalue+"st");
           }
           else if(timevalue.equals("2")) {
               holder.timevalue.setText(timevalue+"nd");
           }
           else{
               holder.timevalue.setText(timevalue+"rd");
           }
           if (activity.equals("Participant_Edit")) {
               holder.edit.setVisibility(View.VISIBLE);
           } else {
               holder.edit.setVisibility(View.GONE);
           }

           holder.edit.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i = new Intent(context, add_participant.class);
                   i.putExtra("operation", "edit");
                   i.putExtra("name", name);
                   i.putExtra("phone", phone);
                   i.putExtra("college", college);
                   i.putExtra("dept", dept);
                   i.putExtra("event", event);
                   i.putExtra("time", time);
                   i.putExtra("timevalue", timevalue);
                   i.putExtra("score", score);
                   i.putExtra("scorevalue", scorevalue);
                   context.startActivity(i);
               }
           });


       }
       else{
           holder.name.setText(arr.get(position).get(0).toString());

       }
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,college,timevalue,time;
        CardView cardView;
        ImageView edit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.pname);
            cardView=itemView.findViewById(R.id.participant_cardview);
            college=itemView.findViewById(R.id.pcollege);
            timevalue=itemView.findViewById(R.id.ptimevalue);
            time=itemView.findViewById(R.id.ptime);
            edit=itemView.findViewById(R.id.pedit);

        }
    }
}
