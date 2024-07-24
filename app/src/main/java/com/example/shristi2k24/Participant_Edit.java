package com.example.shristi2k24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shristi2k24.ApiLink;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Participant_Edit extends AppCompatActivity {
    RecyclerView rec;
    ApiLink api;
    List<String> list=new ArrayList<>();
    ImageView bg;
    List<List> arr5=new ArrayList<>();
    Participant_adapter p;
    ProgressBar progressBar;
    List<List> arr=new ArrayList<>();
    String activityy="";
    ImageView add;
    LinearLayoutManager l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api=new ApiLink();
        setContentView(R.layout.activity_participant_edit);
add=findViewById(R.id.add_but_participant);
bg=findViewById(R.id.peditbg);
        Glide.with(Participant_Edit.this).load(R.drawable.stars).into(new DrawableImageViewTarget(bg));
activityy=getIntent().getStringExtra("activity");
progressBar=findViewById(R.id.pedit_progress);

if(!getIntent().getStringExtra("activity").equals("register")) {
    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Participant_Edit.this, add_participant.class);
            i.putExtra("operation", "add");
            i.putExtra("dept", getIntent().getStringExtra("dept"));
            i.putExtra("event", getIntent().getStringExtra("event"));
            startActivity(i);
        }
    });
    rec = findViewById(R.id.participant_rec_incharge1);

    getParticipant(getIntent().getStringExtra("dept"), getIntent().getStringExtra("event"));
}
else{

    getlist();


}

    }

public void getlist(){

        String temp=api.getEndPoint2()+"/events";
        try{


            JsonArrayRequest jsonObjectRequest=new JsonArrayRequest(Request.Method.GET, temp,null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Toast.makeText(Participant_Edit.this,"inside",Toast.LENGTH_SHORT).show();
for(int i=0;i<response.length();i++){
    try {
        JSONObject j=response.getJSONObject(i);
       if(j.getString("name").equals(getIntent().getStringExtra("event"))){
            String o=j.getString("user");

list=extractList(o.substring(1,o.length()-1));
System.out.println("lop"+list+"---"+o.substring(1,o.length()-1));
break;
        }
    } catch (JSONException e) {
        throw new RuntimeException(e);
    }
}

arr5=getRegisteredStudent(list);
                    System.out.println("lomuyk"+arr5);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Participant_Edit.this,error.toString(),Toast.LENGTH_SHORT).show();
                }
            });

            RequestQueue queue=Volley.newRequestQueue(Participant_Edit.this);
            queue.add(jsonObjectRequest);
            RetryPolicy retryPolicy = new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            );
            jsonObjectRequest.setRetryPolicy(retryPolicy);
        }
        catch(Exception e){

            Toast.makeText(Participant_Edit.this,"inside2",Toast.LENGTH_SHORT).show();
        }

}

public List<List> getRegisteredStudent(List<String> arr){

List<List> arr55=new ArrayList<>();
    String temp=api.getEndPoint2()+"/auth/getalluser";
    try{




        JsonArrayRequest jsonObjectRequest=new JsonArrayRequest(Request.Method.GET, temp,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(Participant_Edit.this,"inside",Toast.LENGTH_SHORT).show();
                for(int i=0;i<response.length();i++) {
                    try {
                        JSONObject j = response.getJSONObject(i);

                        if(arr.contains(j.getString("_id"))) {

  List<String> arr2 = new ArrayList<>();
arr2.add(j.getString("name"));
                            arr2.add(j.getString("regNo"));
                            arr2.add(j.getString("phoneNo"));
                            arr2.add(j.getString("name"));
                            arr2.add(j.getString("name"));
  //                          arr2.add(j.getString("regNo"));
//arr2.add(j.getString("phoneNo"));

arr55.add(arr2);
                        }
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
              //  }


                if(arr55.size()>0){
                    arr5.addAll(arr55);


               /*    LinearLayoutManager l = new LinearLayoutManager(Participant_Edit.this, LinearLayoutManager.VERTICAL, false);
                    rec.setLayoutManager(l);
                    p = new Participant_adapter(Participant_Edit.this, arr5, "Participant_Edit",getIntent().getStringExtra("event"),getIntent().getStringExtra("dept"),"register");
                    rec.setAdapter(p);*/

                }
                else{
                    Toast.makeText(Participant_Edit.this,"empty list",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Participant_Edit.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue=Volley.newRequestQueue(Participant_Edit.this);
        queue.add(jsonObjectRequest);
        RetryPolicy retryPolicy = new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        );
        jsonObjectRequest.setRetryPolicy(retryPolicy);
    }
    catch(Exception e){

        Toast.makeText(Participant_Edit.this,"inside2",Toast.LENGTH_SHORT).show();
    }

    System.out.println("lomuy"+arr5);
    return arr55;
}
    @Override
    protected void onRestart() {
        super.onRestart();
        if(!activityy.equals("register")) {
            getParticipant(getIntent().getStringExtra("dept"), getIntent().getStringExtra("event"));
        }


    }

    public List<String> extractList(String s) {
        List<String> arr = new ArrayList<>();
        String k = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '"') {
                k += s.charAt(i);
            } else if (s.charAt(i) == ',') {
                continue;
            }
            else if(s.charAt(i)=='"' && !k.trim().equals("")){
                arr.add(k.trim());
                k="";
            }
        }

        // Add the last element if it is not empty
        if (!k.trim().equals("")) {
            arr.add(k.trim());
        }
        List<String> arr6=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            if(!arr.get(i).trim().equals("") && arr.get(i).length()>4){
                arr6.add(arr.get(i).trim());
            }
        }
        return arr6;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!activityy.equals("register")) {
            getParticipant(getIntent().getStringExtra("dept"), getIntent().getStringExtra("event"));
        }

    }

    public void getParticipant (String dept, String eventName){
        progressBar.setVisibility(View.VISIBLE);
        String temp=api.getEndPoint()+"/getParticipants";

        try {
            JSONObject jsonobj=new JSONObject();
            jsonobj.put("dept",dept);
            jsonobj.put("eventName",eventName);
            JsonObjectRequest j = new JsonObjectRequest(Request.Method.POST, temp, jsonobj, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {

                        if (Boolean.parseBoolean(response.getString("success"))) {
                            JSONArray ja = response.getJSONArray("participants");
                            arr=getList(ja);
             progressBar.setVisibility(View.GONE);
if(arr.size()>0) {
    l = new LinearLayoutManager(Participant_Edit.this, LinearLayoutManager.VERTICAL, false);
    rec.setLayoutManager(l);
    p = new Participant_adapter(Participant_Edit.this, arr, "Participant_Edit", eventName, dept,"");
    rec.setAdapter(p);
}
else{
    Toast.makeText(Participant_Edit.this,"no participant added",Toast.LENGTH_SHORT).show();
}
                        }
                    }catch (Exception e){
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(Participant_Edit.this,e.toString(),Toast.LENGTH_SHORT).show();
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    progressBar.setVisibility(View.GONE);
                    String message ="";
                    if (volleyError instanceof NetworkError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                    } else if (volleyError instanceof AuthFailureError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                    } else if (volleyError instanceof ParseError) {
                        message = "Winner list has not been updated";
                    } else if (volleyError instanceof NoConnectionError) {
                        message = "Cannot connect to Internet...Please check your internet connection!";
                    } else if (volleyError instanceof TimeoutError) {
                        message = "Launch time out, try again";
                    }
                    else{
                        message="Winner list has not been updated";
                    }

                    Toast.makeText(Participant_Edit.this,message,Toast.LENGTH_SHORT).show();
                }});
            RequestQueue q = Volley.newRequestQueue(Participant_Edit.this);
            RetryPolicy retryPolicy = new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            );
            j.setRetryPolicy(retryPolicy);
            q.add(j);


        }catch (Exception e){
            progressBar.setVisibility(View.GONE);
            Toast.makeText(Participant_Edit.this,e.toString(),Toast.LENGTH_SHORT).show();
        }

    }

    List<List> getList(JSONArray jsonArray) throws JSONException {
        List<List> outer=new ArrayList<>();

        for(int i=0;i<jsonArray.length();i++){
            JSONObject j=jsonArray.getJSONObject(i);
            List<String> inner=new ArrayList<>();
            try {
                inner.add(j.getString("name"));
            }

            catch (Exception e) {
                inner.add("");
            }
            try {
                inner.add(j.getString("college"));
            }
            catch(Exception e){
                inner.add("");
            }
            try {
                inner.add(j.getString("phone"));
            }
            catch(Exception e) {
                inner.add("");
            }


            try {


                inner.add(j.getString("time"));
            }catch(Exception e) {
                inner.add("");
            }


            try {
                inner.add(j.getString("score"));
            }
            catch (Exception e) {
                inner.add("");
            }


            outer.add(inner);
        }

        return outer;
    }

    public boolean isThere(List<String> arr,String s){
        boolean isthere=false;
        for(int i=0;i<arr.size();i++){
            System.out.println("cp"+arr.get(0)+"--"+s);
            if(arr.get(i).trim().toString().equals(s.trim().toString())){
                isthere=true;
                break;
            }
        }
        return isthere;
    }

}