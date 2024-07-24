package com.example.shristi2k24;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultFragment extends Fragment {
    RecyclerView recyclerView;
    HomeDept_adapter dept;
    ImageView bg;
    LinearLayoutManager linearLayoutManager;
    ArrayList<String> arr=new ArrayList<>(Arrays.asList("Computer Science Engg. Dept","Mechanical Engineering Dept","Civil Engineering Dept","Electronic and Communication Engg. Dept","Forestry Engineering Dept","Electrical Engineering Dept","Agricultural Engineering Dept","Techno Club","Management Club"));
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_result, container, false);

        bg=view.findViewById(R.id.mainf_bg);
        Glide.with(getActivity()).load(R.drawable.stars).into(new DrawableImageViewTarget(bg));
        recyclerView=view.findViewById(R.id.rec_homef);
        linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        dept=new HomeDept_adapter(getActivity(),arr);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(dept);

        return view;
    }
}