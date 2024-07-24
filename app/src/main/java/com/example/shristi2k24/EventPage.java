package com.example.shristi2k24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shristi2k24.ApiLink;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.metrics.Event;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventPage extends AppCompatActivity {
TextView title;
SharedPreferences sp;
ImageView bg,retry;
int a=0;
ApiLink api;
List<List> arr=new ArrayList<>();
ProgressBar progressBar;

RecyclerView rec;

EventDept_adapter h;
LinearLayoutManager l;
String dept;
List<List> arr2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
        retry=findViewById(R.id.event_retry);
        title=findViewById(R.id.event_title);
        api=new ApiLink();
sp=getSharedPreferences("user",MODE_PRIVATE);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEvent();
                retry.setVisibility(View.GONE);
            }
        });




        dept=getIntent().getStringExtra("dept");
        bg=findViewById(R.id.event_bg);
        Glide.with(EventPage.this).load(R.drawable.stars).into(new DrawableImageViewTarget(bg));
        progressBar=findViewById(R.id.event_progress);
        title.setText(dept);

getEvent();


    }





     /*   else if(dept.equals("Mechanical Engineering Dept")){
            arr.add("Robo Rampage Rally");
            arr.add("Thermo Thrill Regatta");
            arr.add("Hydro Mech Madness");
            arr.add("Hydro Roket");
            arr.add("Skyward Sling");
            arr.add("Drone War Zone");
            arr.add("Mechano Mind Master");
            arr.add("Design Draft Dual");
            arr.add("Ureka");
        }
        else if(dept.equals("Civil Engineering Dept")){
            arr.add("Civil Vision");
            arr.add("CAD Craftmanship");
            arr.add("Cast Master");
            arr.add("Know Your Earth");
            arr.add("Waste To Best");
            arr.add("Civil Quest");
            arr.add("Future Focus Forge");
            arr.add("Miscellaneous");
        }
        else if(dept.equals("Electronic and Communication Engg. Dept")){
            arr.add("Battle Of Brains (Quiz)");
            arr.add("Line Follower Robot");
            arr.add("Gate Master");
            arr.add("Feel the Buzz");
            arr.add("Robo Socer Legue");
            arr.add("Circuiteshwar");
            arr.add("E - Snake & Ladder");
        }
        else if(dept.equals("Forestry Engineering Dept")){
            arr.add("Know your plant");
            arr.add("Model Maze");
            arr.add("Debate");
            arr.add("Poster");
            arr.add("Snapshot");
            arr.add("Eco Craft Clique");
            arr.add("Misseleneous");
        }
        else if(dept.equals("Electrical Engineering Dept")){

             arr.add("Circuiteer");
             arr.add("Tech-o-logic");
             arr.add("Techamend");
             arr.add("Presentation");
             arr.add("Amp duo");
             arr.add("Miscelleneous");
        }
        else if(dept.equals("Agricultural Engineering Dept")){
arr.add("Representation");
arr.add("GIS remote sensing");
arr.add("Tame the track");
arr.add("AutoCAD designing");
arr.add("Surprise the tongue");
arr.add("Back a cokie");
arr.add("Misseleneous");
        }
        else if(dept.equals("Techno Club")){

        }
        else if(dept.equals("Management Club")){

        }*/





    public void getEvent (){

        progressBar.setVisibility(View.VISIBLE);


        String temp =api.getEndPoint()+"/getevents";

        try {
            JsonObjectRequest j = new JsonObjectRequest(Request.Method.GET, temp, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {
                        arr=getList(response.getJSONArray("events"));

                   if(arr.size()>0) {
                       progressBar.setVisibility(View.GONE);
                       l=new LinearLayoutManager(EventPage.this,LinearLayoutManager.VERTICAL,false);
                       h = new EventDept_adapter(EventPage.this, arr, getIntent().getStringExtra("authenticate"), dept);
                       rec = findViewById(R.id.rec_event);
                       rec.setLayoutManager(l);
                       rec.setAdapter(h);
                   }
                   else{
retry.setVisibility(View.VISIBLE);
progressBar.setVisibility(View.GONE);
                   }

                    }
                    catch (Exception e){
                        progressBar.setVisibility(View.GONE);
                        retry.setVisibility(View.VISIBLE);
                        System.out.println("jkd99"+e.toString());
                    }

                    }}, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressBar.setVisibility(View.GONE);
                    retry.setVisibility(View.VISIBLE);
                    Toast.makeText(EventPage.this,error.toString(),Toast.LENGTH_SHORT).show();
                    //progressBar.setVisibility(View.GONE);
                }});
            RequestQueue q = Volley.newRequestQueue(EventPage.this);
            RetryPolicy retryPolicy = new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            );
            j.setRetryPolicy(retryPolicy);
            q.add(j);


        }catch (Exception e){
           Toast.makeText(EventPage.this,e.toString(),Toast.LENGTH_SHORT).show();
          //  progressBar.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            retry.setVisibility(View.VISIBLE);
        }

    }



    List<List> getList(JSONArray jsonArray) throws JSONException {

        List<List> outer = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            List<String> inner = new ArrayList<>();
            JSONObject j = jsonArray.getJSONObject(i);
            if (dept.toLowerCase().trim().contains("computer") ) {
                if (j.getString("clubName").toLowerCase().trim().contains("computer") || j.getString("clubName").toLowerCase().trim().contains("cse")) {

                    try {
                        inner.add(j.getString("name"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("image"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("date"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {


                        inner.add(j.getString("time"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("desc"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("venue"));
                    } catch (Exception e) {
                        inner.add("");
                    }

                    outer.add(inner);
                }
            } else if (dept.toLowerCase().trim().contains("mechanical")) {
                if (j.getString("clubName").toLowerCase().trim().contains("mechanical") || j.getString("clubName").toLowerCase().trim().contains("mechanical")) {

                    try {
                        inner.add(j.getString("name"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("image"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("date"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {


                        inner.add(j.getString("time"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("desc"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("venue"));
                    } catch (Exception e) {
                        inner.add("");
                    }

                    outer.add(inner);
                }
            } else if (dept.toLowerCase().trim().contains("civil")) {
                if (j.getString("clubName").toLowerCase().trim().contains("civil")) {

                    try {
                        inner.add(j.getString("name"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("image"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("date"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {


                        inner.add(j.getString("time"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("desc"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("venue"));
                    } catch (Exception e) {
                        inner.add("");
                    }

                    outer.add(inner);
                }
            } else if (dept.toLowerCase().trim().contains("electronic")) {
                if (j.getString("clubName").toLowerCase().trim().contains("electronic") ) {

                    try {
                        inner.add(j.getString("name"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("image"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("date"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {


                        inner.add(j.getString("time"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("desc"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("venue"));
                    } catch (Exception e) {
                        inner.add("");
                    }

                    outer.add(inner);
                }
            } else if (dept.toLowerCase().trim().contains("forestry")) {
                if (j.getString("clubName").toLowerCase().trim().contains("forestry") ) {

                    try {
                        inner.add(j.getString("name"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("image"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("date"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {


                        inner.add(j.getString("time"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("desc"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("venue"));
                    } catch (Exception e) {
                        inner.add("");
                    }

                    outer.add(inner);
                }
            } else if (dept.toLowerCase().trim().contains("electrical")) {
                if (j.getString("clubName").toLowerCase().trim().contains("electrical")) {

                    try {
                        inner.add(j.getString("name"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("image"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("date"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {


                        inner.add(j.getString("time"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("desc"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("venue"));
                    } catch (Exception e) {
                        inner.add("");
                    }

                    outer.add(inner);
                }
            } else if (dept.toLowerCase().trim().contains("agricultural")) {
                if (j.getString("clubName").toLowerCase().trim().contains("agricultural") || j.getString("clubName").toLowerCase().trim().equals("ae")) {

                    try {
                        inner.add(j.getString("name"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("image"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("date"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {


                        inner.add(j.getString("time"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("desc"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("venue"));
                    } catch (Exception e) {
                        inner.add("");
                    }

                    outer.add(inner);
                }
            } else if (dept.toLowerCase().trim().contains("techno") ) {
                if (j.getString("clubName").toLowerCase().trim().contains("techno") || j.getString("clubName").toLowerCase().trim().equals("tc")) {

                    try {
                        inner.add(j.getString("name"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("image"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("date"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {


                        inner.add(j.getString("time"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("desc"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("venue"));
                    } catch (Exception e) {
                        inner.add("");
                    }

                    outer.add(inner);
                }
            } else if (dept.toLowerCase().trim().contains("management") ) {

                if (j.getString("clubName").toLowerCase().trim().contains("management") ) {

                    try {
                        inner.add(j.getString("name"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("image"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("date"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {


                        inner.add(j.getString("time"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("desc"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("venue"));
                    } catch (Exception e) {
                        inner.add("");
                    }

                    outer.add(inner);
                }
            } else if (dept.toLowerCase().trim().contains("shristi talk")) {
                if (j.getString("clubName").toLowerCase().trim().contains("shristi") || j.getString("clubName").toLowerCase().trim().contains("talk")) {

                    try {
                        inner.add(j.getString("name"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("image"));
                    } catch (Exception e) {
                        inner.add("");
                    }
                    try {
                        inner.add(j.getString("date"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {


                        inner.add(j.getString("time"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("desc"));
                    } catch (Exception e) {
                        inner.add("");
                    }


                    try {
                        inner.add(j.getString("venue"));
                    } catch (Exception e) {
                        inner.add("");
                    }

                    outer.add(inner);
   }
            }
        }
            return outer;

    }

    // Read JSON data from raw folder
    private String readJSONFromRaw(Context context, int resId) {
        Resources resources = context.getResources();
        InputStream inputStream = resources.openRawResource(resId);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int size;
        byte[] buffer = new byte[1024];
        try {
            while ((size = inputStream.read(buffer, 0, 1024)) >= 0) {
                outputStream.write(buffer, 0, size);
            }
            outputStream.close();
            inputStream.close();  System.out.print("pqrjson"+"no");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.toString();
    }

    public void getEvent2() {
        progressBar.setVisibility(View.VISIBLE);

        // Read JSON data from raw folder
        System.out.print("pqrjson"+"no");
        String json = readJSONFromRaw(R.raw.events); // Assuming 'events.json' is the name of your JSON file in the raw folder

        try {

            JSONArray jsonArray = new JSONArray(json);
            System.out.print("abcjson"+jsonArray.toString());
            arr = getList(jsonArray);

            if (arr.size() > 0) {
                progressBar.setVisibility(View.GONE);
                l = new LinearLayoutManager(EventPage.this, LinearLayoutManager.VERTICAL, false);
                h = new EventDept_adapter(EventPage.this, arr, getIntent().getStringExtra("authenticate"), dept);
                rec.setLayoutManager(l);
                rec.setAdapter(h);
            } else {
                retry.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            progressBar.setVisibility(View.GONE);
            retry.setVisibility(View.VISIBLE);
        }
    }

    // Read JSON data from raw folder
    private String readJSONFromRaw(int resId) {
        Resources resources = getResources();
        InputStream inputStream = resources.openRawResource(resId);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int size;
        byte[] buffer = new byte[1024];
        try {
            while ((size = inputStream.read(buffer, 0, 1024)) >= 0) {
                outputStream.write(buffer, 0, size);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.toString();
    }
}