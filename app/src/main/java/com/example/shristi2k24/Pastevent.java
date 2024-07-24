package com.example.shristi2k24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shristi2k24.ApiLink;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pastevent extends AppCompatActivity {
ImageView bg;
past_adapter adapter,adapter2,adapter3;
EventDept_adapter adapter4;
ApiLink api;
RecyclerView recyclerView,recyclerView2, latestrec;
TextView title,latest_title,pastevent_title,pastteaserTitle,past_desc;
LinearLayoutManager l;
ImageSlider slider1,slider2;
List<List> arr=new ArrayList<>();
    List<String> arr2=new ArrayList<>();
    List<String> arr3=new ArrayList<>();
    List<List> arr4=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastevent);
        latestrec =findViewById(R.id.past_rec2);
        bg=findViewById(R.id.pastbg);
        api=new ApiLink();
        slider2=findViewById(R.id.past_slider2);
        Glide.with(Pastevent.this).load(R.drawable.stars).into(new DrawableImageViewTarget(bg));
        String activity= getIntent().getStringExtra("activity");
        slider1=findViewById(R.id.past_slider);
        recyclerView2=findViewById(R.id.past_rec0);
        recyclerView=findViewById(R.id.past_rec);

        title=findViewById(R.id.past_title);
        latest_title=findViewById(R.id.pasthydro_title);
        pastevent_title=findViewById(R.id.pastrobo_title);
        pastteaserTitle=findViewById(R.id.pastteaser_update);
        past_desc=findViewById(R.id.past_desc);


        if(activity.equals("dept")){

getEvent();


            ArrayList<SlideModel> imageList=new ArrayList<>();
            imageList.add(new SlideModel("https://i.postimg.cc/9fjm333y/tractorr.jpg", ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/9MmcMGQM/roboo.jpg", ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/HxBbN4N1/drone.jpg", ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/sx1yPsSC/csee.jpg", ScaleTypes.FIT));

            slider1.setImageList(imageList);

            /*





            recyclerView=findViewById(R.id.past_rec);

            recyclerView.setLayoutManager(l);
            arr2=new ArrayList<>();
            arr2.add("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PXSVHxzPKL0?si=UXrkZ6x_m6rOjObD\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            arr2.add("Teaser 2021");
            arr.add(arr2);
            arr2=new ArrayList<>();
            arr3.add("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PXSVHxzPKL0?si=UXrkZ6x_m6rOjObD\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            arr3.add("Teaser 2021");
            arr.add(arr3);
*/


            l=new LinearLayoutManager(Pastevent.this,LinearLayoutManager.HORIZONTAL,false);
            arr3.add("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Z-FZeyxdzI0?si=IgTArfJjXQXqXwYA\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            arr3.add("Robowar 2k22");
            arr4.add(arr3);
             arr3=new ArrayList<>();

            arr3.add("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/AJ7pNbngua4?si=x9dJHrRl1CNxa9QZ\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            arr3.add("Robowar 2k18");
            arr4.add(arr3);




            l=new LinearLayoutManager(Pastevent.this,LinearLayoutManager.HORIZONTAL,false);
  adapter2=new past_adapter(Pastevent.this,arr4,"");
            //adapter=new past_adapter(Pastevent.this,arr);
            //recyclerView.setAdapter(adapter);
            recyclerView2.setLayoutManager(l);
            recyclerView2.setAdapter(adapter2);


pastteaserTitle.setVisibility(View.GONE);
  }
        else if(activity.equals("club")){
title.setText("Pre Events");
latest_title.setVisibility(View.GONE);
latestrec.setVisibility(View.GONE);
pastevent_title.setVisibility(View.GONE);
pastteaserTitle.setVisibility(View.GONE);
recyclerView.setVisibility(View.GONE);
recyclerView2.setVisibility(View.GONE);
            slider1.setVisibility(View.GONE);
            slider2.setVisibility(View.VISIBLE);
            ArrayList<SlideModel> imageList=new ArrayList<>();
            imageList.add(new SlideModel("https://i.postimg.cc/SjFmrcVW/autocad.jpg", ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/h4Jx2gpj/backend.jpg", ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/dQzCXXx9/android.jpg",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/wvn1Cy0B/castmaster.jpg",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/pr8mRW6J/gis.jpg",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/kMt6xsgR/photography.jpg",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/zXZLphyt/realtime.jpg",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/wTX1rBJ6/present.jpg",ScaleTypes.FIT));
           // imageList.add(new SlideModel(R.drawable.snakeladder,ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/8zwj1nt9/munworkshop.jpg",ScaleTypes.FIT));


            slider2.setImageList(imageList);
past_desc.setText("Each department is hosting pre-events to prepare participants for the main festivities. The Agricultural department is organizing a Presentation GIS Workshop and an AutoCAD Workshop. Civil Engineering Dept is offering the Cast Master Workshop,etc. Computer Science Dept is conducting workshops on Real-Time IoT Integration, Android Development, and Backend Development. Additionally, the ECE Department is hosting the E-Snake and Ladder event. These pre-events aim to equip participants with essential skills and knowledge before the main event");
        }
        else if(activity.equals("mun")){


title.setText("Model Of Unites Nation (NERIST)");

            slider1.setVisibility(View.VISIBLE);
            slider2.setVisibility(View.GONE);
            ArrayList<SlideModel> imageList=new ArrayList<>();
            imageList.add(new SlideModel("https://i.postimg.cc/SNhscpPH/mun1.jpg", ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/pLVL1JRZ/mthree.png", ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/fRHR4Sbh/mtwo.png",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/HkPdvGSY/mfour.png",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/SNhscpPH/mun1.jpg",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/NMRt0KQF/mseven.png",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/Bbs0PJvg/msix.png",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/8zwj1nt9/munworkshop.jpg",ScaleTypes.FIT));
            slider1.setImageList(imageList);
            past_desc.setText("The Model United Nations (MUN) at Nerist is an engaging simulation of the United Nations where students take on the roles of delegates representing various countries. Participants engage in debates and discussions on global issues, working together to find diplomatic solutions and draft resolutions. The MUN provides a platform for students to enhance their public speaking, negotiation, and diplomacy skills while gaining a deeper understanding of international relations. It fosters critical thinking and encourages collaboration among participants, creating a dynamic and enriching experience for all involved");
latest_title.setVisibility(View.GONE);
pastevent_title.setVisibility(View.GONE);
pastteaserTitle.setVisibility(View.GONE);


        }
        else if(activity.equals("talk")){
            title.setText("Shristi Talk");
            ArrayList<SlideModel> imageList=new ArrayList<>();
            imageList.add(new SlideModel("https://i.postimg.cc/d04tYktY/ac.jpg", ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/ydx6Y1kS/dn.jpg", ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/rmHVDBrZ/jp.jpg",ScaleTypes.FIT));
            imageList.add(new SlideModel("https://i.postimg.cc/5yFxLs54/kk.jpg",ScaleTypes.FIT));
            slider1.setImageList(imageList);
            past_desc.setText("Nerist's Shristi Talk is an engaging event that features captivating public-speaking presentations. Renowned speakers from diverse fields are invited to share their insights, experiences, and innovative ideas with the audience. Centered around themes of technology, creativity, and interdisciplinary collaboration, Shristi Talk aims to inspire critical thinking and foster intellectual curiosity among attendees. This event serves as an opportunity for exchanging ideas, sparking meaningful discussions, and contributing to a vibrant culture of innovation within the Nerist community");
            arr3.add("https://i.postimg.cc/bw49Rrjq/aj.jpg");
            arr3.add("Ashu Jain");
            arr3.add("Ashu Jain’s journey embodies resilience and reinvention. From nurturing her family to pursuing higher education, she defied societal norms. Now, as an influencer promoting active aging, she inspires thousands. Age isn’t just a number for her; it’s a testament to her determination to embrace life’s adventures. #AgeWithGrace #LiveFully”\n" +
                    "\n" +
                    "Catch her on 13th April 2024, silver jubilee hall, NERIST, 3:00pm onwards");
            arr4.add(arr3);
arr3=new ArrayList<>();
            arr3.add("https://i.postimg.cc/Hx90Ht8L/bn.jpg");
            arr3.add("Bijay Nair");
            arr3.add("Meet Lt. Cdr Bijay Nair (retd), a decorated Naval Officer turned ultra-distance runner, author, blogger, and TEDx speaker. With a passion for service and storytelling, he inspires through humor and resilience. From the battlefield to the marathon trails, his journey embodies courage, determination, and endless inspiration. #Inspiration #UltraRunner #NavyPride”\n" +
                    "\n" +
                    "Catch him on 13th April 2024, silver jubilee hall, NERIST, 3:00pm onwards\n" +
                    "#shristi2024");
            arr4.add(arr3);
            arr3=new ArrayList<>();


            arr3.add("https://i.postimg.cc/nLtQzDJ9/ph.jpg");
            arr3.add("Pallabi Hazarika");
            arr3.add("Pallabi Hazarika, the visionary behind Prajapati AssameseJewellery, embarked on a journey to celebrate Assamese culture while empowering women. From humble beginnings to prestigious accolades, she’s a beacon of creativity and compassion. Through her designs, she not only preserves heritage but also champions noble causes like Hargilla Bird conservation. #Empowerment #CulturalPride #SocialResponsibility”\n" +
                    "\n" +
                    "Catch her on 10th April 2024, silver jubilee hall, NERIST, 5:30pm onwards\n" +
                    "#shristi2024\n" +
                    "#shristitalks\n" +
                    "#wartalaap");
            arr4.add(arr3);
            arr3=new ArrayList<>();


            arr3.add("https://i.postimg.cc/76HG1rbx/tp.jpg");
            arr3.add("Tachange Phassang");
            arr3.add("Meet Mr. Tachang Phassang: A beacon of inspiration from the tranquil valleys of Arunachal Pradesh. His journey echoes resilience and determination, navigating life’s highs and lows with grace. From the mountains to the world, his story inspires us to reach for the peaks of our dreams. #ArunachalPride #Inspiration #Resilience”\n" +
                    "\n" +
                    "Catch him on 12th April 2024, silver jubilee hall, NERIST, 5:30pm onwards\n" +
                    "#shristi2024\n" +
                    "#shristitalks\n" +
                    "#wartalaap");
            arr4.add(arr3);
            arr3=new ArrayList<>();


            arr3.add("https://i.postimg.cc/cJMt8Lx9/tm.jpg");
            arr3.add("Tenzin Metoh");
            arr3.add("Meet Tenzin Metoh: a beacon of tenacity and self-sufficiency. With unwavering dedication, she surpasses expectations, showcasing resilience and proactive prowess. As a professional, she embodies adaptability and resourcefulness, thriving in dynamic environments. Her portfolio speaks volumes, reflecting her independent spirit and meaningful contributions. #Tenacity #Resilience #Success”\n" +
                    "\n" +
                    "Catch her on-stage on 10th April 2024, Silver jubilee Hall, NERIST, 5:30pm onwards");
            arr4.add(arr3);
            arr3=new ArrayList<>();


            arr3.add("https://i.postimg.cc/BbZTv12B/bh.jpg");
            arr3.add("Bipasha Hrangkhawl");
            arr3.add("From the villages of Tripura to the skies of Agartala, Bipasha Hrangkhawl’s journey reflects resilience and determination. A proud engineer turned Air Traffic Controller, balancing career aspirations with family obligations. Thriving in every challenge life throws my way. #TripuraToTheSkies #ResilientJourney #CareerAndFamily”\n" +
                    "\n" +
                    "Catch her on 13th April 2024, silver jubilee hall, NERIST, 3:00pm onwards");
            arr4.add(arr3);
            arr3=new ArrayList<>();


            arr3.add("https://i.postimg.cc/mDs30nDq/kg.jpg");
            arr3.add("Kaustoov Gopal Goswami");
            arr3.add("Meet Kaustoov Gopal Goswami, the force behind Axom Urja and now pioneering North East India’s first meadery. With a passion for sustainability and social impact, he’s reshaping industries and empowering communities. From solar energy to artisanal honey wine, his ventures redefine innovation. #Sustainability #SocialImpact #Entrepreneurship”\n" +
                    "\n" +
                    "Catch him on 12th April 2024, silver jubilee hall, NERIST, 5:30pm onwards\n" +
                    "#shristi2024\n" +
                    "#shristitalks\n" +
                    "#wartalaap");
            arr4.add(arr3);
            arr3=new ArrayList<>();


            l=new LinearLayoutManager(Pastevent.this,LinearLayoutManager.VERTICAL,false);
            adapter2=new past_adapter(Pastevent.this,arr4,"talk");
            latestrec.setLayoutManager(l);
            latestrec.setAdapter(adapter2);
 pastteaserTitle.setVisibility(View.GONE);
 pastevent_title.setVisibility(View.GONE);
        }
    }

    public String getURLForResource (int resourceId) {
        //use BuildConfig.APPLICATION_ID instead of R.class.getPackage().getName() if both are not same
        return Uri.parse("android.resource://"+ Objects.requireNonNull(R.class.getPackage()).getName()+"/" +resourceId).toString();
    }

    public void getEvent (){
        // progressBar.setVisibility(View.VISIBLE);


        String temp=api.getEndPoint2()+"//events";

        try {
            JsonArrayRequest j = new JsonArrayRequest(Request.Method.GET, temp, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        System.out.println("jkdf : "+response.toString());
                        arr=getList(response);
                        if(arr.size()>0) {
                            l=new LinearLayoutManager(Pastevent.this,LinearLayoutManager.HORIZONTAL,false);
                            adapter4 = new EventDept_adapter(Pastevent.this, arr,"sc", "all");
                            latestrec.setLayoutManager(l);
                            latestrec.setAdapter(adapter4);
                        }

                    }
                    catch (Exception e){
                        System.out.println("jkd99"+e.toString());
                    }

                }}, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(Pastevent.this,error.toString(),Toast.LENGTH_SHORT).show();
                    //progressBar.setVisibility(View.GONE);
                }});
            RequestQueue q = Volley.newRequestQueue(Pastevent.this);
            RetryPolicy retryPolicy = new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            );
            j.setRetryPolicy(retryPolicy);
            q.add(j);


        }catch (Exception e){
            Toast.makeText(Pastevent.this,e.toString(),Toast.LENGTH_SHORT).show();
            //  progressBar.setVisibility(View.GONE);
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