package com.example.shristi2k24;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class past_adapter extends RecyclerView.Adapter<past_adapter.ViewHolder> {
List<List> arr=new ArrayList<>();
Context context;
String key;
public past_adapter(Context context, List<List> arr,String key){
    this.arr=arr;
    this.key=key;
    this.context=context;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.past_design, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    if(!key.equals("talk")) {
        holder.txt.setText(arr.get(position).get(1).toString());
        holder.talk.loadData(arr.get(position).get(0).toString(), "text/html", "utf-8");
        holder.talk.getSettings().setJavaScriptEnabled(true);
        holder.talk.setWebChromeClient(new WebChromeClient());
        holder.talk.setBackgroundColor(Color.TRANSPARENT);
    }
    else{
        holder.talk.setVisibility(View.GONE);
        Picasso.get().load(arr.get(position).get(0).toString()).into(holder.img);
        holder.img.setVisibility(View.VISIBLE);
        holder.txtl.setTextSize(18);
        holder.txt.setTextColor(context.getResources().getColor(R.color.whiteclr));
        holder.txtl.setTextColor(context.getResources().getColor(R.color.whiteclr));
        holder.ll.setCardBackgroundColor(context.getResources().getColor(R.color.blackbg));
        holder.txt.setText(arr.get(position).get(1).toString());
        holder.txtr.setVisibility(View.GONE);
        holder.txtl.setText(arr.get(position).get(2).toString());
    }
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

     WebView talk;
     ImageView img;
     TextView txt,txtl,txtr;
     CardView ll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            talk=itemView.findViewById(R.id.pastdesign_webpg);
            txt=itemView.findViewById(R.id.text_home_pastdesign);
            ll=itemView.findViewById(R.id.event_past_ll);
            txtl=itemView.findViewById(R.id.scrolll);
            txtr=itemView.findViewById(R.id.scrollr);
            img=itemView.findViewById(R.id.past_desginimg);
        }
    }
}
