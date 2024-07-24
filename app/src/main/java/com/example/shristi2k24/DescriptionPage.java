package com.example.shristi2k24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;


import java.util.ArrayList;

public class DescriptionPage extends AppCompatActivity {
AppCompatButton incharge,guest;
ImageView imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_page);
        imageSlider=findViewById(R.id.image_slider);
        Glide.with(DescriptionPage.this).load("https://i.postimg.cc/Yqn3h8nG/descload2.gif").into(new DrawableImageViewTarget(imageSlider));
        guest=findViewById(R.id.descguest);
        incharge=findViewById(R.id.descincharge);


        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DescriptionPage.this, HomePage.class);
                startActivity(i);
            }
        });


        incharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DescriptionPage.this, InchargeActivity.class);
                startActivity(i);
            }
        });
    }

    public static Uri getUrl(int res){
        return Uri.parse("android.resource://com.example.project/" + res);
    }
}