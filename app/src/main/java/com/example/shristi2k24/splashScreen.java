package com.example.shristi2k24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SplashScreen;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

public class splashScreen extends AppCompatActivity {
    ImageView  sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView imageView = findViewById(R.id.splash_logo);
        TextView txt=findViewById(R.id.splash_text);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade);
        Animation slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide);
        imageView.startAnimation(fadeInAnimation);
        txt.startAnimation(slideInAnimation);
        sp=findViewById(R.id.splashbg);
        Glide.with(splashScreen.this).load(R.drawable.stars).into(new DrawableImageViewTarget(sp));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(splashScreen.this,DescriptionPage.class);
                startActivity(i);
                finish();

            }
        },4000);

    }
}