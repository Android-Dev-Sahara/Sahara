package com.daiict.internship.Sahara.UserDashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        RecyclerView recyclerView=view.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        ArrayList<DonationClass> list=new ArrayList<>();
        list.add(new DonationClass("Reliance chockdi","20"));
        list.add(new DonationClass("Vijaynagar","5"));
        list.add(new DonationClass("Paldi","30"));
        list.add(new DonationClass("Paldi","30"));
        list.add(new DonationClass("Paldi","30"));
        list.add(new DonationClass("Paldi","30"));
        list.add(new DonationClass("Paldi","30"));

        donationAdapter dAdapter=new donationAdapter(this.getActivity(),list);
        recyclerView.setAdapter(dAdapter);

        return view;
    }
}