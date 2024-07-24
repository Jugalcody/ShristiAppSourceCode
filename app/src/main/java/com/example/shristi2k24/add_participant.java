package com.example.shristi2k24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.example.shristi2k24.ApiLink;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class add_participant extends AppCompatActivity {
    Spinner time1;

    ApiLink api;
    SpinnerAdapter1 sadapter;
    ProgressBar progressBar;
ImageView bg;

    AppCompatButton submit,del;
    String res="0";
    LinearLayout ll1;

    RadioButton individual,team;
    String[] arr={"1st","2nd","3rd"};

    EditText name1,college,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participant);
        api=new ApiLink();
        time1=findViewById(R.id.add_cardspinner1);
        individual=findViewById(R.id.add_individual_radio);
        team=findViewById(R.id.add_team_radio);
        ll1=findViewById(R.id.add_cardll1);
        progressBar=findViewById(R.id.padd_progress);
        phone=findViewById(R.id.add_cardphone);

        del=findViewById(R.id.delete_radiocard);
        submit=findViewById(R.id.add_participant_but);
        name1=findViewById(R.id.add_cardname);
bg=findViewById(R.id.addbg);
        Glide.with(add_participant.this).load(R.drawable.stars).into(new DrawableImageViewTarget(bg));
        college=findViewById(R.id.add_cardcollege);
        sadapter=new SpinnerAdapter1(this,R.layout.spinner_login,arr);
        time1.setAdapter(sadapter);

        time1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedOption = (String) adapterView.getItemAtPosition(i);
                if (selectedOption != null) {
                    if (selectedOption.equals("1st")) {
                        res = "1";
                    } else if (selectedOption.equals("2nd")) {
                        res= "2";
                    } else if (selectedOption.equals("3rd")) {
                        res = "3";
                    }

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        String operation=getIntent().getStringExtra("operation");
        if(operation.equals("edit")){
            name1.setVisibility(View.VISIBLE);
            del.setVisibility(View.VISIBLE);
            college.setVisibility(View.VISIBLE);
            ll1.setVisibility(View.VISIBLE);
            phone.setVisibility(View.VISIBLE);
            phone.setText(getIntent().getStringExtra("phone"));

            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    delParticipant(getIntent().getStringExtra("dept"),getIntent().getStringExtra("event"),getIntent().getStringExtra("phone"));
                }
            });

            submit.setVisibility(View.VISIBLE);
            name1.setText(getIntent().getStringExtra("name"));
            college.setText(getIntent().getStringExtra("college"));




            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!res.equals("0")) {
                        JSONObject jj = new JSONObject();
                        try {
                            jj.put("name", name1.getText().toString());
                            jj.put("phone", phone.getText().toString());
                            jj.put("college", college.getText().toString());
                            jj.put("time", res.trim());
                            jj.put("score", "0");
                        } catch (Exception e) {

                        }

                        editParticipant(getIntent().getStringExtra("dept"), getIntent().getStringExtra("event"), jj);
                    }
                    else{
                        Toast.makeText(add_participant.this,"select postition",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        else{
            del.setVisibility(View.GONE);
            individual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name1.setHint("Enter Participant Name");
                    name1.setVisibility(View.VISIBLE);
                    college.setVisibility(View.VISIBLE);
                    ll1.setVisibility(View.VISIBLE);
                    phone.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.VISIBLE);
                }
            });

            team.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name1.setHint("Enter Team Name");
                    name1.setVisibility(View.VISIBLE);
                    college.setVisibility(View.VISIBLE);
                    ll1.setVisibility(View.VISIBLE);
                    phone.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.VISIBLE);
                }

            });
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!res.equals("")) {
                        JSONObject jj = new JSONObject();
                        try {
                            jj.put("name", name1.getText().toString());
                            jj.put("phone", phone.getText().toString());
                            jj.put("college", college.getText().toString());
                            jj.put("time",res);
                            jj.put("score", "0");
                        } catch (Exception e) {

                        }

                        addParticipant(getIntent().getStringExtra("dept"), getIntent().getStringExtra("event"), jj);
                    }
                    else{
                        Toast.makeText(add_participant.this,"select postition",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }



    public void addParticipant (String dept, String eventName, JSONObject p){
        progressBar.setVisibility(View.VISIBLE);

        String temp =api.getEndPoint()+"/add";
        try {
            JSONObject jsonobj=new JSONObject();
            jsonobj.put("dept",dept);
            jsonobj.put("eventName",eventName);
            jsonobj.put("participant",p);

            JsonObjectRequest j = new JsonObjectRequest(Request.Method.POST, temp, jsonobj, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {

                        if (Boolean.parseBoolean(response.getString("success"))) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(add_participant.this,"added successfully",Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        Toast.makeText(add_participant.this,e.toString(),Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(add_participant.this,error.toString(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }});
            RequestQueue q = Volley.newRequestQueue(add_participant.this);
            RetryPolicy retryPolicy = new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            );
            j.setRetryPolicy(retryPolicy);
            q.add(j);


        }catch (Exception e){
            Toast.makeText(add_participant.this,e.toString(),Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }

    }


    public void editParticipant (String dept,String eventName,JSONObject participant){
        progressBar.setVisibility(View.VISIBLE);
        String temp =api.getEndPoint()+"/update";
        try {

            JSONObject jsonobj=new JSONObject();
            jsonobj.put("dept",dept);
            jsonobj.put("eventName",eventName);
            jsonobj.put("participant",participant);
            JsonObjectRequest j = new JsonObjectRequest(Request.Method.PUT, temp, jsonobj, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {

                        if (Boolean.parseBoolean(response.getString("success"))) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(add_participant.this,"updated successfully",Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        Toast.makeText(add_participant.this,e.toString(),Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(add_participant.this,error.toString(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }});
            RequestQueue q = Volley.newRequestQueue(add_participant.this);
            RetryPolicy retryPolicy = new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            );
            j.setRetryPolicy(retryPolicy);
            q.add(j);


        }catch (Exception e){}

    }



    public void delParticipant (String dept,String eventName,String participants){
        progressBar.setVisibility(View.VISIBLE);
        String temp =api.getEndPoint()+"/delete";
        try {

            JSONObject jsonobj=new JSONObject();
            jsonobj.put("dept",dept);
            jsonobj.put("eventName",eventName);
            jsonobj.put("phone",participants);

            JsonObjectRequest j = new JsonObjectRequest(Request.Method.PUT, temp, jsonobj, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {
                        if (Boolean.parseBoolean(response.getString("success"))) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(add_participant.this,"deleted successfully",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(add_participant.this,Participant_Edit.class);
                            i.putExtra("event",getIntent().getStringExtra("event"));
                            i.putExtra("dept",getIntent().getStringExtra("dept"));

                            startActivity(i);
                            finish();

                        }
                    }catch (Exception e){
                        Toast.makeText(add_participant.this,e.toString(),Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(add_participant.this,error.toString(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }});
            RequestQueue q = Volley.newRequestQueue(add_participant.this);
            RetryPolicy retryPolicy = new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            );
            j.setRetryPolicy(retryPolicy);
            q.add(j);


        }catch(Exception erre){

            Toast.makeText(add_participant.this,erre.toString(),Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }
    }


}