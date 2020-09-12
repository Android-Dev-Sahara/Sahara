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
import com.daiict.internship.Sahara.SignUp.SignUpSingle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;


public class GeneralPurposeNotificationFragment extends Fragment {
    public static ArrayList<GeneralNotificationClass> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_general_purpose_notification, container, false);
        RecyclerView rview = view.findViewById(R.id.recyclerview_notification_general_purpose);
        rview.setHasFixedSize(true);
        rview.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        Collections.reverse(list);
        //Delete above One once checked
        final NotificationGeneralNotificationAdapter notificationGeneralNotificationAdapter = new NotificationGeneralNotificationAdapter(this.getActivity(), list);
        rview.setAdapter(notificationGeneralNotificationAdapter);

        SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swiper_notification_general_purpose);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Add the code to update the data from database

                notificationGeneralNotificationAdapter.notifyDataSetChanged();
            }
        });


        return view;
    }
}