package com.example.shristi2k24;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeDept_adapter extends RecyclerView.Adapter<HomeDept_adapter.ViewHolder> {
ArrayList<String> arr=new ArrayList<>();
Context context;
public HomeDept_adapter(Context context,ArrayList<String> arr){
    this.arr=arr;
    this.context=context;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dept_home, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.title.setText(arr.get(position));
int ii=position;
holder.cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(context, EventPage.class);
        String s=arr.get(ii);
        i.putExtra("dept",s);
        i.putExtra("authenticate","home");
        context.startActivity(i);

    }
});
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.text_home_deptdesign);
            cardView=itemView.findViewById(R.id.dept_home_ll);
        }
    }
}
