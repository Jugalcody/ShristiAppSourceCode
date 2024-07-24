package com.example.shristi2k24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import java.util.ArrayList;
import java.util.Arrays;

public class InchargeActivity extends AppCompatActivity {
AutoCompleteTextView auto;
AppCompatButton proceed;
ImageView bg;
EditText code;
    String[] arr={"Computer Science Engg. Dept","Mechanical Engineering Dept","Civil Engineering Dept","Electronic and Communication Engg. Dept","Forestry Engineering Dept","Electrical Engineering Dept","Agricultural Engineering Dept","Techno Club","Management Club"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incharge);
code=findViewById(R.id.incharge_code);
        auto=findViewById(R.id.inchage_pageautotxt);
proceed=findViewById(R.id.incharge_proceed);
 SpinnerAdapter1 adapter1=new SpinnerAdapter1(this,R.layout.spinner_login,arr);
 auto.setAdapter(adapter1);
proceed.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(InchargeActivity.this,EventPage.class);
        SharedPreferences sp=getSharedPreferences("user",MODE_PRIVATE);
        if(auto.getText().toString().equals("Computer Science Engg. Dept") && code.getText().toString().equals("781104")){

            i.putExtra("authenticate","incharge");
            i.putExtra("dept","Computer Science Engg. Dept");
            sp.edit().putString("islogged","true").apply();
            finish();
            startActivity(i);

        }
        else if(auto.getText().toString().equals("Mechanical Engineering Dept") && code.getText().toString().equals("7211y05")){

            i.putExtra("authenticate","incharge");
            i.putExtra("dept","Mechanical Engineering Dept");
            sp.edit().putString("islogged","true").apply();
            startActivity(i);
        }
        else if(auto.getText().toString().equals("Civil Engineering Dept") && code.getText().toString().equals("jugal")){

            i.putExtra("authenticate","incharge");
            i.putExtra("dept","Civil Engineering Dept");
            sp.edit().putString("islogged","true").apply();
            startActivity(i);
        }


        else if(auto.getText().toString().equals("Forestry Engineering Dept") && code.getText().toString().equals("223@63")){

            i.putExtra("authenticate","incharge");
            i.putExtra("dept","Forestry Engineering Dept");
            sp.edit().putString("islogged","true").apply();
            startActivity(i);
        }
        else if(auto.getText().toString().equals("Electronic and Communication Engg. Dept") && code.getText().toString().equals("8945k2")){

            i.putExtra("authenticate","incharge");
            i.putExtra("dept","Electronic and Communication Engg. Dept");
            sp.edit().putString("islogged","true").apply();
            startActivity(i);
        }
        else if(auto.getText().toString().equals("Electrical Engineering Dept") && code.getText().toString().equals("4328s9")){

            i.putExtra("authenticate","incharge");
            i.putExtra("dept","Electrical Engineering Dept");
            sp.edit().putString("islogged","true").apply();
            startActivity(i);
        }
        else if(auto.getText().toString().equals("Agricultural Engineering Dept") && code.getText().toString().equals("7943s8")){

            i.putExtra("authenticate","incharge");
            i.putExtra("dept","Agricultural Engineering Dept");
            sp.edit().putString("islogged","true").apply();
            startActivity(i);
        }
        else if(auto.getText().toString().equals("Techno Club") && code.getText().toString().equals("7z61433")){
            sp.edit().putString("islogged","true").apply();
            startActivity(i);
            i.putExtra("authenticate","incharge");
            i.putExtra("dept","Techno Club");

        }
        else if(auto.getText().toString().equals("Management Club") && code.getText().toString().equals("5643#2")){
            sp.edit().putString("islogged","true").apply();
            startActivity(i);
            i.putExtra("authenticate","incharge");
            i.putExtra("dept","Management Club");

        }




    }
});
    }
}