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


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.home_recyclerview);
        recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        ArrayList<HomeDataFetchClass> list = new ArrayList<HomeDataFetchClass>();
        list.add(new HomeDataFetchClass("Hello World NGO","12:00 Hrs","12-12-2020","Gandhinagar","Infocity"));
        list.add(new HomeDataFetchClass("Hello World NGO","12:00 Hrs","12-12-2020","Gandhinagar","Infocity"));
        list.add(new HomeDataFetchClass("Hello World NGO","12:00 Hrs","12-12-2020","Gandhinagar","Infocity"));
        list.add(new HomeDataFetchClass("Hello World NGO","12:00 Hrs","12-12-2020","Gandhinagar","Infocity"));
        list.add(new HomeDataFetchClass("Hello World NGO","12:00 Hrs","12-12-2020","Gandhinagar","Infocity"));

        final CardViewLikeShareAdapter adpater=new CardViewLikeShareAdapter(this.getActivity(),list);
        recyclerView.setAdapter(adpater);

        SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.home_swiper);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Add the code to update the data from database

                adpater.notifyDataSetChanged();
            }
        });


        return view;
    }
}