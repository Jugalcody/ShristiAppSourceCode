package com.example.shristi2k24;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomeFragment extends Fragment {

ImageView bg;
ImageSlider slider1;
    List<String> arr2=new ArrayList<>();
    LinearLayoutManager l;
    List<List> arr=new ArrayList<>();
    past_adapter adapter;
RecyclerView recyclerView;
ShapeableImageView dept,club,talkbut,mun,insta,youtube;

WebView talk;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        bg=view.findViewById(R.id.home_backimg);
        Glide.with(getActivity()).load(R.drawable.stars).into(new DrawableImageViewTarget(bg));


       dept=view.findViewById(R.id.homepage_r1);
        //Picasso.get().load("https://t4.ftcdn.net/jpg/02/85/82/89/360_F_285828947_7LvtUCUFARVTzcxvPDM2EkTuknA50buy.jpg").into(dept);
       club=view.findViewById(R.id.homepage_r2);
        //Picasso.get().load("https://images.squarespace-cdn.com/content/v1/63e9ab97973c5e0fdecf81cd/61abd9a3-549b-41ee-b557-d06dce488829/PRE_logo_trans.png").into(club);

       talkbut=view.findViewById(R.id.homepage_r3);
       mun=view.findViewById(R.id.homepage_r4);
       recyclerView=view.findViewById(R.id.k);

        arr2=new ArrayList<>();
        arr2.add("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/0Ktnw2dmAJo?si=g15QX7CfWmPjYtl_\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
        arr2.add("Teaser 2023");
        arr.add(arr2);
        arr2=new ArrayList<>();

        arr2.add("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/IDRJCkO2H2k?si=DWgJbo4nwsmKaOuP\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
        arr2.add("Teaser 2k22");
        arr.add(arr2);
        arr2=new ArrayList<>();

        arr2.add("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KoNBJI6ccFc?si=hZhH-g4SNt6yGTFX\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
        arr2.add("Teaser 2k18");
        arr.add(arr2);


        l=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        adapter=new past_adapter(getActivity(),arr,"");
        //adapter=new past_adapter(Pastevent.this,arr);
        //recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(l);
        recyclerView.setAdapter(adapter);


        talk=view.findViewById(R.id.homepage_webpg);
        slider1=view.findViewById(R.id.homepage_slider1);

        insta=view.findViewById(R.id.insta);
        youtube=view.findViewById(R.id.utube);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.instagram.com/shristi_2k24?utm_source=ig_web_button_share_sheet&igsh=ZDNlZDc0MzIxNw=="));
                startActivity(i);
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.youtube.com/@ShristiNerist2k23"));
                startActivity(i);
            }
        });

        ArrayList<SlideModel> imageList=new ArrayList<>();
        imageList.add(new SlideModel("https://i.postimg.cc/bw49Rrjq/aj.jpg",ScaleTypes.FIT));
        imageList.add(new SlideModel("https://i.postimg.cc/mDs30nDq/kg.jpg", ScaleTypes.FIT));
        imageList.add(new SlideModel("https://i.postimg.cc/Hx90Ht8L/bn.jpg",ScaleTypes.FIT));
        imageList.add(new SlideModel("https://i.postimg.cc/BbZTv12B/bh.jpg",ScaleTypes.FIT));
        imageList.add(new SlideModel("https://i.postimg.cc/5yPwQN3d/dd.jpg",ScaleTypes.FIT));
        imageList.add(new SlideModel("https://i.postimg.cc/8P0R1ccL/rd.jpg",ScaleTypes.FIT));
        imageList.add(new SlideModel("https://i.postimg.cc/nLtQzDJ9/ph.jpg",ScaleTypes.FIT));
        imageList.add(new SlideModel("https://i.postimg.cc/cJMt8Lx9/tm.jpg",ScaleTypes.FIT));
        imageList.add(new SlideModel("https://i.postimg.cc/76HG1rbx/tp.jpg",ScaleTypes.FIT));
        imageList.add(new SlideModel("https://i.postimg.cc/tTvTh1L5/sandeeptalk.jpg",ScaleTypes.FIT));
        slider1.setImageList(imageList);





        String videotalk="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PXSVHxzPKL0?si=UXrkZ6x_m6rOjObD\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        talk.loadData(videotalk,"text/html","utf-8");
        talk.getSettings().setJavaScriptEnabled(true);
        talk.setWebChromeClient(new WebChromeClient());
        talk.setBackgroundColor(Color.TRANSPARENT);



          dept.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent i=new Intent(getActivity(), Pastevent.class);
                  i.putExtra("activity","dept");
                  startActivity(i);
              }
          });


        club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Pastevent.class);
                i.putExtra("activity","club");
                startActivity(i);
            }
        });


        talkbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Pastevent.class);
                i.putExtra("activity","talk");
                startActivity(i);
            }
        });


        mun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Pastevent.class);
                i.putExtra("activity","mun");
                startActivity(i);
            }
        });


        return view;
    }

    public String getURLForResource (int resourceId) {
        //use BuildConfig.APPLICATION_ID instead of R.class.getPackage().getName() if both are not same
        return Uri.parse("android.resource://"+ Objects.requireNonNull(R.class.getPackage()).getName()+"/" +resourceId).toString();
    }
}