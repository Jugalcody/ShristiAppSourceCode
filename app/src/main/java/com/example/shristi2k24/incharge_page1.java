package com.example.shristi2k24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

public class incharge_page1 extends AppCompatActivity {
AppCompatButton participant,logout;
int a=0;
ImageView bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incharge_page1);
        SharedPreferences sp=getSharedPreferences("user",MODE_PRIVATE);
        participant=findViewById(R.id.incharge_participantadd);


        bg=findViewById(R.id.incharge2ng);
        Glide.with(incharge_page1.this).load(R.drawable.stars).into(new DrawableImageViewTarget(bg));

        participant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(incharge_page1.this,Participant_Edit.class);
                i.putExtra("event",getIntent().getStringExtra("event"));
                i.putExtra("dept",getIntent().getStringExtra("dept"));
                i.putExtra("activity","");
                startActivity(i);
            }
        });
    }
}