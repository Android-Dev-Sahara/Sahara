package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.daiict.internship.Sahara.R;

import java.util.ArrayList;

public class donation_common_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_common_activity);

        RecyclerView recyclerView =findViewById(R.id.common_recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<DonationCommonClass> list=new ArrayList<>();

        list.add(new DonationCommonClass("Rahul","Hydrabad","21-5-1990","09:30","9845679010",12));
        list.add(new DonationCommonClass("Rahul","Hydrabad","21-5-1990","09:30","9845679010",12));
        list.add(new DonationCommonClass("Rahul","Hydrabad","21-5-1990","09:30","9845679010",12));
        list.add(new DonationCommonClass("Rahul","Hydrabad","21-5-1990","09:30","9845679010",12));
        list.add(new DonationCommonClass("Rahul","Hydrabad","21-5-1990","09:30","9845679010",12));
        list.add(new DonationCommonClass("Rahul","Hydrabad","21-5-1990","09:30","9845679010",12));
        list.add(new DonationCommonClass("Rahul","Hydrabad","21-5-1990","09:30","9845679010",12));
        list.add(new DonationCommonClass("Rahul","Hydrabad","21-5-1990","09:30","9845679010",12));
        list.add(new DonationCommonClass("Rahul","Hydrabad","21-5-1990","09:30","9845679010",12));

        CommonDonationAdapter commonDonationAdapter=new CommonDonationAdapter(donation_common_activity.this,list);
        recyclerView.setAdapter(commonDonationAdapter);

    }
}