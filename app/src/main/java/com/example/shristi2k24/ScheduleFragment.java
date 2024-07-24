package com.example.shristi2k24;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
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

import java.util.ArrayList;
import java.util.List;
import com.example.shristi2k24.ApiLink;
public class ScheduleFragment extends Fragment {
ImageView img;
Spinner day,club;
ProgressBar progressBar;
ImageView retry;
String dayy="all",clubb="all";
    List<List> arr=new ArrayList<>();
    LinearLayoutManager l;
    ApiLink api;
    List<List> arr2=new ArrayList<>();
RecyclerView rec;

EventDept_adapter h;
String[] arr1={"All Day","Day1","Day2","Day3","Day4"};
String[] arr3={"All Events","CSE Dept. Events","ECE Dept. Events","EE Dept. Events","Civil Dept. Events","ME Dept. Events","AE Dept. Events","FO Dept. Events","Techno Club","Management Club"};
SpinnerAdapter1 adapter1,adapter2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_schedule, container, false);
        img=view.findViewById(R.id.schedule_backimg);
        Glide.with(getActivity()).load(R.drawable.stars).into(new DrawableImageViewTarget(img));
        progressBar=view.findViewById(R.id.scheduleProgress);
        retry=view.findViewById(R.id.schedule_retry);
        api=new ApiLink();
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEvent();
                retry.setVisibility(View.GONE);
            }
        });
        day=view.findViewById(R.id.sc1);
        club=view.findViewById(R.id.sc2);
        rec=view.findViewById(R.id.screc);
        adapter1=new SpinnerAdapter1(getActivity(),R.layout.spinner_login,arr1);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(adapter1);


        adapter2=new SpinnerAdapter1(getActivity(),R.layout.spinner_login,arr3);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        club.setAdapter(adapter2);

        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedOption = (String) adapterView.getItemAtPosition(i);
                if (selectedOption != null) {
                    if (selectedOption.equals("All Day")) {
                        dayy = "all";
                    }
                    else if (selectedOption.equals("Day1")) {
                        dayy = "d1";
                    } else if (selectedOption.equals("Day2")) {
                        dayy = "d2";
                    } else if (selectedOption.equals("Day3")) {
                        dayy = "d3";
                    } else if (selectedOption.equals("Day4")) {
                        dayy = "d4";
                    } else {
                        dayy = "all";
                    }
                    printsc(clubb, dayy);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        club.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedOption = (String) adapterView.getItemAtPosition(i);
                if (selectedOption != null) {
                    if (selectedOption.equals("All Events")) {
                        clubb = "all";
                    } else if (selectedOption.equals("CSE Dept. Events")) {
                        clubb = "computer";
                    } else if (selectedOption.equals("ECE Dept. Events")) {
                        clubb = "electronics";
                    } else if (selectedOption.equals("EE Dept. Events")) {
                        clubb = "electrical";
                    } else if (selectedOption.equals("Civil Dept. Events")) {
                        clubb = "civil";
                    } else if (selectedOption.equals("ME Dept. Events")) {
                        clubb = "mechanical";
                    } else if (selectedOption.equals("AE Dept. Events")) {
                        clubb = "agricultural";
                    } else if (selectedOption.equals("FO Dept. Events")) {
                        clubb = "forestry";
                    } else if (selectedOption.equals("Techno Club")) {
                        clubb = "techno";
                    } else if (selectedOption.equals("Management Club")) {
                        clubb = "management";
                    } else {
                        clubb = "all";
                    }
                    printsc(clubb, dayy);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        getEvent();
        return view;
    }


    public void printsc(String club,String day){

        List<List>parent=new ArrayList<>();
        if(arr.size()>0) {
            for(int i=0;i<arr.size();i++) {

                if (day.equals("all") && club.equals("all")) {
                    if (arr.get(i).get(6).toString().toLowerCase().trim().contains(club)) {
                        parent.add(arr.get(i));
                    }
                }
                else if(day.equals("pre")) {
                    if (arr.get(i).get(6).toString().toLowerCase().trim().contains(club) && arr.get(i).get(7).toString().toLowerCase().trim().contains("false")) {
                        parent.add(arr.get(i));
                    }
                }
                else if(day.equals("d1")) {

                    if (arr.get(i).get(6).toString().toLowerCase().trim().contains(club) && (arr.get(i).get(2).toString().toLowerCase().trim().contains("10/04/2024") || arr.get(i).get(2).toString().toLowerCase().trim().contains("10/4/2024"))) {
                        parent.add(arr.get(i));
                    }
                }
                else if(day.equals("d2")) {

                    if (arr.get(i).get(6).toString().toLowerCase().trim().contains(club) && (arr.get(i).get(2).toString().toLowerCase().trim().contains("11/04/2024") || arr.get(i).get(2).toString().toLowerCase().trim().contains("11/4/2024"))) {
                        parent.add(arr.get(i));
                    }
                }
                else if(day.equals("d3")) {

                    if (arr.get(i).get(6).toString().toLowerCase().trim().contains(club) && (arr.get(i).get(2).toString().toLowerCase().trim().contains("12/04/2024") || arr.get(i).get(2).toString().toLowerCase().trim().contains("12/4/2024"))) {
                        parent.add(arr.get(i));
                    }
                }
                else if(day.equals("d4")) {

                    if (arr.get(i).get(6).toString().toLowerCase().trim().contains(club) && (arr.get(i).get(2).toString().toLowerCase().trim().contains("13/04/2024") || arr.get(i).get(2).toString().toLowerCase().trim().contains("13/4/2024"))) {
                        parent.add(arr.get(i));
                    }
                }
                if(club.equals("all") && day.equals("d1")){
                    if ((arr.get(i).get(2).toString().toLowerCase().trim().contains("10/04/2024") || arr.get(i).get(2).toString().toLowerCase().trim().contains("10/4/2024"))) {
                        parent.add(arr.get(i));
                    }
                }
                else if(club.equals("all") && day.equals("d2")){
                    if ((arr.get(i).get(2).toString().toLowerCase().trim().contains("11/04/2024") || arr.get(i).get(2).toString().toLowerCase().trim().contains("11/4/2024"))) {
                        parent.add(arr.get(i));
                    }
                }
                else if(club.equals("all") && day.equals("d3")){
                    if ((arr.get(i).get(2).toString().toLowerCase().trim().contains("12/04/2024") || arr.get(i).get(2).toString().toLowerCase().trim().contains("12/4/2024"))) {
                        parent.add(arr.get(i));
                    }
                }
                else if(club.equals("all") && day.equals("d4")){
                    if ((arr.get(i).get(2).toString().toLowerCase().trim().contains("13/04/2024") || arr.get(i).get(2).toString().toLowerCase().trim().contains("13/4/2024"))) {
                        parent.add(arr.get(i));
                    }
                }
                if(club.equals("all") && day.equals("all")){
                    parent.add(arr.get(i));
                }
                if(arr.get(i).get(6).toString().trim().toLowerCase().contains(club) && day.equals("all")){
                    parent.add(arr.get(i));
                }

            }
            System.out.println("nikim"+parent.toString());

                l = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                h.notifyDataSetChanged();
                h = new EventDept_adapter(getActivity(), parent,"sc", "all");

                rec.setLayoutManager(l);
                rec.setAdapter(h);

        }

    }
    public void getEvent (){
        progressBar.setVisibility(View.VISIBLE);


        String temp=api.getEndPoint()+"/getevents";

        try {
            JsonObjectRequest j = new JsonObjectRequest(Request.Method.GET, temp, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {
                        arr=getList(response.getJSONArray("events"));
                        arr2=arr;
                        if(arr.size()>0) {
                            progressBar.setVisibility(View.GONE);

                            l=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
                            h = new EventDept_adapter(requireActivity(), arr,"sc", "all");
                            rec.setLayoutManager(l);
                            rec.setAdapter(h);
                        }
                        else{
                            progressBar.setVisibility(View.GONE);
                            retry.setVisibility(View.VISIBLE);
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
                    Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_SHORT).show();
                    //progressBar.setVisibility(View.GONE);
                }});
            RequestQueue q = Volley.newRequestQueue(getActivity());
            RetryPolicy retryPolicy = new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            );
            j.setRetryPolicy(retryPolicy);
            q.add(j);


        }catch (Exception e){
            Toast.makeText(getActivity(),e.toString(),Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            retry.setVisibility(View.VISIBLE);
            System.out.println("jjj");
        }

    }

    List<List> getList(JSONArray jsonArray) throws JSONException {
        List<List> outer = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            List<String> inner = new ArrayList<>();
            JSONObject j = jsonArray.getJSONObject(i);
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


            try {
                inner.add(j.getString("clubName"));
            } catch (Exception e) {
                inner.add("");
            }

            try {
                inner.add(j.getString("isMainEvent"));
            } catch (Exception e) {
                inner.add("");
            }
            outer.add(inner);

        }


        return outer;
    }

}