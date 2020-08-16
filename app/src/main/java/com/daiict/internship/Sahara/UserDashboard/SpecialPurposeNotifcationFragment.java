package com.daiict.internship.Sahara.UserDashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daiict.internship.Sahara.R;

import java.util.ArrayList;


public class SpecialPurposeNotifcationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_special_purpose_notifcation, container, false);
        RecyclerView rview = view.findViewById(R.id.recyclerview_notification_special_purpose);
        rview.setHasFixedSize(true);
        rview.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        //ArrayList list;
        //create list data


        SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swiper_notification_special_purpose);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Add the code to update the data from database

                //update the adapter too by using the code adapter.notifyDataSetChanged()
            }
        });
        return view;
    }
}