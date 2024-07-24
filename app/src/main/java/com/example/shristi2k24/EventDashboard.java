package com.example.shristi2k24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.squareup.picasso.Picasso;

import org.xml.sax.XMLReader;

public class EventDashboard extends AppCompatActivity {
TextView title,date,time;
TextView desc;

AppCompatButton winner, registerforevent;
String dept;
ImageView img,bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_dashboard);
        img=findViewById(R.id.image_eventdashboard);
        title=findViewById(R.id.event_dashboadtitle);
        dept=getIntent().getStringExtra("dept");
        String res="";
        try{
            res=String.valueOf(getIntent().getStringExtra("for"));
        }
        catch(Exception e){};

        date=findViewById(R.id.date_eventdashboard);
        time=findViewById(R.id.time_eventdashboard);
        winner =findViewById(R.id.winnerList_eventDashboard);
        if(res.equals("noresult")){
winner.setVisibility(View.GONE);
        }
        registerforevent =findViewById(R.id.registerforevent);

        registerforevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://shristi2k24.com/"));
                startActivity(i);
            }
        });
        bg=findViewById(R.id.eventdashbg);
        Glide.with(EventDashboard.this).load(R.drawable.stars).into(new DrawableImageViewTarget(bg));
desc=findViewById(R.id.desc_eventdashboard);

        String htmlContent=getIntent().getStringExtra("desc");

        desc.setText(Html.fromHtml(htmlContent, null, new MyTagHandler()));
        setCustomFont(desc);
      //  desc.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null);

        if(getIntent().getStringExtra("img")!=null) {
            Picasso.get().load(getIntent().getStringExtra("img")).into(img);
        }
        else{

        }

        if(getIntent().getStringExtra("date")!=null) {
            date.setText(getIntent().getStringExtra("date"));
        }
        if(getIntent().getStringExtra("time")!=null) {
            time.setText(getIntent().getStringExtra("time"));
        }
        if(getIntent().getStringExtra("desc")!=null) {
           // desc.setText(getIntent().getStringExtra("desc"));
        }
        if(getIntent().getStringExtra("event")!=null) {
            title.setText(getIntent().getStringExtra("event"));
        }

        winner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EventDashboard.this, ParticipantList.class);
                i.putExtra("dept",dept);
                i.putExtra("event",getIntent().getStringExtra("event"));
                startActivity(i);
            }
        });
    }
    private static class MyTagHandler implements Html.TagHandler {
        private boolean isListTagOpened = false;

        @Override
        public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
            if (tag.equalsIgnoreCase("i")) { // Check if the tag is <i>
                if (!opening) { // Check if it's a closing tag
                    removeStyle(output, StyleSpan.class); // Remove italic styling
                }
            } else if (tag.equalsIgnoreCase("ul") || tag.equalsIgnoreCase("ol")) { // Check if the tag is <ul> or <ol>
                isListTagOpened = opening; // Set the flag to indicate if list tag is opened or closed
            } else if (tag.equalsIgnoreCase("li")) { // Check if the tag is <li>
                if (isListTagOpened && opening) { // Check if it's an opening <li> tag within an opened list tag
                    output.append("\n"); // Add a newline character before each list item
                }
            }
        }

        private void removeStyle(Editable output, Class<? extends Object> style) {
            Object[] spans = output.getSpans(0, output.length(), style);
            for (Object span : spans) {
                output.removeSpan(span); // Remove the specified style span
            }
        }
    }
    private void setCustomFont(TextView textView) {
        try {
            Typeface typeface = ResourcesCompat.getFont(this, R.font.gugi);
            textView.setTypeface(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}