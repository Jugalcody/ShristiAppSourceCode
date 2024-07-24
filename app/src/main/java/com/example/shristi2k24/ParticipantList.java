package com.example.shristi2k24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shristi2k24.ApiLink;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParticipantList extends AppCompatActivity {
    RecyclerView rec;
    Participant_adapter p;
    ProgressBar progressBar;
    LottieAnimationView la;
    ApiLink api;
    TextView msg;
    List<List> arr=new ArrayList<>();
    LinearLayoutManager l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api=new ApiLink();
        setContentView(R.layout.activity_participant_list);
progressBar=findViewById(R.id.plist_progress);
        rec=findViewById(R.id.participant_rec);
        la=findViewById(R.id.list_lottie);
        msg=findViewById(R.id.msgtxt);

        getParticipant(getIntent().getStringExtra("dept"),getIntent().getStringExtra("event"));

    }




    public void getParticipant (String dept,String eventName){
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
                                l = new LinearLayoutManager(ParticipantList.this, LinearLayoutManager.VERTICAL, false);
                                rec.setLayoutManager(l);
                                p = new Participant_adapter(ParticipantList.this, arr, "ParticipantList", eventName, dept,"");
                                rec.setAdapter(p);
                            }
                            else{
                                la.setVisibility(View.VISIBLE);
                                msg.setVisibility(View.VISIBLE);
                                Toast.makeText(ParticipantList.this,"Participant List not updated",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }catch (Exception e){
                        la.setVisibility(View.VISIBLE);
                        msg.setVisibility(View.VISIBLE);
                        Toast.makeText(ParticipantList.this,e.toString(),Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Toast.makeText(ParticipantList.this,volleyError.toString(),Toast.LENGTH_SHORT).show();
                    msg.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    la.setVisibility(View.VISIBLE);
msg.setVisibility(View.VISIBLE);

                    String message ="";
                    if (volleyError instanceof NetworkError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                    } else if (volleyError instanceof AuthFailureError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                    } else if (volleyError instanceof ParseError) {
                        message = "Parsing error! Please try again after some time!!";
                    } else if (volleyError instanceof NoConnectionError) {
                        message = "Cannot connect to Internet...Please check your internet connection!";
                    } else if (volleyError instanceof TimeoutError) {
                        message = "Launch time out, try again";
                    }
                    else{
                        message="Winner list has not been updated";
                    }
                    msg.setText(message);
                }});
            RequestQueue q = Volley.newRequestQueue(ParticipantList.this);
            RetryPolicy retryPolicy = new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            );
            j.setRetryPolicy(retryPolicy);
            q.add(j);


        }catch (Exception e){
            Toast.makeText(ParticipantList.this,e.toString(),Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
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

}