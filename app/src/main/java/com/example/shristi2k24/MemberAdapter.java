package com.example.shristi2k24;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {

Context context;
String key;
List<List> arr;
    public MemberAdapter(List<List> arr, Context context,String key){
        this.arr=arr;
        this.context=context;
        this.key=key;
    }

    @NonNull
    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.members_design,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MemberAdapter.ViewHolder holder, int position) {
        if(arr.get(position).get(1).equals("")) holder.img1.setVisibility(View.GONE);
        if(arr.get(position).get(5).equals("")) holder.img2.setVisibility(View.GONE);

        if(key.equals("faculity")) {
            holder.it3.setVisibility(View.VISIBLE);
            holder.it6.setVisibility(View.VISIBLE);
            holder.it2.setVisibility(View.VISIBLE);
            holder.it4.setVisibility(View.VISIBLE);
            holder.it5.setVisibility(View.VISIBLE);
            Picasso.get().load(arr.get(position).get(0).toString()).into(holder.img1);
            holder.it1.setText(arr.get(position).get(1).toString());
            holder.it2.setText(arr.get(position).get(2).toString());
            holder.it3.setText(arr.get(position).get(3).toString());
            Picasso.get().load(arr.get(position).get(4).toString()).into(holder.img2);
            holder.it4.setText(arr.get(position).get(5).toString());
            holder.it5.setText(arr.get(position).get(6).toString());
            holder.it6.setText(arr.get(position).get(7).toString());
        }
        else if(key.equals("incharge") || key.equals("dept")){
            holder.it3.setVisibility(View.GONE);
            holder.it6.setVisibility(View.GONE);
            holder.it2.setVisibility(View.VISIBLE);
            holder.it4.setVisibility(View.VISIBLE);
            holder.it5.setVisibility(View.VISIBLE);
            if(!arr.get(position).get(0).toString().trim().equals("")) {
                Picasso.get().load(arr.get(position).get(0).toString()).into(holder.img1);
            }
            if(!arr.get(position).get(4).toString().trim().equals("")) {
                Picasso.get().load(arr.get(position).get(4).toString()).into(holder.img2);
            }
            else if(arr.get(position).get(0).toString().trim().equals("") && arr.get(position).get(1).toString().trim().equals("Tonoy Deb")) {

                Picasso.get().load("https://i.postimg.cc/CMJdg258/td.jpg").into(holder.img1);
            }

            if(arr.get(position).get(0).toString().trim().equals("") && arr.get(position).get(1).toString().trim().equals("Mayuri Das")) {

                Picasso.get().load("https://llm1041430350.blob.core.windows.net/shristi-images/3cad64c8-5322-4aa2-9227-a0a5ba4e4855IMG_9563.jpeg?sv=2022-11-02&ss=b&srt=sco&sp=rwdlaciytfx&se=2024-04-30T00:15:08Z&st=2024-04-02T16:15:08Z&spr=https&sig=%2BOjFAqiCutR7Urdzz9GU5LF3QhsJpMP1NQLRlRI5Znk%3D").into(holder.img1);
            }

            if(arr.get(position).get(0).toString().trim().equals("") && arr.get(position).get(1).toString().trim().equals("Parismita Borah")) {

                Picasso.get().load("https://i.postimg.cc/7LgYQsjf/pborah.png").into(holder.img1);
            }
            holder.it1.setText(arr.get(position).get(1).toString());
            holder.it2.setText(arr.get(position).get(2).toString());
            holder.it4.setText(arr.get(position).get(5).toString());
            holder.it5.setText(arr.get(position).get(6).toString());
        }
        else if(key.equals("single")){
            holder.it3.setVisibility(View.GONE);
            holder.it6.setVisibility(View.GONE);
            holder.it2.setVisibility(View.GONE);
            if(!arr.get(position).get(0).toString().trim().equals("")) {
                Picasso.get().load(arr.get(position).get(0).toString()).into(holder.img1);
            }
            if(!arr.get(position).get(4).toString().trim().equals("")) {
                Picasso.get().load(arr.get(position).get(4).toString()).into(holder.img2);
            }

            if(arr.get(position).get(0).toString().trim().equals("") && arr.get(position).get(1).toString().trim().equals("Millo Novin")) {
                Picasso.get().load("https://i.postimg.cc/MKdB9TVh/mn.jpg").into(holder.img1);
            }
            else if(arr.get(position).get(0).toString().trim().equals("") && arr.get(position).get(1).toString().trim().equals("Liza Hazarika")) {
                Picasso.get().load("https://i.postimg.cc/kgHbdpjs/lz.jpg").into(holder.img1);
            }
            holder.it4.setVisibility(View.GONE);
            holder.img2.setVisibility(View.GONE);
            holder.it5.setVisibility(View.GONE);
            holder.it1.setText(arr.get(position).get(1).toString());
        }

        else{
            holder.it4.setVisibility(View.VISIBLE);
            holder.it3.setVisibility(View.GONE);
            holder.it6.setVisibility(View.GONE);
            holder.it2.setVisibility(View.GONE);
            if(!arr.get(position).get(0).toString().trim().equals("")) {
                Picasso.get().load(arr.get(position).get(0).toString()).into(holder.img1);
            }
            if(!arr.get(position).get(4).toString().trim().equals("")) {
                Picasso.get().load(arr.get(position).get(4).toString()).into(holder.img2);
            }
            holder.it5.setVisibility(View.GONE);
            holder.it1.setText(arr.get(position).get(1).toString());
            holder.it4.setText(arr.get(position).get(5).toString());

        }


if(key.equals("jos")){
    if(arr.get(position).get(0).toString().trim().equals("") && arr.get(position).get(1).toString().trim().equals("Shounak Chakraborty")) {
        Picasso.get().load("https://i.postimg.cc/CKffMsXg/sc.jpg").into(holder.img1);
    }
    else if(arr.get(position).get(4).toString().trim().equals("") && arr.get(position).get(5).toString().trim().equals("Plabipriya Bordoloi")) {
        Picasso.get().load("https://i.postimg.cc/wvXyLT94/pp.jpg").into(holder.img2);
    }

    if(arr.get(position).get(0).toString().trim().equals("") && arr.get(position).get(1).toString().trim().equals("Aditya Kumar")) {
        Picasso.get().load("https://i.postimg.cc/kMyR541B/adr.jpg").into(holder.img1);
    }
    if(arr.get(position).get(4).toString().trim().equals("") && arr.get(position).get(5).toString().trim().equals("Karka Karlo")) {
        Picasso.get().load("https://i.postimg.cc/xTTJN2hg/karka.jpg").into(holder.img2);
    }

}



    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
ShapeableImageView img1,img2;
TextView it1,it2,it3,it4,it5,it6;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.memberdesgin_img1);
            img2=itemView.findViewById(R.id.memberdesgin_img2);
            it1=itemView.findViewById(R.id.memberdesgin_img1txt1);
            it2=itemView.findViewById(R.id.memberdesgin_img1txt2);
            it3=itemView.findViewById(R.id.memberdesgin_img1txt3);
            it4=itemView.findViewById(R.id.memberdesgin_img2txt1);
            it5=itemView.findViewById(R.id.memberdesgin_img2txt2);
            it6=itemView.findViewById(R.id.memberdesgin_img2txt3);



        }
    }

    public String getURLForResource (int resourceId) {
        //use BuildConfig.APPLICATION_ID instead of R.class.getPackage().getName() if both are not same
        return Uri.parse("android.resource://"+ Objects.requireNonNull(R.class.getPackage()).getName()+"/" +resourceId).toString();
    }
}
