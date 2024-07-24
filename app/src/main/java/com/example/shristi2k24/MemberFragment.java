package com.example.shristi2k24;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.airbnb.lottie.L;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemberFragment extends Fragment {
    List<List> arr=new ArrayList<>();
    RecyclerView recyclerView;
    LinearLayoutManager l_committee;
    MemberAdapter memberAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_member, container, false);

        //members
        ImageView om=view.findViewById(R.id.memberpage_img3);
        Picasso.get().load("https://scontent.fmaa8-1.fna.fbcdn.net/v/t39.30808-6/354221535_1653941611773917_4140495346921008530_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=5f2048&_nc_ohc=ZrGmca1lpssAb4Jd_Ep&_nc_ht=scontent.fmaa8-1.fna&oh=00_AfBZ3FklGgVq67RjJbPediRRR0RjDmGkng3hIlzQshRfew&oe=6615EC60").into(om);

        ImageView tl=view.findViewById(R.id.memberpage_img1);
        Picasso.get().load("https://i.postimg.cc/3NQqf95J/tl.jpg").into(tl);

        ShapeableImageView avtu=view.findViewById(R.id.memberpage_img2);
        Picasso.get().load("https://i.postimg.cc/0N6H8h9y/avtu.jpg").into(avtu);

        recyclerView=view.findViewById(R.id.memberPage_rec1);
        l_committee=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(l_committee);

        dataAdd("https://www.nerist.ac.in/sites/default/files/2016-05/MMS.jpg","Dr. Madhusudhan Mishra","Assoc. Prof. ECE","Chief Coordinator","https://www.nerist.ac.in/sites/default/files/2022-05/IMG_8976.JPG","Dr. Raju Barthakur","Professor,HSS","Advisor");
        dataAdd("https://www.nerist.ac.in/sites/default/files/2016-10/Passport%20001.jpg","Dr. Thaneswer Patel","Assoc. Prof. AE","Advisor","https://www.nerist.ac.in/sites/default/files/2022-04/PKPandey.jpeg","Dr. Pankaj Kumar Pandey","Assoc. Prof. AE","Advisor");
        dataAdd("https://www.nerist.ac.in/sites/default/files/2023-09/001.jpeg","DR. AJANTA KALITA","Assoc. Prof. CE","Member","https://www.nerist.ac.in/sites/default/files/2016-05/nbt.jpg","Dr. Nabam Teyi","Asstt. Prof. ME","Member");
        dataAdd("https://www.nerist.ac.in/sites/default/files/2023-10/profile.jpg","Dr. Moirangthem Edison Singh","Asstt. Prof. ECE","Member","https://www.nerist.ac.in/sites/default/files/2020-09/g1846h.jpg","Dr. Kunal Borah","Asstt. Prof. PH","Member");
        dataAdd("https://www.nerist.ac.in/sites/default/files/2016-05/piyali.jpg","DR. Piyali Das","Asstt. Prof. EE","Member","https://www.nerist.ac.in/sites/default/files/2017-01/ajit%5B1%5D.png","Dr. Ajit Kr. Singh Yadav","Asstt. Prof. CSE","Member");
            dataAdd("https://www.nerist.ac.in/sites/default/files/2021-07/1.jpg","Dr.Shibabrata Choudhury","Asstt. Prof. CMS","Member","https://www.nerist.ac.in/sites/default/files/2019-05/Photo_DR%20M%20Hassan_UOA.jpg","Dr. Mohammad Hassan","Asstt. Prof. MA","Member");
        dataAdd("https://www.nerist.ac.in/sites/default/files/2017-07/Ashish.jpg","Dr. Ashish Paul","Asstt. Prof. FO","Member","https://www.nerist.ac.in/sites/default/files/2022-05/akho%20passport1.jpg","Dr. Akho John Richa","Asstt. Prof. ECE","Member");
         memberAdapter=new MemberAdapter(arr,getActivity(),"faculity");
         recyclerView.setAdapter(memberAdapter);

        arr= new ArrayList<>();
         dataAdd("","Shounak Chakraborty","","","","Karka Karlo","","");
        dataAdd("","Aditya Kumar","","","","Plabipriya Bordoloi","","");
        memberAdapter=new MemberAdapter(arr,getActivity(),"jos");
        recyclerView=view.findViewById(R.id.memberPage_rec2);
        l_committee=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(l_committee);
        recyclerView.setAdapter(memberAdapter);


        arr= new ArrayList<>();
        dataAdd("https://i.postimg.cc/c4Pr6nSM/subhu.jpg","Subhu Richo","","","https://i.postimg.cc/rFZ5jsLK/uddipan.jpg","Uddipan Bhattacharjee","","");
        memberAdapter=new MemberAdapter(arr,getActivity(),"jos");
        recyclerView=view.findViewById(R.id.memberPage_rec3);
        l_committee=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(l_committee);
        recyclerView.setAdapter(memberAdapter);



        arr= new ArrayList<>();
        dataAdd("https://i.postimg.cc/y8S3TTPb/arun.jpg","Arun Kr. Chunarkar","","","https://i.postimg.cc/hvHV1ZHp/kendarstu.jpg","Kendar Ete","","");
        memberAdapter=new MemberAdapter(arr,getActivity(),"single");
        recyclerView=view.findViewById(R.id.memberPage_rec4);
        l_committee=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(l_committee);
        recyclerView.setAdapter(memberAdapter);

        arr= new ArrayList<>();
        dataAdd("https://i.postimg.cc/hvHV1ZHp/kendarstu.jpg","Kendar Ete","","","","","","");
        memberAdapter=new MemberAdapter(arr,getActivity(),"single");
        recyclerView=view.findViewById(R.id.memberPage_rec5);
        l_committee=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(l_committee);
        recyclerView.setAdapter(memberAdapter);


        arr= new ArrayList<>();
        dataAdd("","Liza Hazarika","","","","","","");
        memberAdapter=new MemberAdapter(arr,getActivity(),"single");
        recyclerView=view.findViewById(R.id.memberPage_rec6);
        l_committee=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(l_committee);
        recyclerView.setAdapter(memberAdapter);

        arr= new ArrayList<>();
        dataAdd("","Millo Novin","","","","","","");
        memberAdapter=new MemberAdapter(arr,getActivity(),"single");
        recyclerView=view.findViewById(R.id.memberPage_rec66);
        l_committee=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(l_committee);
        recyclerView.setAdapter(memberAdapter);

        arr= new ArrayList<>();
        dataAdd("https://i.postimg.cc/L4kQ6tFL/junicastu.jpg","Junica Marbaniang","MUN Secy. General","","https://i.postimg.cc/JnRyMCWf/marisha.jpg","Marisha Ojha","MUN Secy. I/C","");
        dataAdd("https://www.nerist.ac.in/sites/default/files/inline-images/rajdeep.png","Rajdeep Borthakur","MUN Secy. General","","","","","");
        memberAdapter=new MemberAdapter(arr,getActivity(),"dept");
        recyclerView=view.findViewById(R.id.memberPage_rec7);
        l_committee=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(l_committee);
        recyclerView.setAdapter(memberAdapter);




       arr= new ArrayList<>();
       dataAdd("https://i.postimg.cc/XYDBfzdF/jonak.jpg","Jonak Saha ","Techno I/C","","https://i.postimg.cc/1RHt0dZt/supratim.jpg","Supratim Roy","Techno I/C","");
       dataAdd("https://i.postimg.cc/tgjJNG7s/gaurab.jpg","Gaurav Changmai ","Techno I/C","","https://i.postimg.cc/J0Qp6L5P/spstu.jpg","Subhash Paul","Website I/C","");
       dataAdd("https://i.postimg.cc/W4w39YJX/images.jpg","Hibjul Ahmed","Website I/C","","https://i.postimg.cc/gjpMHJ8x/acstu.jpg","Aditya Chauhan","Shristi Talk I/C","");
       dataAdd("https://i.postimg.cc/FHHB67qc/md.jpg","Mayuri Das","Shristi Talk I/C","","https://i.postimg.cc/0jK4c3H4/dcstu.jpg","Deepchayan Roy","Workshop I/C","");
        dataAdd("https://i.postimg.cc/T3n6Ry0s/sgyan.jpg","Shubham Gyan","Workshop I/C","","https://i.postimg.cc/fRYfBZWX/bishakhastu.png","Bishakha Gogoi","Event I/C","");
        dataAdd("https://i.postimg.cc/7LgYQsjf/pborah.png","Parismita Borah","Event I/C","","","Tasso Dogin","Hospitality I/C","");
        dataAdd("","Tajay Marbom","Hospitality I/C","","https://i.postimg.cc/9fVjzWNQ/runastu.jpg","Runa Nasrin","Hospitality I/C","");
       dataAdd("","Rohit Pasi","Refreshment I/C","","https://i.postimg.cc/500TFj5b/vikashstu.jpg","Vikash Sahani","Refreshment I/C","");
        dataAdd("","Gitashree Hazarika","Refreshment I/C","","https://i.postimg.cc/28yZ1YBm/abisekh.jpg","Abhisekh Kumar","Chief Volunteer","");
        dataAdd("https://llm1041430350.blob.core.windows.net/shristi-images/8135a7b3-3a4e-4e24-9e57-4e00b7189fceIMG-20240329-WA0060.jpg?sv=2022-11-02&ss=b&srt=sco&sp=rwdlaciytfx&se=2024-04-30T00:15:08Z&st=2024-04-02T16:15:08Z&spr=https&sig=%2BOjFAqiCutR7Urdzz9GU5LF3QhsJpMP1NQLRlRI5Znk%3D","Drishmita Borah","Techno Club I/C","","https://llm1041430350.blob.core.windows.net/shristi-images/e65a427a-57dc-4428-86ce-e647855f71ab1000366462.jpg?sv=2022-11-02&ss=b&srt=sco&sp=rwdlaciytfx&se=2024-04-30T00:15:08Z&st=2024-04-02T16:15:08Z&spr=https&sig=%2BOjFAqiCutR7Urdzz9GU5LF3QhsJpMP1NQLRlRI5Znk%3D","Abhinab Sharma","Techno Club I/C","");
        dataAdd("https://i.postimg.cc/k4Js2ZmS/nstu.jpg","Narayan Barman","Techno Club I/C","","","","","");
        memberAdapter=new MemberAdapter(arr,getActivity(),"incharge");
        recyclerView=view.findViewById(R.id.memberPage_rec8);
        l_committee=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(l_committee);
        recyclerView.setAdapter(memberAdapter);


        arr= new ArrayList<>();
        dataAdd("https://i.postimg.cc/hvHV1ZHp/kendarstu.jpg","Kendar Ete","AE Dept. I/C","","","Abindo Tayeng","AE Dept. I/C","");
        dataAdd("https://media.licdn.com/dms/image/D4D03AQF_ZwQP09LCBg/profile-displayphoto-shrink_800_800/0/1690514909221?e=2147483647&v=beta&t=enPGqODv7xlnU36tt8qemLJNICnipM-reQpyXuqgSOM","Tomson Laishram","CSE Dept. I/C","","https://i.postimg.cc/85yCGF4v/kritanjan.jpg","Kritanjan Bhattacharjee","EE Dept. I/C","");
        dataAdd("https://i.postimg.cc/4dRCjXpg/deuristu.jpg","Nistha S. D. Bhoralee","FO Dept. I/C","","","Binud Payeng","ME Dept. I/C","");
        dataAdd("https://i.postimg.cc/4xjjhXL9/nilay.jpg","Nilay Bhattacharjee","ME Dept. I/C","","","Dekey Yami","MBA Dept. I/C","");
        dataAdd("https://i.postimg.cc/CMJdg258/td.jpg","Tonoy Deb","EE Dept. I/C","","https://i.postimg.cc/tghvZWnK/kishan.jpg","Kishan Kr. Rai","ECE Dept. I/C","");
        dataAdd("https://i.postimg.cc/Qxwff0QL/anjalithakur.jpg","Anjali Thakur","AE Dept. I/C","","https://i.postimg.cc/rp1dBF7G/ankit.png ","Ankit Kr. Yadav","Civil Dept. I/C","");
         dataAdd("https://i.postimg.cc/3WMc6Bsx/pstu.jpg","Priyanshu Kumar","Civil Dept. I/C","","https://i.postimg.cc/KvzWq1CT/jugal.jpg","Jugal K. Das","CSE Dept. I/C","");
        dataAdd("https://i.postimg.cc/8zp2VyF7/anshstu.jpg","Ansh Sandilya","ECE Dept. I/C","","https://i.postimg.cc/K80dcnLJ/bsstu.jpg","Bakin Siram","FO Dept. I/C","");
       dataAdd("https://media.licdn.com/dms/image/C5603AQGO9ovTfEvwxA/profile-displayphoto-shrink_800_800/0/1656670124944?e=2147483647&v=beta&t=TemMFG2R0n8uQGOWsgEqgg9J9MVLe_t7kX4d0LmcGw8","Bishnu Barman","MBA Dept. I/C","","https://i.postimg.cc/pd84f341/dahun.jpg","Dahun Shabat","Electrical Dept I/c","");
      /*


       //


*/
        memberAdapter=new MemberAdapter(arr,getActivity(),"dept");
        recyclerView=view.findViewById(R.id.memberPage_rec9);
        l_committee=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(l_committee);
        recyclerView.setAdapter(memberAdapter);



        return view;
    }

    public void dataAdd(String i1,String it1,String it2,String it3,String i2,String i2t1,String i2t2,String i2t3){
        List<String> inner=new ArrayList<>();
        inner.add(i1);
        inner.add(it1);
        inner.add(it2);
        inner.add(it3);
        inner.add(i2);
        inner.add(i2t1);
        inner.add(i2t2);
        inner.add(i2t3);
        arr.add(inner);

    }
    public String getURLForResource (int resourceId) {
        //use BuildConfig.APPLICATION_ID instead of R.class.getPackage().getName() if both are not same
        return Uri.parse("android.resource://"+ Objects.requireNonNull(R.class.getPackage()).getName()+"/" +resourceId).toString();
    }
}