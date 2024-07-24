package com.example.shristi2k24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
HomeDept_adapter dept;
ImageView bg;
LinearLayoutManager linearLayoutManager;
Toolbar toolbar;
ImageView back;
ArrayList<String> arr=new ArrayList<>(Arrays.asList("Computer Science Engg. Dept","Mechanical Engineering Dept","Civil Engineering Dept","Electronic and Communication Engg. Dept","Forestry Engineering Dept","Electrical Engineering Dept","Agricultural Engineering Dept","Techno Club","Management Club"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar_home);
        bg=findViewById(R.id.main_bg);
        Glide.with(MainActivity.this).load(R.drawable.stars).into(new DrawableImageViewTarget(bg));

setSupportActionBar(toolbar);
getSupportActionBar();
back=findViewById(R.id.ticon);
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(MainActivity.this,HomePage.class);
        overridePendingTransition(R.anim.fadesin,R.anim.fadesout);
        startActivity(i);
    }
});
        recyclerView=findViewById(R.id.rec_home);


        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
dept=new HomeDept_adapter(this,arr);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(dept);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.incharge_login){
   Intent i=new Intent(this,InchargeActivity.class);
   startActivity(i);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater ();
        inflater.inflate ( R.menu.home_menu,menu );
        return super.onCreateOptionsMenu(menu);
    }
}