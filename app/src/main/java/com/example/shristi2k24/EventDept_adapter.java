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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class EventDept_adapter extends RecyclerView.Adapter<EventDept_adapter.ViewHolder> {
List<List> arr=new ArrayList<>();
Context context;
String dept;
String activity;
public EventDept_adapter(Context context, List<List> arr,String activity,String dept){
    this.arr=arr;
    this.dept=dept;
    this.context=context;
    this.activity=activity;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_design, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.title.setText(arr.get(position).get(0).toString());

        Picasso.get().load(arr.get(position).get(1).toString()).into(holder.img);
int ii=position;
holder.date.setText(arr.get(position).get(2).toString());
holder.time.setText(arr.get(position).get(3).toString());
        //holder.desc.setText(arr.get(position).get(4).toString());
        //holder.venue.setText(arr.get(position).get(5).toString());

if(activity.equals("sc")){
    holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.fullTransparent));
}
holder.cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(activity.equals("incharge")) {
            Intent i = new Intent(context,incharge_page1.class);
            i.putExtra("event", (String) arr.get(ii).get(0));
            i.putExtra("desc", (String) arr.get(ii).get(4));
            i.putExtra("venue", (String) arr.get(ii).get(5));
            i.putExtra("img", (String) arr.get(ii).get(1));
            i.putExtra("dept", dept);
            i.putExtra("date", (String) arr.get(ii).get(2));
            i.putExtra("time", (String) arr.get(ii).get(3));
            v.getContext().startActivity(i);
        }
else if(activity.equals("sc")){
            Intent i = new Intent(v.getContext(), EventDashboard.class);
            i.putExtra("event", (String) arr.get(ii).get(0));
            i.putExtra("desc", (String) arr.get(ii).get(4));
            i.putExtra("img", (String) arr.get(ii).get(1));
            i.putExtra("dept", (dept));
            i.putExtra("for","noresult");
            i.putExtra("venue", (String) arr.get(ii).get(5));
            i.putExtra("date", (String) arr.get(ii).get(2));
            i.putExtra("time", (String) arr.get(ii).get(3));
            v.getContext().startActivity(i);

        }
else if(activity.equals("talkh")){
    holder.time.setVisibility(View.GONE);
    holder.title.setText(arr.get(position).get(1).toString());
    holder.date.setText(arr.get(position).get(2).toString());
    if(arr.get(position).get(0)!=""){
        Picasso.get().load(arr.get(position).get(0).toString()).into(holder.img);
    }
        }

        else{
            Intent i = new Intent(v.getContext(), EventDashboard.class);
            i.putExtra("event", (String) arr.get(ii).get(0));
            i.putExtra("desc", (String) arr.get(ii).get(4));
            i.putExtra("img", (String) arr.get(ii).get(1));
            i.putExtra("dept", (dept));
            i.putExtra("venue", (String) arr.get(ii).get(5));
            i.putExtra("date", (String) arr.get(ii).get(2));
            i.putExtra("time", (String) arr.get(ii).get(3));
            v.getContext().startActivity(i);
        }

    }
});
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,date,time;
        CardView cardView;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.text_home_eventdesign);
            cardView=itemView.findViewById(R.id.event_home_ll);
            date=itemView.findViewById(R.id.event_datedesign);
            time=itemView.findViewById(R.id.event_timedesign);
            img=itemView.findViewById(R.id.img_home_eventdesign);
        }
    }
}
